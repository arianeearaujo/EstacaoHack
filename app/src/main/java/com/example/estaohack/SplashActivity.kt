package com.example.estaohack

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashActivity : AppCompatActivity() {
    //Life Cycle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        //Executar uma ação após determinado tempo
        Handler().postDelayed({
            //intent
            val mIntent = Intent(this, LoginActivity::class.java)
            startActivity(mIntent)

        },3000)
        //Remove a activity da pilha de activities
        finish()
    }
}
