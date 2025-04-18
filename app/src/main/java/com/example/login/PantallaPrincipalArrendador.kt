package com.example.login

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.login.databinding.ActivityPantallaPrincipalArrendadorBinding


class PantallaPrincipalArrendador : AppCompatActivity() {

    private lateinit var binding: ActivityPantallaPrincipalArrendadorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPantallaPrincipalArrendadorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Lista de arriendos de ejemplo para el arrendador
        val listaArriendos = listOf(
            Arriendo("Departamento moderno", "Santiago Centro", "$400.000 CLP"),
            Arriendo("Casa familiar", "Ñuñoa", "$600.000 CLP"),
            Arriendo("Pieza para estudiante", "Providencia", "$180.000 CLP")
        )

        // Configurar el RecyclerView
        binding.recyclerArriendos.layoutManager = LinearLayoutManager(this)
        binding.recyclerArriendos.adapter = ArriendoAdapter(listaArriendos)

        // Acción al presionar el botón "Crear"
        binding.btnCrear.setOnClickListener {
            // Aquí se abriría la actividad para crear un nuevo arriendo
        }

        // Acción al presionar el botón "Editar"
        binding.btnEditar.setOnClickListener {
            // Aquí se abriría la actividad para editar un arriendo
        }
    }
}
