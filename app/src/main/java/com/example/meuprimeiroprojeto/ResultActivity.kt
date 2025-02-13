package com.example.meuprimeiroprojeto
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val tvResult = findViewById<TextView>(R.id.textview_result)
        val tvClassicacao = findViewById<TextView> (R.id.textview_classificacao)

        val result = intent.getFloatExtra("EXTRA_RESULT", 0.1f)

        tvResult.text = result.toString()

        /* TABELA IMC
        MENOR QUE 18,5      ABAIXO DE PESO 0
        ENTRE 18,5 E 24,9   NORMAL 0
        ENTRE 25,0 E 29,9   SOBREPESO I
        ENTRE 30,0 E 39,9   OBESIDADE II
        MAIOR QUE 40,0      OBESIDADE GRAVE III
         */

        val classicacao = if (result <18.5){
            "ABAIXO DO PESO"
        }else if  (result in 18.5f..24.9f){
            "NORMAL"
        }else if (result in 25f..29.9f){
            "SOBREPESO"
        }else if(result in 30f..39.9f){
            "OBESIDADE"
        }else{
            "OBESIDADE GRAVE"
        }

        tvClassicacao.text = getString(R.string.message_classificacao,classicacao)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onContextItemSelected(item)

    }
}