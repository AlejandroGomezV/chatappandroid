package mx.edu.unid.whatsappclone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import mx.edu.unid.whatsappclone.controlador.PagerController;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    TabItem tab1, tab2, tab3, tab4;
    PagerController pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tablayout);
        viewPager = findViewById(R.id.viewpager);

        tab1 = findViewById(R.id.tabcamara);
        tab2 = findViewById(R.id.tabchats);
        tab3 = findViewById(R.id.tabestados);
        tab4 = findViewById(R.id.tabllamadas);

        pagerAdapter = new PagerController(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(pagerAdapter);
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                Log.w("Error de prueba","***************TAB numero: "+tab.getPosition());
                if(tab.getPosition()==0){
                    pagerAdapter.notifyDataSetChanged();
                }
                if(tab.getPosition()==1){
                    pagerAdapter.notifyDataSetChanged();
                }
                if(tab.getPosition()==2){
                    pagerAdapter.notifyDataSetChanged();
                }
                if(tab.getPosition()==3){
                    pagerAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        viewPager.setCurrentItem(1);
    }

    //Metodo para mostrar el menu
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menuapp, menu);
        return true;
    }

    //metodo para agregar acciones de botones
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if(id == R.id.buscar){
            Toast.makeText(this,"Buscar", Toast.LENGTH_SHORT).show();
            return true;
        }
        if(id == R.id.itemnuevogrupo){
            Toast.makeText(this,"Nuevo grupo", Toast.LENGTH_SHORT).show();
            return true;
        }
        if(id == R.id.itemnuevadifusion){
            Toast.makeText(this,"Nueva difusión", Toast.LENGTH_SHORT).show();
            return true;
        }
        if(id == R.id.itemweb){
            Toast.makeText(this,"WhatsApp Web", Toast.LENGTH_SHORT).show();
            return true;
        }
        if(id == R.id.itemmensajesdestacados){
            Toast.makeText(this,"Mensajes destacados", Toast.LENGTH_SHORT).show();
            return true;
        }
        if(id == R.id.itemajustes){
            Toast.makeText(this,"Ajustes", Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}