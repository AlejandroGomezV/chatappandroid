package mx.edu.unid.myappchat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class conversacion_usuario extends AppCompatActivity {

    private EditText txtMensaje;
    private RecyclerView rvMensajes;
    private Button btnEnviar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversacion_usuario);

        txtMensaje = (EditText) findViewById(R.id.txtMensaje);
        rvMensajes = (RecyclerView) findViewById(R.id.rvMensajes);
        btnEnviar = (Button) findViewById(R.id.btnEnviar);
    }


}