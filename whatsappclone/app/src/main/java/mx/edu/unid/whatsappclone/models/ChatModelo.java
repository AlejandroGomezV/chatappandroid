package mx.edu.unid.whatsappclone.models;

public class ChatModelo {
    String mensajeR, horaR, mensajeE, horaE;

    public ChatModelo() {
    }

    public ChatModelo(String mensajeR, String horaR, String mensajeE, String horaE) {
        this.mensajeR = mensajeR;
        this.horaR = horaR;
        this.mensajeE = mensajeE;
        this.horaE = horaE;
    }

    public String getMensajeR() {
        return mensajeR;
    }

    public void setMensajeR(String mensajeR) {
        this.mensajeR = mensajeR;
    }

    public String getHoraR() {
        return horaR;
    }

    public void setHoraR(String horaR) {
        this.horaR = horaR;
    }

    public String getMensajeE() {
        return mensajeE;
    }

    public void setMensajeE(String mensajeE) {
        this.mensajeE = mensajeE;
    }

    public String getHoraE() {
        return horaE;
    }

    public void setHoraE(String horaE) {
        this.horaE = horaE;
    }
}
