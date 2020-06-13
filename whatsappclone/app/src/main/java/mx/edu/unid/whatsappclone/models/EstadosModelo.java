package mx.edu.unid.whatsappclone.models;

import mx.edu.unid.whatsappclone.controlador.Estados;

public class EstadosModelo {
    private String nombre, fecha;
    private int imgEstado;

    public  EstadosModelo() {
    }

    public EstadosModelo (String nombre, String fecha, int imgEstado){
        this.nombre = nombre;
        this.fecha = fecha;
        this.imgEstado = imgEstado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getImgEstado() {
        return imgEstado;
    }

    public void setImgEstado(int imgEstado) {
        this.imgEstado = imgEstado;
    }
}
