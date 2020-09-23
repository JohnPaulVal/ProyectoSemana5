package com.example.proyectosemana3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class segundoActivity extends AppCompatActivity {
    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;

    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segundo);
///TOOL BAR

        Toolbar miActionBAr=(Toolbar)findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBAr);

        //IR ATRAS
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //////////

        listaMascotas=(RecyclerView)findViewById(R.id.rvMascotas2);
        //LinearLayoutManager llm = new LinearLayoutManager(this);
        //llm.setOrientation(LinearLayoutManager.VERTICAL);

        LinearLayoutManager llm= new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);
        incializarListaDeMAscotas();
        inicializarAdapatador();






    }

    public void inicializarAdapatador(){
        MascotaAdaptador adaptador= new MascotaAdaptador(mascotas);
        listaMascotas.setAdapter(adaptador);
    }

    public void incializarListaDeMAscotas(){
        mascotas =new ArrayList<Mascota>();

        mascotas.add(new Mascota(R.drawable.masco1,"Pollito",4));
        mascotas.add(new Mascota(R.drawable.masco7,"Croco",3));
        mascotas.add(new Mascota(R.drawable.masco2,"Pulpito",2));
        mascotas.add(new Mascota(R.drawable.masco3,"Conejito",1));
        mascotas.add(new Mascota(R.drawable.masco4,"Perrito",0));





    }





}
