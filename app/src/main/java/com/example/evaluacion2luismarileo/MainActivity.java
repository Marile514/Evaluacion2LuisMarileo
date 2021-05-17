package com.example.evaluacion2luismarileo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity{
    private TextInputEditText user, password;
    private Button btnIniciar, btnCancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inits();
        btnActions();
    }

    private void inits(){
        user = findViewById(R.id.edUsuario);
        password = findViewById(R.id.edPassword);
        btnIniciar = findViewById(R.id.btnIniciar);
        btnCancelar = findViewById(R.id.btnCancelar);
    }

    /**
     * Nuevo Método para manejar la respuesta.
     */
    private boolean validarCorreo(TextInputEditText user){
        if(!user.getText().toString().isEmpty()){
            String strCorreo = user.getText().toString();
            //Usar el método validarCorreo2(strCorreo) para la expresión regular.
            if(validarCorreo2(strCorreo)){
                return true;
            } else {
                user.setError("No es un Correo!");
                return false;
            }
        } else {
            user.setError("Correo vacío");
            return false;
        }
    }

    public boolean validarCorreo2(String correo){
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher matcher = pattern.matcher(correo);
        return matcher.find();
    }

    private boolean aceptarContraseña(TextInputEditText password){
        if(!password.getText().toString().isEmpty()){
            return true;
        } else {
            password.setError("Contraseña no ingresada o vacía");
            return false;
        }
    }

    private void btnActions(){
        btnIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonPrincipal(v);
            }
        });
        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonPrincipal(v);
            }
        });
    }

    private void buttonPrincipal(View view) {
        if (view.getId() == R.id.btnIniciar) {
            validarCorreo(user);
            aceptarContraseña(password);
            if(validarCorreo(user) && aceptarContraseña(password)){
                Intent i = new Intent(this, ProductoActivity.class);
                startActivity(i);
            }
        }
        if (view.getId() == R.id.btnCancelar) {
            finish();
        }
    }

    //Probar cambio de github
}