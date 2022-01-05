package com.example.reto2.ui.servicios;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.reto2.FormActivity;
import com.example.reto2.R;
import com.example.reto2.adaptadores.ServicioAdapter;
import com.example.reto2.casos_uso.CasoUsoServicio;
import com.example.reto2.databinding.FragmentServiciosBinding;
import com.example.reto2.datos.DBHelper;
import com.example.reto2.modelos.Servicio;

import java.util.ArrayList;

public class ServiciosFragment extends Fragment {
    private String TABLE_NAME = "SERVICIOS";
    private CasoUsoServicio casoUsoServicio;
    private GridView gridView;
    private DBHelper dbHelper;
    private ArrayList<Servicio> servicios;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_servicios, container,false);
        try{
            casoUsoServicio = new CasoUsoServicio();
            dbHelper = new DBHelper(getContext());
            Cursor cursor = dbHelper.getData(TABLE_NAME);
            servicios = casoUsoServicio.llenarListaServicios(cursor);
            gridView = (GridView) root.findViewById(R.id.gridServicios);
            ServicioAdapter servicioAdapter = new ServicioAdapter(root.getContext(), servicios);
            gridView.setAdapter(servicioAdapter);
        }catch (Exception e){
            Toast.makeText(getContext(), e.toString(), Toast.LENGTH_LONG).show();
        }

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_add:
                Intent intent = new Intent(getContext(), FormActivity.class);
                intent.putExtra("name","SERVICIOS");
                getActivity().startActivity(intent);
                //Toast.makeText(getContext(), "Hola Servicios", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}