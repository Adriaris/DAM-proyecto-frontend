package com.example.proyectom13
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class CuidadorAdapter(private val listaCuidadores: List<Cuidador>) : RecyclerView.Adapter<CuidadorAdapter.CuidadorViewHolder>() {

    // ViewHolder que contiene las vistas para cada ítem
    class CuidadorViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.image_view)
        val nombreTextView: TextView = itemView.findViewById(R.id.nombre_text_view)
        val puntuacionTextView: TextView = itemView.findViewById(R.id.puntuacion_text_view)
        val precioTextView: TextView = itemView.findViewById(R.id.precio_text_view)
    }

    // Crear nuevos views (invocado por el layout manager)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CuidadorViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_cuidador, parent, false)
        return CuidadorViewHolder(itemView)
    }

    // Reemplaza el contenido de una vista (invocado por el layout manager)
    override fun onBindViewHolder(holder: CuidadorViewHolder, position: Int) {
        val currentItem = listaCuidadores[position]
        holder.nombreTextView.text = currentItem.nombre
        holder.puntuacionTextView.text = currentItem.puntuacion.toString()
        holder.precioTextView.text = "${currentItem.precio} €"
        holder.imageView.setImageResource(currentItem.fotoUrl) // Establecer imagen desde drawable
    }


    // Retorna el tamaño de tu dataset (invocado por el layout manager)
    override fun getItemCount() = listaCuidadores.size
}
