package mx.edu.unid.myappchat;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class RecyclerViewAdaptador extends RecyclerView.Adapter<RecyclerViewAdaptador.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView contacto, mensaje;
        ImageView fotoContacto;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            contacto = (TextView)itemView.findViewById(R.id.nombreContacto);
            mensaje = (TextView)itemView.findViewById(R.id.mensaje);
            fotoContacto = (ImageView) itemView.findViewById(R.id.imgConversacion);
        }
    }

    public List<ConversacionModelo> conversacionLista;

    public RecyclerViewAdaptador(List<ConversacionModelo> conversacionLista) {
        this.conversacionLista = conversacionLista;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_conversacion,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.contacto.setText("From: "+conversacionLista.get(position).getFrom());
        holder.mensaje.setText("Mensaje: "+conversacionLista.get(position).getMessage());
        //holder.fotoContacto.setImageResource(conversacionLista.get(position).getImgContacto());
    }

    @Override
    public int getItemCount() {
        return conversacionLista.size();
    }
}
