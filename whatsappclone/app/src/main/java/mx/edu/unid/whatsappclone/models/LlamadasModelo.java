package mx.edu.unid.whatsappclone.models;

public class LlamadasModelo {
    private String nombre, fecha;
    private int imgAlumno, imgESLlam, imgLlamada;

    public LlamadasModelo() {
    }

    public LlamadasModelo(String nombre, String fecha, int imgAlumno, int imgESLlam, int imgLlamada) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.imgAlumno = imgAlumno;
        this.imgESLlam = imgESLlam;
        this.imgLlamada = imgLlamada;
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

    public int getImgAlumno() {
        return imgAlumno;
    }

    public void setImgAlumno(int imgAlumno) {
        this.imgAlumno = imgAlumno;
    }

    public int getImgESLlam() {
        return imgESLlam;
    }

    public void setImgESLlam(int imgESLlam) {
        this.imgESLlam = imgESLlam;
    }

    public int getImgLlamada() {
        return imgLlamada;
    }

    public void setImgLlamada(int imgLlamada) {
        this.imgLlamada = imgLlamada;
    }
}
