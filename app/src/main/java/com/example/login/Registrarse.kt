package com.example.login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.login.databinding.ActivityRegistrarseBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class Registrarse : AppCompatActivity() {

    private lateinit var binding: ActivityRegistrarseBinding
    private lateinit var auth: FirebaseAuth

    companion object {
        private const val TAG = "PantallaRegistrar"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityRegistrarseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = Firebase.auth

        binding.tvyaTienesCuenta.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        binding.btnRegister.setOnClickListener {
            val nombre = binding.etNombre.text.toString().trim()
            val email = binding.etEmail.text.toString().trim()
            val password = binding.etPassword.text.toString().trim()
            val confirmar = binding.etConfirmarPassword.text.toString().trim()

            // Validaciones
            if (nombre.isEmpty()) {
                binding.etNombre.error = "Ingrese su nombre"
                return@setOnClickListener
            }

            if (email.isEmpty()) {
                binding.etEmail.error = "Ingrese su correo"
                return@setOnClickListener
            }

            if (password.isEmpty()) {
                binding.etPassword.error = "Ingrese una contraseña"
                return@setOnClickListener
            }

            if (confirmar.isEmpty()) {
                binding.etConfirmarPassword.error = "Confirme su contraseña"
                return@setOnClickListener
            }

            if (password != confirmar) {
                binding.etConfirmarPassword.error = "Las contraseñas no coinciden"
                return@setOnClickListener
            }

            createAccount(nombre, email, password)
        }
    }

    private fun createAccount(nombre: String, email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    Log.d(TAG, "createUserWithEmail:success")
                    val user = auth.currentUser
                    updateUI(user, nombre)
                } else {
                    Log.w(TAG, "createUserWithEmail:failure", task.exception)
                    Toast.makeText(
                        baseContext,
                        "Registro fallido: ${task.exception?.message}",
                        Toast.LENGTH_SHORT
                    ).show()
                    updateUI(null, "")
                }
            }
    }

    private fun updateUI(user: FirebaseUser?, nombre: String) {
        if (user != null) {
            Toast.makeText(this, "Registro exitoso. Bienvenido ${user.email}", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, PantallaPrincipal1::class.java)
            intent.putExtra("nombreRegistrado", nombre)
            intent.putExtra("correoRegistrado", user.email)
            startActivity(intent)
            finish()
        }
    }
}
