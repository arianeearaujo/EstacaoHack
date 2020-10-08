package com.example.estaohack

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.core.content.edit
import kotlinx.android.synthetic.main.activity_cadastro.*

class CadastroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        // Criando uma lista de opçóes para o spinner (array ou vetor)
        // Lista mutável Ctrl+D (arrayListof)
        val listaGenero = arrayOf(
            "Selecione o gênero",
            "Masculino",
            "Feminino",
            "Outros")

        //Criando o adaptador para o spinner
        val spinnerAdapter = ArrayAdapter(
            this@CadastroActivity,
            android.R.layout.simple_spinner_dropdown_item,
            listaGenero
        )

        // Plugando o adaptador
        spnGênero.adapter = spinnerAdapter

        // Escutando o botáo cadastrar
        btnEntrarCadastro.setOnClickListener {

            //Obtendo os dados
            val nome = edtNome.text.toString().trim()
            val sobreNome = edtSobrenome.text.toString().trim()
            val email = edtCadastroEmail.text.toString().trim()
            val senha = edtCadastroSenha.text.toString().trim()

            var genero = ""
            if (spnGênero.selectedItemId != 0L) {
                genero = spnGênero.selectedItem.toString()
            }

            //Validando os campos preenchidos
            if (nome.isEmpty() ||
                sobreNome.isEmpty()||
                email.isEmpty() ||
                genero.isEmpty() ){

                //Mensagem de erro
                Toast.makeText(
                    this@CadastroActivity,
                    "Todos os campos são obrigatórios",
                    Toast.LENGTH_LONG
                ).show()
            } else {
                //Salvando os dados nas preferencias compartilhadas (SharedPreferences)
                val minhasPreferencias = getSharedPreferences(
                    "cadastro-$edtCadastroEmail",
                    Context.MODE_PRIVATE
                )
                // Habilitar o SharedPreferences para edição
                // Funções de contexto when, let, apply
                minhasPreferencias.edit().apply {
                    putString("KEY_NOME", nome)
                    putString("KEY_SOBRENOME", sobreNome)
                    putString("KEY_EMAIL", email)
                    putString("KEY_SENHA", senha)
                    putString("KEY_GENERO", genero)
                }.apply()

            }
        }
    }
}