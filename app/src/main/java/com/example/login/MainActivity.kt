package com.example.login

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.login.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import com.google.firebase.ktx.Firebase
import com.google.firebase.auth.ktx.auth

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = Firebase.auth

        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()

        val googleSignInClient = GoogleSignIn.getClient(this, gso)

        binding.signInGoogle.setOnClickListener {
            val signInIntent: Intent = googleSignInClient.signInIntent
            signInLauncher.launch(signInIntent)
        }

        binding.tvRegistrar.setOnClickListener {
            intent = Intent(this, Registrarse::class.java)
            startActivity(intent)
        }

        binding.btnLogin.setOnClickListener {
            val email = binding.etEmail.text.toString()
            val pass = binding.etPassword.text.toString()

            if (email.isEmpty()) {
                binding.etEmail.error = "Por favor ingrese su correo"
                return@setOnClickListener
            }

            if (pass.isEmpty()) {
                binding.etPassword.error = "Por favor ingrese su contraseña"
                return@setOnClickListener
            }

            signIn(email, pass)
        }
    }

    private fun signIn(email: String, pass: String) {
        auth.signInWithEmailAndPassword(email, pass)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    val intent = Intent(this, PantallaPrincipal1::class.java)
                    intent.putExtra("correo", email)
                    startActivity(intent)
                    finish()
                } else {
                    Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
                }
            }
    }


    private val signInLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == RESULT_OK) {
            val task: Task<GoogleSignInAccount> = GoogleSignIn.getSignedInAccountFromIntent(result.data)
            try {
                val account = task.getResult(ApiException::class.java)
                account?.idToken?.let {
                    firebaseAuthWithGoogle(it)
                }
            } catch (e: ApiException) {
                Toast.makeText(this, "Error en la autenticación de Google", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun firebaseAuthWithGoogle(idToken: String) {
        val credential = GoogleAuthProvider.getCredential(idToken, null)
        auth.signInWithCredential(credential)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val user = auth.currentUser
                    val email = user?.email ?: "correo@desconocido.com"

                    val intent = Intent(this, PantallaPrincipal1::class.java)
                    intent.putExtra("correo", email)
                    startActivity(intent)
                    finish()
                } else {
                    Toast.makeText(this, "Error autenticando con Firebase", Toast.LENGTH_SHORT).show()
                }
            }
    }

}

