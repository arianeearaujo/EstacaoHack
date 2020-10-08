package com.example.estaohack

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Executando o botão entrar
        btnLoginEntrar.setOnClickListener {

            val usuario = edtLoginEmail.text.toString().trim()
            val senha = edtLoginSenha.text.toString().trim()

            // Validando os dados
            if(usuario.isEmpty()){
                edtLoginEmail.error = "Campo Obrigatório!"
                edtLoginEmail.requestFocus()

            }else if(senha.isEmpty()){
                edtLoginSenha.error = "Campo Obrigatório!"
                edtLoginSenha.requestFocus()

            } else {
                if (usuario == "ariane@gmail.com" && senha == "1234"){
                    Toast.makeText(this@LoginActivity,
                        "Usuário Logado",
                        Toast.LENGTH_LONG)
                        .show()

                    // Mudando para MainActivity
                    val mIntent = Intent(this,MainActivity:: class.java)
                    startActivity(mIntent)

                }else{
                    Toast.makeText(this@LoginActivity,
                        "Usuário ou Senha Incorreta",
                        Toast.LENGTH_LONG)
                        .show()

                }
            }

        }

            // Ir para a tela de cadastro
            btnEntrarCadastro.setOnClickListener {
                val mIntent = Intent(this,CadastroActivity:: class.java)
                startActivity(mIntent)
                finish()
            }
    }
}
