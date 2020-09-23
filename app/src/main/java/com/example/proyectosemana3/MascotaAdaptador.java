package com.example.proyectosemana3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder> {
    ArrayList<Mascota>mascotas;


    public MascotaAdaptador(ArrayList<Mascota>mascotas){
        this.mascotas=mascotas;
    }


    @NonNull
    @Override
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.carview_mascota,parent,false);
        return new MascotaViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull MascotaViewHolder mascotaViewHolder, int position) {
        Mascota mascota=mascotas.get(position);
        mascotaViewHolder.imgFoto.setImageResource(mascota.getFoto());
        mascotaViewHolder.tvNombreCV.setText(mascota.getNombre());
        mascotaViewHolder.tvRaitingCV.setText(mascota.getValoreRaiting()+" ");


    }

    @Override
    public int getItemCount() {//CANTIDAD DER ELEMENTOS QUE CONTIENE MI LISTA
        return mascotas.size();
    }







    public static class MascotaViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgFoto;
        private TextView tvNombreCV;
        private TextView tvRaitingCV;

        public MascotaViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFoto=(ImageView)itemView.findViewById(R.id.imgFoto);
            tvNombreCV=(TextView)itemView.findViewById(R.id.tvNombreCV);
            tvRaitingCV=(TextView)itemView.findViewById(R.id.tvRaitingCV);
        }
    }


}
