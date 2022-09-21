package com.example.aula15_09

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView


class RecebaaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recebaa)

        var label = intent.extras?.getString("LABEL")
        var value = intent.extras?.getString("VALUE")


        val textViewVar:TextView = findViewById(R.id.LabelVar)
        val editTextVar:EditText = findViewById(R.id.editTextTextNum)
        val buttonOk:Button = findViewById(R.id.buttonOk)
        val buttonCancelar:Button = findViewById(R.id.buttonCancelar)

        textViewVar.text = label
        //valor a ser mostrado

        //define a variavel x e Y
        buttonOk.setOnClickListener(){
            val intent = Intent(this,MainActivity::class.java)

            intent.putExtra("res",editTextVar.text.toString())


            setResult(RESULT_OK,intent)
            finish()
        }

        buttonCancelar.setOnClickListener(){
            setResult(RESULT_CANCELED)
            finish()
        }


    }
}