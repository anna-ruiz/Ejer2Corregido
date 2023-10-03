package com.example.ejer2corregido.Actividades;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ejer2corregido.Modelos.Moto;
import com.example.ejer2corregido.R;

public class CrearMotoActivity extends AppCompatActivity {

    //Atributos de la Vista
    private EditText txtMarca;
    private EditText txtModelo;
    private EditText txtCilindrada;

    private Button btnCancelar;
    private Button btnCrear;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_moto);

        inicializarVista();

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });

        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Recogemos info
                String marca = txtMarca.getText().toString();
                String modelo= txtModelo.getText().toString();
                String cilindrada = txtCilindrada.getText().toString();

                //Comprobar si esta toda la info
                if (marca.isEmpty() || modelo.isEmpty() || cilindrada.isEmpty()){
                    Toast.makeText(CrearMotoActivity.this, "Debes rellenar toda la información", Toast.LENGTH_SHORT).show();
                }else {
                    Moto moto = new Moto(marca,modelo,cilindrada);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("MOTO",moto);
                    Intent intent = new Intent();
                    intent.putExtras(bundle);
                    setResult(RESULT_OK,intent); //MANDAR LA INFO CON EL RESULTADO
                    finish();
                }
            }
        });
    }

    private void inicializarVista() {
        txtMarca = findViewById(R.id.txtMarcaCrearMoto);
        txtModelo = findViewById(R.id.txtModeloCrearMoto);
        txtCilindrada = findViewById(R.id.txtCilindradaCrearMoto);

        btnCancelar = findViewById(R.id.btnCancelarCrearMoto);
        btnCrear = findViewById(R.id.btnCrearCrearMoto);
    }
}