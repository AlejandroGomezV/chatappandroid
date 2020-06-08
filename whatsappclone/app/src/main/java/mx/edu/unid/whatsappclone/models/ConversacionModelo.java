package mx.edu.unid.whatsappclone.models;

import com.google.firebase.Timestamp;

public class ConversacionModelo {
    private  String from, to, message;
    private Timestamp timestamp;

    public ConversacionModelo() {
    }

    public ConversacionModelo(String from, String to, String message, Timestamp timestamp) {
        this.from = from;
        this.to = to;
        this.message = message;
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

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
