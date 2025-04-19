package com.example.login

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.login.databinding.ActivityPantallaPerfilBinding
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class PantallaPerfil : AppCompatActivity() {

    private lateinit var binding: ActivityPantallaPerfilBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityPantallaPerfilBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val correo = intent.getStringExtra("correo")
        val correoRegistrado = intent.getStringExtra("correoRegistrado")
        val nombreRegistrado = intent.getStringExtra("nombreRegistrado")
        binding.tvCorreo.text = correo ?: "Correo no disponible"
        binding.tvCorreo.text = correoRegistrado ?: "Correo no disponible"
        binding.tvNombreUsuario.text = nombreRegistrado ?: "Nombre no disponible"

        binding.btnCS.setOnClickListener {
            Firebase.auth.signOut()
            Toast.makeText(this, "Sesión Cerrada", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

        binding.btnVolver.setOnClickListener {
            val intent = Intent(this, PantallaPrincipal1::class.java)
            startActivity(intent)
        }
    }
}
