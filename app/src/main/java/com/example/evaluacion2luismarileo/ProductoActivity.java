package com.example.evaluacion2luismarileo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Spinner;

import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

public class ProductoActivity extends AppCompatActivity {
    private TextInputEditText codigo, nombre;
    private AutoCompleteTextView tipo;
    private Spinner spEstado;
    private Button btn1, btn2;
    private ArrayList<Producto> productos= new ArrayList<>();
    private String[] prodEstado = new String[4];
    private ArrayAdapter adaptadorSpin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_producto);

        inits();
        spinArreglo();
    }

    private void inits(){
        codigo = (TextInputEditText) findViewById(R.id.etiId);
        nombre = (TextInputEditText) findViewById(R.id.etiNombre);
        tipo = (AutoCompleteTextView) findViewById(R.id.atvTipo);
        spEstado = (Spinner) findViewById(R.id.spnEstado);
        btn1 = (Button) findViewById(R.id.btnOk);
        btn2 = (Button) findViewById(R.id.btnVolver);
    }
    //Método del Spinner.
    private void spinArreglo(){
        prodEstado[0] = "Disponible";
        prodEstado[1] = "Control de calidad";
        prodEstado[2] = "No vigente";
        prodEstado[3] = "En tránsito";

        adaptadorSpin = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, prodEstado);
        spEstado.setAdapter(adaptadorSpin);
    }
}