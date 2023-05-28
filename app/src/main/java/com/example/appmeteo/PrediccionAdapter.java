package com.example.appmeteo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PrediccionAdapter extends RecyclerView.Adapter<PrediccionAdapter.TaskHolder>{

    private ArrayList<DatosPrediccion> listaDatosPrediccion;
    private LayoutInflater inflater;

    public PrediccionAdapter(ArrayList<DatosPrediccion> listaDatosPrediccion, LayoutInflater inflater) {
        this.listaDatosPrediccion = listaDatosPrediccion;
        this.inflater = inflater;
    }

    @NonNull
    @Override
    public PrediccionAdapter.TaskHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View datosPrediccion = inflater.inflate(R.layout.datos_prediccion,parent,false);
        return new TaskHolder(datosPrediccion);
    }
    

    @Override
    public void onBindViewHolder(@NonNull PrediccionAdapter.TaskHolder holder, int position) {


        DatosPrediccion datosPrediccion = listaDatosPrediccion.get(position);
        holder.bind(datosPrediccion);

    }

    @Override
    public int getItemCount() {
        return listaDatosPrediccion.size();
    }

    public class TaskHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private DatosPrediccion datosPrediccion;

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

        public void bind(DatosPrediccion datosPrediccion1) {
            datosPrediccion = datosPrediccion1;
            double temperaturaKelvin = datosPrediccion.getTemperatura();
            double temperaturaCelsius = temperaturaKelvin - 273.15;
            String temperaturaFormateada = String.format("%.1f °C", temperaturaCelsius);
            tvtemperatura.setText(temperaturaFormateada);
            tvclima.setText("Clima: " + datosPrediccion.getClima());
            tvlluvia.setText("Lluvia: "+ datosPrediccion.getLluvia() + " %");

        }

        @Override
        public void onClick(View v) {

        }
    }


}
