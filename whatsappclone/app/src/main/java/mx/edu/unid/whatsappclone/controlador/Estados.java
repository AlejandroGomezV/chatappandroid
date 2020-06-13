package mx.edu.unid.whatsappclone.controlador;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import mx.edu.unid.whatsappclone.R;
import mx.edu.unid.whatsappclone.adapters.EstadosRecylerViewAdapter;
import mx.edu.unid.whatsappclone.models.EstadosModelo;
import mx.edu.unid.whatsappclone.models.LlamadasModelo;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Estados#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Estados extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    RecyclerView recyclerViewEstados;
    EstadosRecylerViewAdapter adatadorEstados;

    public Estados() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Estados.
     */
    // TODO: Rename and change types and number of parameters
    public static Estados newInstance(String param1, String param2) {
        Estados fragment = new Estados();
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
        // Inflate the layout for this fragment
        View vista = inflater.inflate(R.layout.fragment_estados, container, false);

        recyclerViewEstados = vista.findViewById(R.id.recyclerEstados);
        recyclerViewEstados.setLayoutManager(new LinearLayoutManager(getContext()));

        adatadorEstados=new EstadosRecylerViewAdapter(obtenerEstados());
        recyclerViewEstados.setAdapter(adatadorEstados);

        return vista;
    }

    public List<EstadosModelo> obtenerEstados(){
        List<EstadosModelo> estado=new ArrayList<>();
        estado.add(new EstadosModelo("Tomas","12/06/2020 23:28",R.drawable.tomas));
        estado.add(new EstadosModelo("Edgardo","12/06/2020 17:12",R.drawable.edgardo));
        estado.add(new EstadosModelo("Erick","12/06/2020 15:57",R.drawable.erick));
        return estado;
    }

}