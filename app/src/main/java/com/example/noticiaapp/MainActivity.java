package com.example.noticiaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button boton , crearcuenta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        crearcuenta = (Button) findViewById(R.id.Crearcuenta);
        crearcuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity3();
            }
        });
        //
        boton = (Button) findViewById(R.id.btn_ini);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });

    }
    public void openActivity2() {
        Intent intent = new Intent(this, IniciarSesion.class);
        startActivity(intent);
    }
    public void openActivity3() {
        Intent intent = new Intent(this, nuevousuarios.class);
        startActivity(intent);
    }
}