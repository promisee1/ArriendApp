package com.example.login

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.login.databinding.ActivityRegistrarseBinding

class Registrarse : AppCompatActivity() {

    private lateinit var binding: ActivityRegistrarseBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrarseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnRegistrar.setOnClickListener {
            val email = binding.etEmail.text.toString().trim()
            val pass = binding.etPassword.text.toString().trim()
            val confirm = binding.etConfirmPassword.text.toString().trim()

            if (email.isEmpty()) {
                binding.tilEmail.error = "Campo obligatorio"
                return@setOnClickListener
            } else {
                binding.tilEmail.error = null
            }

            if (pass.isEmpty()) {
                binding.tilPassword.error = "Campo obligatorio"
                return@setOnClickListener
            } else {
                binding.tilPassword.error = null
            }

            if (confirm.isEmpty() || pass != confirm) {
                binding.tilConfirm.error = "Las contraseñas no coinciden"
                return@setOnClickListener
            } else {
                binding.tilConfirm.error = null
            }

            // Acción posterior a la validación (por ejemplo, mostrar mensaje)
            Toast.makeText(this, "Datos válidos. Usuario listo para registrar (sin Firebase).", Toast.LENGTH_SHORT).show()
        }
    }
}
