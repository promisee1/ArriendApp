package com.example.login

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
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


        binding.btnCS.setOnClickListener {
            Firebase.auth.signOut()
            Toast.makeText(this, "Sesión Cerrada", Toast.LENGTH_SHORT).show()
            intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }



        binding.btnVolver.setOnClickListener {
            intent = Intent(this, PantallaPrincipal::class.java)
            startActivity(intent)
        }
    }
}