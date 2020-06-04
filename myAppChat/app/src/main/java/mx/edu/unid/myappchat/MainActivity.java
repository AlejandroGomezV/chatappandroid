package mx.edu.unid.myappchat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import android.widget.Toolbar;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerViewConversacion;
    private RecyclerViewAdaptador adaptadorConversacion;

    FirebaseFirestore mFirestore;
    ConversacionAdapter mAdapter;

    String to = "";
    String from = "";
    String message = "";
    long timestamp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFirestore = FirebaseFirestore.getInstance();

        recyclerViewConversacion = (RecyclerView)findViewById(R.id.recyclerConversacion);
        recyclerViewConversacion.setLayoutManager(new LinearLayoutManager(this));

        Query query = mFirestore.collection("chat");

        final FirestoreRecyclerOptions<ConversacionModelo> firestoreRecyclerOptions = new FirestoreRecyclerOptions.Builder<ConversacionModelo>()
                .setQuery(query,ConversacionModelo.class).build();

        mAdapter = new ConversacionAdapter(firestoreRecyclerOptions);
        mAdapter.notifyDataSetChanged();
        mAdapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getApplicationContext(),"Seleccion de un elemento",Toast.LENGTH_SHORT).show();
                abrirPantallaConversacion(v);
            }
        });
        recyclerViewConversacion.setAdapter(mAdapter);
        //adaptadorConversacion = new RecyclerViewAdaptador(obtenerConversaciones());
        //recyclerViewConversacion.setAdapter(adaptadorConversacion);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.floatingActionButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "Insertar aqui codigo para boton flotante", Snackbar.LENGTH_LONG).setAction("Action",null).show();
            }
        });

        //obtenerConversacionesFromFirebase();
    }

    public void abrirPantallaConversacion(View view){
        Intent nextActivity = new Intent(this, conversacion_usuario.class);
        startActivity(nextActivity);
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
        //conversacion.add(new ConversacionModelo("Erick","Mensaje de prueba 1",R.drawable.ic_launcher_background));
        //conversacion.add(new ConversacionModelo("Tomas","Mensaje de prueba 2",R.drawable.ic_launcher_background));
        //conversacion.add(new ConversacionModelo("Hugo","Mensaje de prueba 3",R.drawable.ic_launcher_background));

        return conversacion;
    }

    private void obtenerConversacionesFromFirebase(){
        mFirestore.collection("chat").document("SlMhepfrhpilahMh70V4").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if(documentSnapshot.exists()){
                    to = documentSnapshot.getString("to");
                    from = documentSnapshot.getString("from");
                    message = documentSnapshot.getString("message");
                    //long timestamp = documentSnapshot.getLong("timestamp");
                }
            }
        });

        //Snackbar.make(MainActivity.this, from, Snackbar.LENGTH_LONG).setAction("Action",null).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        mAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mAdapter.stopListening();
    }
}