package mx.edu.unid.myappchat;

import java.sql.Time;
import java.sql.Timestamp;

public class ConversacionModelo {
    private String from, to, message;
    private String imgContacto;
    private com.google.firebase.Timestamp timestamp;

    public ConversacionModelo() {
    }

    public ConversacionModelo(String from, String to, String message, String imgContacto, com.google.firebase.Timestamp timestamp) {
        this.from = from;
        this.to = to;
        this.message = message;
        this.imgContacto = imgContacto;
        this.timestamp = timestamp;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getImgContacto() {
        return imgContacto;
    }

    public void setImgContacto(String imgContacto) {
        this.imgContacto = imgContacto;
    }

    public com.google.firebase.Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(com.google.firebase.Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
