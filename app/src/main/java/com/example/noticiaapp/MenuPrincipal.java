package com.example.noticiaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MenuPrincipal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);
        TextView usuario = (TextView) findViewById(R.id.main_usuario);
        Usuario u = DataHolder.getInstance().logeado;
        usuario.setText("Bienvenido. "+u.getCorreo());
    }
    public void Click(View v) {
        int id = v.getId();
        if (id == R.id.main_crearnoticia){
            Intent intent = new Intent(this,crearnoticia.class);
            startActivity(intent);
        }
        else if (id == R.id.main_bitacora){
            Intent intent = new Intent(this, ListaNoticiaas.class);
            startActivity(intent);
        }
        else if (id == R.id.main_cerrarsesion){
            DataHolder.getInstance().logeado = null;
            Toast.makeText(this,"Sesión cerrada.", Toast.LENGTH_SHORT).show();
            finish();

        }
    }
}