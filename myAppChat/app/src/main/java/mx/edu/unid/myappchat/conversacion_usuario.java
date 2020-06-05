package mx.edu.unid.myappchat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.view.Menu;

public class conversacion_usuario extends AppCompatActivity {

    private EditText txtMensaje;
    private RecyclerView rvMensajes;
    private Button btnEnviar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversacion_usuario);

        /*txtMensaje = (EditText) findViewById(R.id.txtMensaje);
        rvMensajes = (RecyclerView) findViewById(R.id.rvMensajes);
        btnEnviar = (Button) findViewById(R.id.btnEnviar);*/
    }

    //Metodo para mostrar y ocultar Menú
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.overflow, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemID();

        if(id == R.id.item1){
            Toast.makeText( context: this, text: "Ver Contacto", Toast.LENGTH_SHORT).show();
        }else if(id == R.id.itemConv2){
            Toast.makeText( context: this, text: "Archivos, enlaces y docs", Toast.LENGTH_SHORT).show();
        }else if(id == R.id.itemConv3){
            Toast.makeText( context: this, text: "Buscar", Toast.LENGTH_SHORT).show();
        }else if(id == R.id.itemConv4){
            Toast.makeText( context: this, text: "Silenciar notificaciones", Toast.LENGTH_SHORT).show();
        }else if(id == R.id.itemConv5){
            Toast.makeText( context: this, text: "Ver Contacto", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);


    }


}