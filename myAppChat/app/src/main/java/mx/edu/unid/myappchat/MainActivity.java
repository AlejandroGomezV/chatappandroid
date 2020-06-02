package mx.edu.unid.myappchat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import android.widget.Toolbar;

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

    //metodo para mostrar y ocultar el menu
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.overflow, menu);
        return true;
    }

    //metodo para asignar las funciones correspondientes a las opciones
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if(id == R.id.item1){
            Toast.makeText(this,"Opcion 1", Toast.LENGTH_SHORT).show();
            return  true;
        } else if (id == R.id.item2) {
            Toast.makeText(this,"Opcion 2", Toast.LENGTH_SHORT).show();
            return  true;
        } else if (id == R.id.item3){
            Toast.makeText(this,"Opcion 3", Toast.LENGTH_SHORT).show();
            return  true;
        } else if (id == R.id.item4){
            Toast.makeText(this,"Opcion 4", Toast.LENGTH_SHORT).show();
            return  true;
        } else if (id == R.id.item5){
            Toast.makeText(this,"Opcion 5", Toast.LENGTH_SHORT).show();
            return  true;
        }

        return super.onOptionsItemSelected(item);
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