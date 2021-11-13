package com.example.noticiaapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdaptadorNoticia extends RecyclerView.Adapter<AdaptadorNoticia.ViewHolder> {

    String titulo;
    String descripcion;
    String fecha;

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView t_titulo;
        private final TextView t_descripcion;
        private final TextView t_fecha;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View

            t_titulo = (TextView) view.findViewById(R.id.n_titulo);
            t_descripcion = (TextView) view.findViewById(R.id.n_descripcion);
            t_fecha = (TextView) view.findViewById(R.id.n_fecha);
        }
    }

    /**
     * Initialize the dataset of the Adapter.
     *
     * @param dataSet String[] containing the data to populate views to be used
     * by RecyclerView.
     */
    public AdaptadorNoticia(String titulo, String descripcion, String fecha) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fecha = fecha;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.noticias, viewGroup, false);

        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        ArrayList<noticias> lists = DataHolder.getInstance().noticias;
        viewHolder.t_titulo.setText(lists.get(position).getTitulo());
        viewHolder.t_descripcion.setText(lists.get(position).getDescripcion());
        viewHolder.t_fecha.setText(lists.get(position).getFecha());
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return DataHolder.getInstance().noticias.size();
    }
}
