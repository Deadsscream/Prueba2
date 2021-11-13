package com.example.noticiaapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Calendar;
import java.util.Date;

public class crearnoticia extends AppCompatActivity {

    private final String[] permisos = {Manifest.permission.CAMERA};
    private ImageView foto;
    private boolean tienePermiso;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crearnoticia);
        Date currentTime = Calendar.getInstance().getTime();
        tienePermiso = false;
        TextView fecha = (TextView) findViewById(R.id.noticia_fecha);
        fecha.setText("Fecha: "+currentTime);

        foto = findViewById(R.id.noticia_foto);

        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.M){
            requestPermissions(permisos, 100);
        }




    }

    private void comprobarPermisos(){
        if(Build.VERSION.SDK_INT > Build.VERSION_CODES.M){
            if(checkSelfPermission(Manifest.permission.CAMERA)== PackageManager.PERMISSION_GRANTED){
                Toast.makeText(this,"permisos ok", Toast.LENGTH_SHORT).show();
                tienePermiso = true;
            }else{
                solicitarPermisos();
            }
        }
    }

    private void solicitarPermisos(){
        new AlertDialog.Builder(this)
                .setTitle("se requiere permisos de camara")
                .setMessage("esta aplicacion hace uso de la camara, por favor otorge pemisos")
                .setPositiveButton("Ver permiso", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        requestPermissions(permisos, 100);
                    }
                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                })
                .create().show();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(requestCode == 100){
            if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
                Toast.makeText(this, "Se otorgaron permisos de camara", Toast.LENGTH_SHORT).show();
                tienePermiso = true;
            }else{
                Toast.makeText(this, "se requiere permisos de camara", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void tomarFoto(View view){
        comprobarPermisos();

        if(tienePermiso){
            Intent intento = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intento, 0);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK){
            Bitmap b = (Bitmap) data.getExtras().get("data");
            foto.setImageBitmap(b);
        }
    }

    public void Guardar(View view){
        TextInputEditText tit = findViewById(R.id.noticia_titulo2);
        TextInputEditText des = findViewById(R.id.noticia_descripcion2);
        TextView fec = findViewById(R.id.noticia_fecha);
        //TextView ubi = findViewById(R.id.noticia_ubicacion);
        ImageView fot = findViewById(R.id.noticia_foto);
        String titulo = tit.getText().toString();
        String descripcion = des.getText().toString();
        String fecha = fec.getText().toString();
        //String foto = fot.get
        if(titulo.equals("")||descripcion.equals("")){
            Toast.makeText(this, "Completar campos vacíos", Toast.LENGTH_SHORT).show();
            return;
        }
        int id = DataHolder.getInstance().noticias.size();
        String usuario = DataHolder.getInstance().logeado.getCorreo();
        noticias n = new noticias(id+1, 0, titulo, descripcion, fecha, usuario);
        DataHolder.getInstance().noticias.add(n);
        Toast.makeText(this, "Noticia registrada.", Toast.LENGTH_SHORT).show();
        finish();
    }




}