package com.example.noticiaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class IniciarSesion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciar_sesion);
        if(DataHolder.getInstance().logeado != null){
            Toast.makeText(this,"Sesión iniciada.", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this,MenuPrincipal.class);
            startActivity(intent);
        }
    }
    public void IniciarSesion(View view){
        int id = view.getId();
        if(id == R.id.loginbutton){
            TextView username = findViewById(R.id.username);
            TextView password = findViewById(R.id.password);
            String usuario = username.getText().toString();
            String contra = password.getText().toString();
            if(usuario.equals("") || contra.equals("")){
                Toast.makeText(this,"Rellenar campos vacios", Toast.LENGTH_SHORT).show();
            }else{
                if(DataHolder.UsuarioExiste(usuario)){
                    if(DataHolder.UsuarioYClaveIguales(usuario,contra) != null){
                        Toast.makeText(this,"Sesión iniciada.", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(this,MenuPrincipal.class);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(this,"Clave incorrecta.", Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(this,"Usuario no existe.", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}