package mx.edu.itson.asignacion04_calculadoraimc_castilloana

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    //Declaracion de Variables
    var resultadoIMC: Float = 0.0f
    val txtWeight: EditText = findViewById(R.id.txtWeight)
    val txtHeight: EditText = findViewById(R.id.txtHeight)
    val imc: TextView = findViewById(R.id.imc)
    val range: TextView = findViewById(R.id.range)
    val btnCalcular: Button = findViewById(R.id.btnCalcular)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Event button
        btnCalcular.setOnClickListener {
            calculateIMC()
            imc.setText(resultadoIMC.toString())
            determinateRange()
            range.setText(range.toString())
        }
    }

    //Function
    fun calculateIMC(): Float{
        val resultadoIMC= txtWeight.getText().toString().toFloat() / (txtHeight.getText().toString().toFloat() * txtHeight.getText().toString().toFloat())
        return resultadoIMC
    }

    //Function
    fun determinateRange(): TextView {
        if(resultadoIMC < 18.5) {
            range.setText("Bajo peso")
            range.setBackgroundColor(R.color.greenish)
        }
        else if(resultadoIMC >= 18.5 || resultadoIMC <=24.9) {
            range.setText("Normal")
            range.setBackgroundColor(R.color.green)
        }
        else if( resultadoIMC >= 25 || resultadoIMC <=29.9) {
            range.setText("Sobrepeso")
            range.setBackgroundColor(R.color.yellow)
        }
        else if(resultadoIMC >= 30 || resultadoIMC <=34.9) {
            range.setText("Obesidad grado 1")
            range.setBackgroundColor(R.color.orange)
        }
        else if(resultadoIMC >= 35 || resultadoIMC <=39.9) {
            range.setText("Obesidad grado 2")
            range.setBackgroundColor(R.color.red)
        }
        else if(resultadoIMC >= 40 ) {
            range.setText("Obesidad grado 3")
            range.setBackgroundColor(R.color.brown)
        }
        return range
    }
}