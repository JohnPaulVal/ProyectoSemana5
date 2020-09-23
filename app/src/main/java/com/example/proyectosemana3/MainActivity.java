package com.example.proyectosemana3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    private int sumas;
    Mascota mas;
   //ArrayList<Mascota>mascotasSuma;

    private TabLayout tabLayout;
    private ViewPager viewPager;

    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout =(TabLayout) findViewById(R.id.tabLayout);
        viewPager =(ViewPager) findViewById(R.id.viewPager);
        ///////TOOL BAR
        Toolbar miActionBAr=(Toolbar)findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBAr);
        ///////TOOL BAR

        setUpViewPager();



        //listaMascotas=(RecyclerView)findViewById(R.id.rvContactos);
        //LinearLayoutManager llm = new LinearLayoutManager(this);
        //llm.setOrientation(LinearLayoutManager.VERTICAL);

        ///   LinearLayoutManager llm= new LinearLayoutManager(this);
        //llm.setOrientation(LinearLayoutManager.VERTICAL);

        // listaMascotas.setLayoutManager(llm);
        // incializarListaDeMAscotas();
        //  inicializarAdapatador();


        //mascotas.get()


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones,menu);
        return true;
        //return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){

            case R.id.mAbout:
                Intent intent= new Intent(this,ActivityContacto.class);
                startActivity(intent);
                break;
            case R.id.mSettings:

                Intent intent2= new Intent(this,ActivityAcercaDe.class);
                startActivity(intent2);

                break;

        }

        return super.onOptionsItemSelected(item);
    }





    public void irSegundaActividad(View v){
        Intent intent =new Intent(this, segundoActivity.class);
        startActivity(intent);
    }

    /*public void inicializarAdapatador(){
        MascotaAdaptador adaptador= new MascotaAdaptador(mascotas);
        listaMascotas.setAdapter(adaptador);
    }

    public void incializarListaDeMAscotas(){
        mascotas =new ArrayList<Mascota>();

        mascotas.add(new Mascota(R.drawable.masco1,"Pollito",5));
        mascotas.add(new Mascota(R.drawable.masco2,"Pulpito",3));
        mascotas.add(new Mascota(R.drawable.masco3,"Conejito",2));
        mascotas.add(new Mascota(R.drawable.masco4,"Perrito",1));
        mascotas.add(new Mascota(R.drawable.masco5,"Monito",0));
        mascotas.add(new Mascota(R.drawable.masco6,"Gatito",1));
        mascotas.add(new Mascota(R.drawable.masco7,"Croco",4));



    }*/

    //public void sumarRaiting(){
      //  mascotas.

    //}

    private ArrayList<Fragment>agregarFragments(){
        ArrayList<Fragment>fragments= new ArrayList<>();
        fragments.add(new RecyclerViewFragment());
        fragments.add(new BlankFragment());
        return fragments;
    }

    private void setUpViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(),agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.fragmentperrito);
        tabLayout.getTabAt(1).setIcon(R.drawable.fragmentcasita);



    }




}
