package com.example.login

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.login.R

class PantallaPrincipal : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pantalla_principal)

        // Referencia al RecyclerView
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerArriendos)

        // Lista de datos de ejemplo
        val listaArriendos = listOf(
            Arriendo("Departamento moderno", "Santiago Centro", "$400.000 CLP"),
            Arriendo("Casa familiar", "Ñuñoa", "$600.000 CLP"),
            Arriendo("Pieza para estudiante", "Providencia", "$180.000 CLP")
        )

        // Configurar el RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = ArriendoAdapter(listaArriendos)
    }
}
