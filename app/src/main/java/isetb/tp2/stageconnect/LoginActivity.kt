package isetb.tp2.stageconnect

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val etLoginEmail = findViewById<EditText>(R.id.etLoginEmail)
        val etLoginPassword = findViewById<EditText>(R.id.etLoginPassword)
        val btnLoginSubmit = findViewById<Button>(R.id.btnLoginSubmit)
        val tvGoToRegisterFromLogin = findViewById<TextView>(R.id.tvGoToRegisterFromLogin)

        // Action mtaâ el Bouton de Connexion
        btnLoginSubmit.setOnClickListener {
            val email = etLoginEmail.text.toString().trim()
            val password = etLoginPassword.text.toString().trim()

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Veuillez remplir tous les champs", Toast.LENGTH_SHORT).show()
            } else {
                // Houni mbe3d n-conectiw m3a l'API Spring Boot
                Toast.makeText(this, "Connexion réussie pour : $email", Toast.LENGTH_SHORT).show()
            }
        }

        // Action ki n-enzelou 3la "S'inscrire" bch yhezzna lel RegisterActivity
        tvGoToRegisterFromLogin.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}