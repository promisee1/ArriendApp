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
        setContentView(binding.root)


        binding.card.setOnClickListener {
            val intent = Intent(this, PantallaExpandidaArriendo::class.java)
            startActivity(intent)

        }

        binding.btnProfile.setOnClickListener {
            val intent = Intent(this, PantallaPerfil::class.java)
            startActivity(intent)
        }
    }
}
