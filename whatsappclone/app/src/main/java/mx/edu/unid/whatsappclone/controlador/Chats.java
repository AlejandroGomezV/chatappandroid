package mx.edu.unid.whatsappclone.controlador;

import android.app.DownloadManager;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

import mx.edu.unid.whatsappclone.R;
import mx.edu.unid.whatsappclone.adapters.conversacionAdapter;
import mx.edu.unid.whatsappclone.detalle_conversacion;
import mx.edu.unid.whatsappclone.models.ConversacionModelo;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Chats#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Chats extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    RecyclerView recyclerViewConversaciones;
    conversacionAdapter mAdapter;
    FirebaseFirestore mFirestore;

    public Chats() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Chats.
     */
    // TODO: Rename and change types and number of parameters
    public static Chats newInstance(String param1, String param2) {
        Chats fragment = new Chats();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View vista = inflater.inflate(R.layout.fragment_chats, container, false);

        recyclerViewConversaciones = vista.findViewById(R.id.recyclerConversacion);
        recyclerViewConversaciones.setLayoutManager(new LinearLayoutManager(getContext()));

        mFirestore = FirebaseFirestore.getInstance();
        Query query = mFirestore.collection("chat");

        final FirestoreRecyclerOptions<ConversacionModelo> firestoreRecyclerOptions = new FirestoreRecyclerOptions.Builder<ConversacionModelo>()
                .setQuery(query, ConversacionModelo.class).build();

        mAdapter = new conversacionAdapter(firestoreRecyclerOptions);
        mAdapter.notifyDataSetChanged();

        mAdapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getContext(), "Clic "+ mAdapter.getItem(0).getMessage(),Toast.LENGTH_SHORT).show();
                /*Codigo evento clic*/
                abrirPantallaConversacion(v);
            }
        });

        recyclerViewConversaciones.setAdapter(mAdapter);

        return vista;
    }

    public void abrirPantallaConversacion(View view){
        Intent pantalladetalle = new Intent(getActivity(), detalle_conversacion.class);
        startActivity(pantalladetalle);
    }

    @Override
    public void onStart() {
        super.onStart();
        mAdapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        mAdapter.stopListening();
    }
}