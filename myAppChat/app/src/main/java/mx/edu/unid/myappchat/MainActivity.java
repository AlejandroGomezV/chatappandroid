package mx.edu.unid.myappchat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerViewConversacion;
    private RecyclerViewAdaptador adaptadorConversacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewConversacion = (RecyclerView)findViewById(R.id.recyclerConversacion);
        recyclerViewConversacion.setLayoutManager(new LinearLayoutManager(this));

        adaptadorConversacion = new RecyclerViewAdaptador(obtenerConversaciones());
        recyclerViewConversacion.setAdapter(adaptadorConversacion);
    }

    public List<ConversacionModelo> obtenerConversaciones(){
        List<ConversacionModelo> conversacion = new ArrayList<>();
        //items de la lista
        conversacion.add(new ConversacionModelo("Erick","Mensaje de prueba 1",R.drawable.ic_launcher_background));
        conversacion.add(new ConversacionModelo("Tomas","Mensaje de prueba 2",R.drawable.ic_launcher_background));
        conversacion.add(new ConversacionModelo("Hugo","Mensaje de prueba 3",R.drawable.ic_launcher_background));

        return conversacion;
    }
}