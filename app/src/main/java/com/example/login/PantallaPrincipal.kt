package com.example.login

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.login.databinding.ActivityPantallaPrincipalBinding

class PantallaPrincipal : AppCompatActivity() {

    private lateinit var binding: ActivityPantallaPrincipalBinding // Declara el binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPantallaPrincipalBinding.inflate(layoutInflater) // Inicializa el binding
        setContentView(binding.root) // Configura el layout con el binding

        // Lista de datos de ejemplo
        val listaArriendos = listOf(
            Arriendo("Departamento moderno", "Santiago Centro", "$400.000 CLP"),
            Arriendo("Casa familiar", "Ñuñoa", "$600.000 CLP"),
            Arriendo("Pieza para estudiante", "Providencia", "$180.000 CLP")
        )

        // Configurar el RecyclerView
        binding.recyclerArriendos.layoutManager = LinearLayoutManager(this)
        binding.recyclerArriendos.adapter = ArriendoAdapter(listaArriendos)

        // Configurar el botón de perfil
        binding.btnProfile.setOnClickListener {
            val intent = Intent(this,  Perfil::class.java)
            startActivity(intent)
        }
    }
}
