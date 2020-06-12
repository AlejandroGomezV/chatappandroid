package mx.edu.unid.whatsappclone.adapters;

import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import mx.edu.unid.whatsappclone.R; //Duda
import mx.edu.unid.whatsappclone.models.LlamadasModelo;

public class LlamadasRecyclerViewAdaptadpr extends RecyclerView.Adapter<LlamadasRecyclerViewAdaptadpr.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView nombre, fecha;
        ImageView fotoAlumno, esLlamada, tipoLlamada;

        public ViewHolder(View itemView){
            super(itemView);
            nombre=(TextView)itemView.findViewById(R.id.tvAlumno);
            fecha=(TextView)itemView.findViewById(R.id.tvFecha);
            fotoAlumno=(ImageView)itemView.findViewById(R.id.imgAlumno);
            esLlamada=(ImageView)itemView.findViewById(R.id.imgESLlamadas);
            tipoLlamada=(ImageView)itemView.findViewById(R.id.imgLlamada);

        }
    }

    public List<LlamadasModelo> llamadasLista;

    public LlamadasRecyclerViewAdaptadpr(List<LlamadasModelo> llamadasLista) {
        this.llamadasLista = llamadasLista;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_llamadas,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.nombre.setText(llamadasLista.get(position).getNombre());
        holder.fecha.setText(llamadasLista.get(position).getFecha());
        holder.fotoAlumno.setImageResource(llamadasLista.get(position).getImgAlumno());
        holder.esLlamada.setImageResource(llamadasLista.get(position).getImgESLlam());
        holder.tipoLlamada.setImageResource(llamadasLista.get(position).getImgLlamada());
    }

    @Override
    public int getItemCount() {
        return llamadasLista.size();
    }
}
