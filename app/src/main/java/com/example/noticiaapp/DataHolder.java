package com.example.noticiaapp;

import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class DataHolder {
    final ArrayList<Usuario> usuarios = new ArrayList<>();
    ArrayList<noticias> noticias = new ArrayList<>();
    Usuario logeado = null;

    private DataHolder() {}

    static DataHolder getInstance() {
        if( instance == null ) {
            instance = new DataHolder();
            instance.usuarios.add(new Usuario("test","test"));
        }
        return instance;
    }

    private static DataHolder instance;
    public static boolean UsuarioExiste(String correo){
        for (Usuario u : getInstance().usuarios){
            if(correo.equals(u.getCorreo())) {
                return true;
            }
        }
        return false;
    }
    public static Usuario UsuarioYClaveIguales(String correo, String contra){
        for (Usuario u : getInstance().usuarios){
            if(correo.equals(u.getCorreo())) {
                if (u.getContraseña().equals(contra)){
                    getInstance().logeado = u;
                    return u;
                }
            }
        }
        return null;
    }
    public static void AgregarUsuario(Usuario u){
        getInstance().usuarios.add(u);
    }
}