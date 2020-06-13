package mx.edu.unid.whatsappclone.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import mx.edu.unid.whatsappclone.R;
import mx.edu.unid.whatsappclone.models.EstadosModelo;

public class EstadosRecylerViewAdapter extends RecyclerView.Adapter<EstadosRecylerViewAdapter.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView nombre, fecha;
        ImageView imgEstado;

        public ViewHolder (View itemView){
            super(itemView);
            nombre=(TextView)itemView.findViewById(R.id.nombreContacto);
            fecha=(TextView)itemView.findViewById(R.id.horaEstado);
            imgEstado=(ImageView)itemView.findViewById(R.id.imgEstado);
        }
    }

    public List<EstadosModelo> estadosLista;

    public EstadosRecylerViewAdapter(List<EstadosModelo> estadosModelos) {
        this.estadosLista = estadosModelos;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_estados,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.nombre.setText(estadosLista.get(position).getNombre());
        holder.fecha.setText(estadosLista.get(position).getNombre());
        holder.imgEstado.setImageResource(estadosLista.get(position).getImgEstado());
    }

    @Override
    public int getItemCount() {
        return estadosLista.size();
    }
}
