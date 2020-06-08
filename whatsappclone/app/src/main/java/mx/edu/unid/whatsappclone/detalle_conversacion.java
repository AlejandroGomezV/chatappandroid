package mx.edu.unid.whatsappclone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;

import java.util.ArrayList;
import java.util.List;

import mx.edu.unid.whatsappclone.adapters.ChatRecyclerViewAdaptador;
import mx.edu.unid.whatsappclone.models.ChatModelo;

public class detalle_conversacion extends AppCompatActivity {

    private RecyclerView recyclerViewChat;
    private ChatRecyclerViewAdaptador adaptadorChat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_conversacion);

        recyclerViewChat=findViewById(R.id.recyclerChat);
        recyclerViewChat.setLayoutManager(new LinearLayoutManager(this));

        adaptadorChat= new ChatRecyclerViewAdaptador(obtenerChats());
        recyclerViewChat.setAdapter(adaptadorChat);

        this.setTitle("Hugo");
    }

    public List<ChatModelo> obtenerChats(){
        List<ChatModelo> chat =new ArrayList<>();
        chat.add(new ChatModelo("Hola","12:04 p.m.","",""));
        chat.add(new ChatModelo("","","Hola que tal?","12:10 p.m."));
        chat.add(new ChatModelo("Bien, aquí con la tarea","12:34 p.m.","",""));
        chat.add(new ChatModelo("","","Muy bien","13:10 p.m."));
        chat.add(new ChatModelo("Ya te salio?","14:04 p.m.","",""));
        chat.add(new ChatModelo("","","Aun me faltan detalle","15:10 p.m."));
        chat.add(new ChatModelo("Muy bien","16:04 p.m.","",""));
        chat.add(new ChatModelo("","","y a ti?","17:10 p.m."));

        return chat;
    }

    //Metodo para mostrar el menu
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menuchat, menu);
        return true;
    }
}