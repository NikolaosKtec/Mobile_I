package com.example.aula15_09

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import java.lang.Integer.parseInt

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var variavelX:Int = 0
        var variavelY:Int = 0
        var resultado:Int = 0

        val textViewVarX:TextView = findViewById(R.id.LabelVarX)
        val textViewVarY:TextView = findViewById(R.id.LabelVarY)
        val textViewResult:TextView = findViewById(R.id.Labelresult)
        val textViewX:TextView = findViewById(R.id.textViewX)
        val textViewY:TextView = findViewById(R.id.textViewY)

        val buttonSetX:Button = findViewById(R.id.buttsetVarX)
        val buttonSetY:Button = findViewById(R.id.buttsetVarY)
        val buttonCalc:Button = findViewById(R.id.buttCalcular)

        //tratamento X
        val setVariavelXlauncher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()){
                result ->
            if(result.resultCode == RESULT_OK){


                var bundle = result.data?.extras
                textViewX.text  = bundle?.getString("res")
                textViewVarX.visibility = View.INVISIBLE
            }
        }

        //tratamento Y
        val setVariavelYlauncher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()){
                result ->
            if(result.resultCode == RESULT_OK){


                var bundle = result.data?.extras
                textViewY.text  = bundle?.getString("res")
                textViewVarY.visibility = View.INVISIBLE
            }
        }


        //X button
        buttonSetX.setOnClickListener(){
            val intent = Intent(this, RecebaaActivity::class.java)
            val bundle = Bundle()

            bundle.putString("LABEL","Variavel X")
            bundle.putInt("VALUE",variavelX)
            intent.putExtra("propsA",bundle)

            setVariavelXlauncher.launch(intent)
            //p
        }

        //Y button
        buttonSetY.setOnClickListener(){
            val intent = Intent(this, RecebaaActivity::class.java)
            val bundle = Bundle()

            bundle.putString("LABEL","Variavel Y")
            bundle.putInt("VALUE",variavelY)
            intent.putExtra("propsB",bundle)

            setVariavelYlauncher.launch(intent)
        }

        buttonCalc.setOnClickListener(){
            Toast.makeText(this,getString(R.string.realizarcalc_txt),Toast.LENGTH_SHORT)
                .show()
            variavelX = parseInt(textViewX.text as String)
            variavelY = parseInt(textViewY.text as String)
            textViewResult.text = (variavelX+variavelY).toString()
        }
    }
}