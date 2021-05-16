package com.example.evaluacion2luismarileo;

import androidx.appcompat.app.AppCompatActivity;

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

    private boolean validarCorreo(TextInputEditText user){
        if(!user.getText().toString().isEmpty()){
            Pattern pat = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
            Matcher match = pat.matcher(user.getText().toString());
            if(!match.find()){
                user.setError("No es un email");
            }
            return match.find();
        } else {
            user.setError("Correo vacío");
            return false;
        }
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

    private void buttonPrincipal(View view){
        if(view.getId() == R.id.btnIniciar){
            validarCorreo(user);
            aceptarContraseña(password);
            
        }
        if(view.getId() == R.id.btnCancelar){
            finish();
        }
    }
}