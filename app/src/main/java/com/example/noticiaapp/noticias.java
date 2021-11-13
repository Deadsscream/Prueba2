package com.example.noticiaapp;

public class noticias {
    private int id;
    private int foto;
    private String titulo;
    private String descripcion;
    private String fecha;
    private String usuario;

    public noticias(){
        id = 0;
        foto = 0;
        titulo = "";
        descripcion = "";
        fecha = "";
        usuario = "";
    }

    public noticias(int id, int foto, String titulo, String descripcion, String fecha, String usuario) {
        this.id = id;
        this.foto = foto;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.usuario = usuario;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "noticias{" +
                "id=" + id +
                ", foto=" + foto +
                ", titulo='" + titulo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", fecha='" + fecha + '\'' +
                ", usuario='" + usuario + '\'' +
                '}';
    }
}
