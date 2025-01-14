package com.example.noticiasactivity


import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.noticiasactivity.NoticiasActivity
import com.example.noticiasactivity.R
import com.google.android.material.textfield.TextInputEditText

class LoginActivity : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        sharedPreferences = getSharedPreferences("LoginPrefs", MODE_PRIVATE)

        val userEditText = findViewById<TextInputEditText>(R.id.textInputEditText)
        val passwordEditText = findViewById<TextInputEditText>(R.id.editText)
        val loginButton = findViewById<Button>(R.id.button)

        // Autocompletar si hay datos guardados
        userEditText.setText(sharedPreferences.getString("username", ""))
        passwordEditText.setText(sharedPreferences.getString("password", ""))

        loginButton.setOnClickListener {
            val username = userEditText.text.toString()
            val password = passwordEditText.text.toString()

            if (username.isNotEmpty() && password.isNotEmpty()) {
                // Guardar datos en SharedPreferences
                sharedPreferences.edit().apply {
                    putString("username", username)
                    putString("password", password)
                    apply()
                }

                // Navegar a NoticiasActivity
                val intent = Intent(this, NoticiasActivity::class.java)
                startActivity(intent)
            }
        }
    }
}
