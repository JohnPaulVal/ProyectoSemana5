package com.example.proyectosemana3;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewFragment extends Fragment {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    private Toolbar toolbar;

    @SuppressLint("WrongConstant")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_reciclerview,container,false);

        listaMascotas=(RecyclerView)v.findViewById(R.id.rvContactos);
       // toolbar=(Toolbar)v.findViewById(R.id.miActionBar);



        LinearLayoutManager llm= new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        //LinearLayoutManager glm = new GridLayoutManager(this,2);

        listaMascotas.setLayoutManager(llm);
        incializarListaDeMAscotas();
        inicializarAdapatador();

        return v;
    }


    public void inicializarAdapatador(){
        MascotaAdaptador adaptador= new MascotaAdaptador(mascotas);
        listaMascotas.setAdapter(adaptador);
    }

    public void incializarListaDeMAscotas(){
        mascotas =new ArrayList<Mascota>();

        mascotas.add(new Mascota(R.drawable.masco1,"Pollito",4));
        mascotas.add(new Mascota(R.drawable.masco2,"Pulpito",2));
        mascotas.add(new Mascota(R.drawable.masco3,"Conejito",1));
        mascotas.add(new Mascota(R.drawable.masco4,"Perrito",0));
        mascotas.add(new Mascota(R.drawable.masco5,"Monito",0));
        mascotas.add(new Mascota(R.drawable.masco6,"Gatito",0));
        mascotas.add(new Mascota(R.drawable.masco7,"Croco",3));



    }

}
