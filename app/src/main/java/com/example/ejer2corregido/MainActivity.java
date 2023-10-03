package com.example.ejer2corregido;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ejer2corregido.Actividades.CrearCocheActivity;
import com.example.ejer2corregido.Modelos.Bici;
import com.example.ejer2corregido.Modelos.Coche;
import com.example.ejer2corregido.Modelos.Moto;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //Atributos de la Vista
    private TextView txtCantCoches;
    private TextView txtCantMotos;
    private TextView txtCantBicis;
    private Button btnCrearCoche;
    private Button btnCrearMoto;
    private Button btnCrearBici;


    //Atributos de la lógica
    private ArrayList<Coche> listaCoches;
    private ArrayList<Moto> listaMotos;
    private ArrayList<Bici> listaBicis;


    //Atributos para los launcher
    private ActivityResultLauncher<Intent> launcherCoches;
    private ActivityResultLauncher<Intent> launcherMotos;
    private ActivityResultLauncher<Intent> launcherBicis;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializarVista();

        //Inicializamos las funciones de los botones
        btnCrearCoche.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launcherCoches.launch(new Intent(MainActivity.this, CrearCocheActivity.class)); //Se usa el launcher para q cuando la actividad termine recoga la respuesta!!
            }
        });

        launcherCoches = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() { //le decimos q queremos q ocurra cuando vuelva de la actividad
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == RESULT_OK){ //Comprobamos si finalizó con exito
                            if (result.getData() != null && result.getData().getExtras() != null){ //COMPRUEBA SI HAY INTENT Y SI TIENE UN BUNDLE DENTRO!!!
                                Coche coche = (Coche) result.getData().getExtras().getSerializable("COCHE"); //Le decimos q queremos coger la info asignada a esa clave
                                listaCoches.add(coche);
                                txtCantCoches.setText("Coches: "+listaCoches.size());
                            }else {
                                Toast.makeText(MainActivity.this, "No se han pasado los datos", Toast.LENGTH_SHORT).show();
                            }
                        }else {
                            Toast.makeText(MainActivity.this, "Actividad Cancelada", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );


        btnCrearMoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }

    private void inicializarVista() {

        txtCantCoches = findViewById(R.id.txtCantidadCochesMain);
        txtCantMotos = findViewById(R.id.txtCantidadMotosMain);
        txtCantBicis = findViewById(R.id.txtCantidadBicisMain);

        btnCrearCoche = findViewById(R.id.btnCrearCocheMain);
        btnCrearMoto = findViewById(R.id.btnCrearMotoMain);
        btnCrearBici = findViewById(R.id.btnCrearBicisMain);

        listaCoches = new ArrayList<>(); //INICIALIZAR LAS LISTAS!!!!!!
        listaMotos = new ArrayList<>();
        listaBicis = new ArrayList<>();
    }
}