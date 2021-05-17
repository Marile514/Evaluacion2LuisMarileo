package com.example.evaluacion2luismarileo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

public class ProductoActivity extends AppCompatActivity {
    private TextInputEditText codigo, nombre;
    private String estadoProducto, tipoProducto;
    private AutoCompleteTextView tipo;
    private Spinner spEstado;
    private Button btn1, btn2;
    private ArrayList<Producto> productos= new ArrayList<>();
    private String[] prodEstado = new String[4];
    private String[] tipoProd = new String[10];
    private ArrayAdapter adaptadorSpin, adaptadorActv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_producto);

        inits();
        btnActions2();

    }

    private void inits(){
        Arreglo();
        codigo = findViewById(R.id.etiId);
        nombre = findViewById(R.id.etiNombre);
        tipo = findViewById(R.id.atvTipo);
        spEstado = findViewById(R.id.spnEstado);
        btn1 = findViewById(R.id.btnOk);
        btn2 = findViewById(R.id.btnVolver);

        adaptadorSpin = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, prodEstado);
        spEstado.setAdapter(adaptadorSpin);

        adaptadorActv = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, tipoProd);
        tipo.setAdapter(adaptadorActv);
        tipo.setThreshold(1);

        actCompletSpin();
    }

    private void Arreglo(){
       //Métodos de spinner.
        prodEstado[0] = "Disponible";
        prodEstado[1] = "Control de calidad";
        prodEstado[2] = "No vigente";
        prodEstado[3] = "En tránsito";

        //Métodos de AutoCompleteTextView.
        tipoProd[0] = "Consumo";
        tipoProd[1] = "Uso común";
        tipoProd[2] = "Emergencia";
        tipoProd[3] = "Durables";
        tipoProd[4] = "Especialidad";
        tipoProd[5] = "Servicios";
        tipoProd[6] = "Tipo 1";
        tipoProd[7] = "Tipo 2";
        tipoProd[8] = "Tipo 3";
        tipoProd[9] = "Tipo 4";
    }

    private void buttonPrincipal2(View view){
        if(view.getId() == R.id.btnOk){
            //1.- Validar que el codigo y el nombre no estén vacíos y si lo estan poner un setError.
            //2.- Crear los métodos -> spinner.setOnItemSelected,
            //3.- Usar esos metodos para asignar los valores de los campos al objeto

            //1.- Respuesta.
            validarCodigo(codigo);
            validarNombre(nombre);
            if(validarCodigo(codigo) && validarNombre(nombre)){
                //2.- Spinner -> setOnItemSelectedListener || AutoComTextView -> setOnItemClickListener
                productos.add(new Producto(codigo.getText().toString(), nombre.getText().toString(),tipoProducto, estadoProducto));
                Log.d("TAG_", "Productos: "+ productos.toString());
                limpiarCampos();
            }
        }
        if(view.getId() == R.id.btnVolver){
            finish();
        }
    }

    private boolean validarCodigo(TextInputEditText txe){
        if(!txe.getText().toString().isEmpty()){
            return true;
        } else {
            txe.setError("Codigo (ID) vacío");
            return false;
        }
    }

    private boolean validarNombre(TextInputEditText txe){
        if(!txe.getText().toString().isEmpty()){
            return true;
        } else {
            txe.setError("Nombre vacío");
            return false;
        }
    }

    private void limpiarCampos(){
        codigo.setText("");
        nombre.setText("");
        tipo.setText("");
    }

    private void btnActions2(){
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonPrincipal2(v);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonPrincipal2(v);
            }
        });
    }

    //Metodod de los spinner y autoComplete
    private void actCompletSpin(){
        spEstado.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Object c = parent.getItemAtPosition(position);
                String Estado = c.toString();
                estadoProducto = Estado;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        tipo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Object f = parent.getItemAtPosition(position);
                String TipProduct = f.toString();
                tipoProducto = TipProduct;
            }
        });
    }
}