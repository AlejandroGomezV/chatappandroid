package mx.edu.unid.myappchat;

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

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ConversacionAdapter
        extends FirestoreRecyclerAdapter<ConversacionModelo, ConversacionAdapter.ViewHolder>
        implements View.OnClickListener {

    private View.OnClickListener listener;
    /**
     * Create a new RecyclerView adapter that listens to a Firestore Query.  See {@link
     * FirestoreRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public ConversacionAdapter( FirestoreRecyclerOptions<ConversacionModelo> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder( ViewHolder viewHolder, int i, ConversacionModelo conversacionModelo) {
        viewHolder.textViewContacto.setText("From: "+conversacionModelo.getFrom());
        viewHolder.textViewMensaje.setText("Message: "+conversacionModelo.getMessage());
        viewHolder.textViewTo.setText("To: "+conversacionModelo.getTo());
        viewHolder.textViewFecha.setText("TimeStamp: "+ conversacionModelo.getTimestamp());
        viewHolder.imageViewConversacion.setImageResource(R.drawable.ic_launcher_background);
    }

    @Override
    public ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_conversacion, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        view.setOnClickListener(this);
        return viewHolder;
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;
    }

    @Override
    public void onClick(View v) {
        if(listener!=null){
            listener.onClick(v);
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewContacto;
        TextView textViewMensaje;
        TextView textViewTo;
        TextView textViewFecha;
        ImageView imageViewConversacion;

        public ViewHolder( View itemView) {
            super(itemView);

            textViewContacto = itemView.findViewById(R.id.nombreContacto);
            textViewMensaje = itemView.findViewById(R.id.mensaje);
            textViewTo = itemView.findViewById(R.id.toContacto);
            textViewFecha = itemView.findViewById(R.id.fecha);
            imageViewConversacion = itemView.findViewById(R.id.imgConversacion);
        }
    }
}
