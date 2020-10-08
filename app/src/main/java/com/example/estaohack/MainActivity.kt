package com.example.estaohack

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Obter o e-mail do usuario por meio da intent
        val email = intent.getStringExtra("KEY_EMAIL")

        // Recuperar informações no SharedPreferences
        val minhasPreferencias = getSharedPreferences("cadastro-$email", Context.MODE_PRIVATE)

        val nome = minhasPreferencias.getString("KEY_NOME", "Não encontrado")
        val sobreNome = minhasPreferencias.getString("KEY_SOBRENOME", "Não encontrado")
        val genero = minhasPreferencias.getString("KEY_GENERO", "Não encontrado")

        txvNome.text = "$nome $sobreNome"
        txvEmail.text = email
        txvGenero.text = genero

        btnSair.setOnClickListener {
            val mIntent = Intent(this@MainActivity, LoginActivity::class.java)
            startActivity(mIntent)
            finish()
        }

       btnSite.setOnClickListener {
           val  mIntent = (this@MainActivity, WebActivity::class.java)
           startActivity(mIntent)
       }

    }
}
