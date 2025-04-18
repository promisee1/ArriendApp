package com.example.login

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.login.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        auth = Firebase.auth

        binding.tvRegistrar.setOnClickListener {
            intent = Intent(this, Registrarse::class.java)
            startActivity(intent)
        }


        binding.btnLogin.setOnClickListener {
            val email = binding.etEmail.text.toString()
            val pass = binding.etPassword.text.toString()

            if(email.isEmpty()){
                binding.etEmail.error = "Por favor ingrese su correo"
                return@setOnClickListener
            }

            if(pass.isEmpty()){
                binding.etPassword.error = "Por favor ingrese su contraseña"
                return@setOnClickListener
            }
            signIn(email,pass)
        }
    }

    private fun signIn(email:String , pass:String) {

        auth.signInWithEmailAndPassword(email,pass)
            .addOnCompleteListener(){
                if(it.isSuccessful){
                    intent = Intent(this, PantallaPrincipal1::class.java)
                    startActivity(intent)
                }else{
                    Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
                }
            }

    }
}
