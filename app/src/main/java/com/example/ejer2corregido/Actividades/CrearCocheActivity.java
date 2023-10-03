package com.example.ejer2corregido.Actividades;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ejer2corregido.Modelos.Coche;
import com.example.ejer2corregido.R;

public class CrearCocheActivity extends AppCompatActivity {

    //Atributos de la vista
    private EditText txtMarca;
    private EditText txtModelo;
    private EditText txtColor;

    private Button btnCancelar;
    private Button btnCrear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_coche);


        inicializarVariables();

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(RESULT_CANCELED); //le devolvemos al launcher que se ha cancelado la accion
                finish();
            }
        });


        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Recogemos la info
                String marca = txtMarca.getText().toString();
                String modelo = txtModelo.getText().toString();
                String color = txtColor.getText().toString();

                //Comprobar si esta toda la info
                if (marca.isEmpty() || modelo.isEmpty() || color.isEmpty()){
                    //si no esta aviso y espero a que la rellenen
                    Toast.makeText(CrearCocheActivity.this, "Debes rellenar todos los campos.", Toast.LENGTH_SHORT).show();

                }else {
                    //Crear un objeto coche con esa info
                    Coche coche = new Coche(marca,modelo,color);

                    //Lo meto en la maleta(bundle) y en el taxi(intent)
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("COCHE",coche);
                    Intent intent = new Intent(); //DEBEMOS DEJAR EL NEW INTENT() VACIO!!!!!
                    intent.putExtras(bundle);

                    //Informar del resultado exitoso y la info!!!!!
                    setResult(RESULT_OK, intent);

                    //Fin
                    finish();

                }

            }
        });
    }

    private void inicializarVariables() {
        txtMarca = findViewById(R.id.txtMarcaCrearCoche);
        txtModelo = findViewById(R.id.txtModeloCrearCoche);
        txtColor = findViewById(R.id.txtColorCrearCoche);

        btnCancelar = findViewById(R.id.btnCancelarCrearCoche);
        btnCrear = findViewById(R.id.btnCrearCrearCoche);
    }
}