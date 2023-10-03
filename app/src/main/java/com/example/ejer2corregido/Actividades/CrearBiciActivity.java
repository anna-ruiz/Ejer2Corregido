
package com.example.ejer2corregido.Actividades;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ejer2corregido.Modelos.Bici;
import com.example.ejer2corregido.Modelos.Moto;
import com.example.ejer2corregido.R;

public class CrearBiciActivity extends AppCompatActivity {
        //Atributos de la vista
    private EditText txtMarca;
    private EditText txtPulgadas;

    private Button btnCancelar;
    private Button btnCrear;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_bici);

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
                String pulgadas = txtPulgadas.getText().toString();

                //Comprobar si esta toda la info
                if (marca.isEmpty() || pulgadas.isEmpty()){
                    Toast.makeText(CrearBiciActivity.this, "Debes rellenar toda la información", Toast.LENGTH_SHORT).show();
                }else {
                    Bici bici = new Bici(marca,pulgadas);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("BICI", bici);
                    Intent intent = new Intent();
                    intent.putExtras(bundle);
                    setResult(RESULT_OK,intent); //MANDAR LA INFO CON EL RESULTADO
                    finish();
                }
            }
        });

    }

    private void inicializarVista() {
        txtMarca = findViewById(R.id.txtMarcaCrearBici);
        txtPulgadas = findViewById(R.id.txtPulgadasCrearBici);

        btnCancelar = findViewById(R.id.btnCancelarCrearBici);
        btnCrear = findViewById(R.id.btnCrearCrearBici);

    }
}