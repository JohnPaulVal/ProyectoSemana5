package com.example.proyectosemana3;


import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;


    public BlankFragment() {
        // Required empty public constructor
    }


    //@SuppressLint("WrongConstant")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_blank, container, false);

        listaMascotas=(RecyclerView)v.findViewById(R.id.rvMascotasGrid);
        // toolbar=(Toolbar)v.findViewById(R.id.miActionBar);



        //LinearLayoutManager llm= new LinearLayoutManager(getActivity());
        //llm.setOrientation(LinearLayoutManager.VERTICAL);
       GridLayoutManager glm = new GridLayoutManager(getActivity(),3);

        listaMascotas.setLayoutManager(glm);
        incializarListaDeMAscotas();
        inicializarAdapatador();





        return v;
    }


    public void inicializarAdapatador(){
        MAscotaAdapatadorGrid adaptador= new MAscotaAdapatadorGrid(mascotas);
        listaMascotas.setAdapter(adaptador);
    }

    public void incializarListaDeMAscotas(){
        mascotas =new ArrayList<Mascota>();

        mascotas.add(new Mascota(R.drawable.masco1,"Pollito",0));
        mascotas.add(new Mascota(R.drawable.masco2,"Pulpito",0));
        mascotas.add(new Mascota(R.drawable.masco3,"Conejito",0));
        mascotas.add(new Mascota(R.drawable.masco4,"Perrito",0));
        mascotas.add(new Mascota(R.drawable.masco5,"Monito",0));
        mascotas.add(new Mascota(R.drawable.masco6,"Gatito",0));
        mascotas.add(new Mascota(R.drawable.masco7,"Croco",0));



    }

}
