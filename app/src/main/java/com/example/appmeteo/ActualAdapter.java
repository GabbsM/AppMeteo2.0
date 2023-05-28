package com.example.appmeteo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ActualAdapter extends RecyclerView.Adapter<ActualAdapter.TaskHolder>  {

    private ArrayList<DatosDiarios> listaDatosActual;
    private LayoutInflater inflater;


    public ActualAdapter(ArrayList<DatosDiarios> listaDatosActual, LayoutInflater inflater) {
        this.listaDatosActual = listaDatosActual;
        this.inflater = inflater;
    }


    @NonNull
    @Override
    public ActualAdapter.TaskHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View datosDiarios = inflater.inflate(R.layout.datos_actual,parent,false);
        return new TaskHolder(datosDiarios);
    }

    @Override
    public void onBindViewHolder(@NonNull ActualAdapter.TaskHolder holder, int position) {


        DatosDiarios datosDiarios = listaDatosActual.get(position);
        holder.bind(datosDiarios);

    }

    @Override
    public int getItemCount() {
        return listaDatosActual.size();
    }

    public class TaskHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private DatosDiarios datosDiarios;

        private TextView tvtemperatura;
        private TextView tvclima;
        private TextView tvlluvia;

        private ActualAdapter adapter;

        public TaskHolder(View view){
            super(view);

            tvtemperatura = view.findViewById(R.id.text_temperatura_actual);
            tvclima = view.findViewById(R.id.text_clima_actual);
            tvlluvia = view.findViewById(R.id.text_lluvia_actual);


        }

        public void bind(DatosDiarios datosDiarios1) {
            datosDiarios = datosDiarios1;
            double temperaturaKelvin = datosDiarios.getTemperatura();
            double temperaturaCelsius = temperaturaKelvin - 273.15;
            String temperaturaFormateada = String.format("%.1f °C", temperaturaCelsius);
            tvtemperatura.setText(temperaturaFormateada);
            tvclima.setText("Clima: " + datosDiarios.getClima());
            tvlluvia.setText("Lluvia: "+ datosDiarios.getLluvia() + " %");

        }

        @Override
        public void onClick(View v) {

        }
    }
}
