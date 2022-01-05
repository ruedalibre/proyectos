package com.example.reto4b1.ui.sucursales;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.reto4b1.FormMapsActivity;
import com.example.reto4b1.R;
import com.example.reto4b1.adaptadores.SucursalAdapter;
import com.example.reto4b1.casos_uso.CasoUsoSucursal;
import com.example.reto4b1.databinding.FragmentSucursalesBinding;
import com.example.reto4b1.datos.DBHelper;
import com.example.reto4b1.modelos.Sucursal;

import java.util.ArrayList;

public class SucursalesFragment extends Fragment {

    private FragmentSucursalesBinding binding;

    private String TABLE_NAME = "SUCURSALES";
    private CasoUsoSucursal casoUsoSucursal;
    private GridView gridView;
    private DBHelper dbHelper;
    private ArrayList<Sucursal> sucursales;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        View root = inflater.inflate(R.layout.fragment_sucursales,container,false);
        try{
            casoUsoSucursal = new CasoUsoSucursal();
            dbHelper = new DBHelper(getContext());
            Cursor cursor = dbHelper.getData(TABLE_NAME);
            sucursales = casoUsoSucursal.llenarListaSucursales(cursor);
            gridView = (GridView) root.findViewById(R.id.gridViewSucursales);
            SucursalAdapter sucursalAdapter = new SucursalAdapter(root.getContext(), sucursales);
            gridView.setAdapter(sucursalAdapter);

        }catch (Exception e){
            Toast.makeText(getContext(), e.toString(), Toast.LENGTH_LONG).show();
            Log.w("Error ->>>", e.toString());
        }

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
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
                try{
                    Intent intent = new Intent(getContext(), FormMapsActivity.class);
                    getActivity().startActivity(intent);
                }catch (Exception e){
                    Toast.makeText(getContext(), e.toString(), Toast.LENGTH_SHORT).show();
                }
               /* getActivity().startActivity(intent);
                return true;
            case R.id.action_show:
                Intent intent2 = new Intent(getContext(), MapsActivityShow.class);
                intent2.putExtra("type","1");
                getActivity().startActivity(intent2);*/
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}