package mx.edu.unid.whatsappclone.adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

import mx.edu.unid.whatsappclone.R;
import mx.edu.unid.whatsappclone.models.ConversacionModelo;

public class conversacionAdapter extends FirestoreRecyclerAdapter<ConversacionModelo, conversacionAdapter.ViewHolder>
    implements View.OnClickListener{

    private View.OnClickListener listener;

    /**
     * Create a new RecyclerView adapter that listens to a Firestore Query.  See {@link
     * FirestoreRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public conversacionAdapter(@NonNull FirestoreRecyclerOptions<ConversacionModelo> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder viewHolder, int i, @NonNull ConversacionModelo conversacion) {
        String miusuario = "Alex";
        Log.i("Info",conversacion.getFrom());
        if(conversacion.getFrom().equals(miusuario)) {
            viewHolder.textViewContacto.setText(conversacion.getTo());
            if(conversacion.getTo().equals("Erick")){
                viewHolder.imageViewContacto.setImageResource(R.drawable.erick);
            }
            else if(conversacion.getTo().equals("Edgardo")){
                viewHolder.imageViewContacto.setImageResource(R.drawable.edgardo);
            }
            else if(conversacion.getTo().equals("Tomas")){
                viewHolder.imageViewContacto.setImageResource(R.drawable.tomas);
            }
            else{
                viewHolder.imageViewContacto.setImageResource(R.drawable.usuario);
            }
        }
        else {
            viewHolder.textViewContacto.setText(conversacion.getFrom());
            if(conversacion.getFrom().equals("Erick")){
                viewHolder.imageViewContacto.setImageResource(R.drawable.erick);
            }
            else if(conversacion.getFrom().equals("Edgardo")){
                viewHolder.imageViewContacto.setImageResource(R.drawable.edgardo);
            }
            else if(conversacion.getFrom().equals("Tomas")){
                viewHolder.imageViewContacto.setImageResource(R.drawable.tomas);
            }
            else{
                viewHolder.imageViewContacto.setImageResource(R.drawable.usuario);
            }
        }
        viewHolder.textViewFecha.setText("02:04 p.m.");
        viewHolder.textViewMensaje.setText(conversacion.getMessage());
        int numnotificaciones = (int) (Math.random()*10)+1;
        viewHolder.textViewNotificacion.setText(String.valueOf(numnotificaciones));
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_conversacion, parent, false);

        view.setOnClickListener(this);

        return new ViewHolder(view);
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;
    }

    @Override
    public void onClick(View v) {
        if(listener != null){
            listener.onClick(v);
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView textViewContacto;
        TextView textViewFecha;
        TextView textViewMensaje;
        TextView textViewNotificacion;
        ImageView imageViewContacto;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewContacto = itemView.findViewById(R.id.nombreConversacion);
            textViewFecha = itemView.findViewById(R.id.horaConversacion);
            textViewMensaje = itemView.findViewById(R.id.mensajeConversacion);
            textViewNotificacion = itemView.findViewById(R.id.notificacionConversacion);
            imageViewContacto = itemView.findViewById(R.id.imageConversacion);
        }
    }
}
