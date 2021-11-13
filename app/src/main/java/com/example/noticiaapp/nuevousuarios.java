package com.example.noticiaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class nuevousuarios extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevousuarios);
    }

    public void onClick(View v){
        if (v.getId() == R.id.btn_login)
        {
            TextView us =  (TextView) findViewById(R.id.username2);
            TextView pw =  (TextView) findViewById(R.id.password2);
            String usuario = us.getText().toString();
            String contra = pw.getText().toString();
            if(usuario.equals("") || contra.equals("")) {
                Toast.makeText(this,"Rellenar campos vacios", Toast.LENGTH_SHORT).show();
                return;
            }
            Usuario nuevo = new Usuario(usuario,contra);
            if (DataHolder.UsuarioExiste(usuario)){
                Toast.makeText(this,"Usuario ya registrado.", Toast.LENGTH_SHORT).show();
                return;
            }
            DataHolder.AgregarUsuario(nuevo);
            us.setText("");
            pw.setText("");
            Toast.makeText(this,"Usuario registrado correctamente.", Toast.LENGTH_SHORT).show();
            return;
        }


    }
}