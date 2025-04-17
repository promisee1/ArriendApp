package com.example.login

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ArriendoAdapter(private val lista: List<Arriendo>) :
    RecyclerView.Adapter<ArriendoAdapter.ArriendoViewHolder>() {

    class ArriendoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val titulo: TextView = view.findViewById(R.id.tvTitulo)
        val ubicacion: TextView = view.findViewById(R.id.tvUbicacion)
        val precio: TextView = view.findViewById(R.id.tvPrecio)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArriendoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_arriendo, parent, false)
        return ArriendoViewHolder(view)
    }

    override fun onBindViewHolder(holder: ArriendoViewHolder, position: Int) {
        val arriendo = lista[position]
        holder.titulo.text = arriendo.titulo
        holder.ubicacion.text = arriendo.ubicacion
        holder.precio.text = arriendo.precio
    }

    override fun getItemCount(): Int = lista.size
}
