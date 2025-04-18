package com.example.login

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.login.databinding.ActivityPantallaPrincipal1Binding

class PantallaPrincipal1 : AppCompatActivity() {

    private lateinit var binding: ActivityPantallaPrincipal1Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityPantallaPrincipal1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.cardVerArriendos.setOnClickListener {
            val intent = Intent(this, PantallaPrincipal::class.java)
            startActivity(intent)
        }
        binding.cardSubirArriendo.setOnClickListener {
            val intent = Intent(this, PantallaSubirArriendo::class.java)
            startActivity(intent)                }
    }

}