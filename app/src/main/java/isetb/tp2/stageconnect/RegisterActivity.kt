package isetb.tp2.stageconnect

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val etNom = findViewById<EditText>(R.id.etNom)
        val etPrenom = findViewById<EditText>(R.id.etPrenom)
        val etEmail = findViewById<EditText>(R.id.etEmail)
        val etTelephone = findViewById<EditText>(R.id.etTelephone)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val etConfirmPassword = findViewById<EditText>(R.id.etConfirmPassword)
        val radioGroupUserType = findViewById<RadioGroup>(R.id.radioGroupUserType)
        val btnRegister = findViewById<Button>(R.id.btnRegister)

        btnRegister.setOnClickListener {
            val nom = etNom.text.toString().trim()
            val prenom = etPrenom.text.toString().trim()
            val email = etEmail.text.toString().trim()
            val telephone = etTelephone.text.toString().trim()
            val password = etPassword.text.toString().trim()
            val confirmPassword = etConfirmPassword.text.toString().trim()

            // Naarfou anhe type etselecta mel RadioGroup
            val selectedTypeId = radioGroupUserType.checkedRadioButtonId
            val selectedType = when (selectedTypeId) {
                R.id.rbEntreprise -> "Entreprise"
                R.id.rbEtablissement -> "Établissement universitaire"
                else -> "Étudiant"
            }

            if (nom.isEmpty() || prenom.isEmpty() || email.isEmpty() || telephone.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                Toast.makeText(this, "Veuillez remplir tous les champs", Toast.LENGTH_SHORT).show()
            } else if (password != confirmPassword) {
                Toast.makeText(this, "Les mots de passe ne correspondent pas", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Inscription réussie ($selectedType) : $email", Toast.LENGTH_LONG).show()
                finish()
            }
        }
    }
}