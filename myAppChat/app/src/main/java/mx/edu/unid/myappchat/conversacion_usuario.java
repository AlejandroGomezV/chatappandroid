package mx.edu.unid.myappchat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.view.Menu;
import android.widget.Toast;

public class conversacion_usuario extends AppCompatActivity {

    private EditText txtMensaje;
    private RecyclerView rvMensajes;
    private Button btnEnviar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversacion_usuario);

        this.setTitle("Hugo");

        /*txtMensaje = (EditText) findViewById(R.id.txtMensaje);
        rvMensajes = (RecyclerView) findViewById(R.id.rvMensajes);
        btnEnviar = (Button) findViewById(R.id.btnEnviar);*/
    }

    //Metodo para mostrar y ocultar Menú
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.overflow_conv, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if(id == R.id.item1){
            Toast.makeText( this, "Ver Contacto", Toast.LENGTH_SHORT).show();
        }else if(id == R.id.itemConv2){
            Toast.makeText( this, "Archivos, enlaces y docs", Toast.LENGTH_SHORT).show();
        }else if(id == R.id.itemConv3){
            Toast.makeText( this,  "Buscar", Toast.LENGTH_SHORT).show();
        }else if(id == R.id.itemConv4){
            Toast.makeText( this,  "Silenciar notificaciones", Toast.LENGTH_SHORT).show();
        }else if(id == R.id.itemConv5){
            Toast.makeText( this, "Ver Contacto", Toast.LENGTH_SHORT).show();
        }

        if(id == R.id.back) {
            abrirPantallaPrincipal();
        }
        return super.onOptionsItemSelected(item);
    }

    public void abrirPantallaPrincipal(){
        Intent nextActivity = new Intent(this, MainActivity.class);
        startActivity(nextActivity);
    }


}