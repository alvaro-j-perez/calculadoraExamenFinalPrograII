package com.example.alvarojperez

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_info.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //variables globales para almacenar los datos que se ingresen al operar
    private var num1 = 0.0
    private var num2 = 0.0
    private var operacion = 0


    //CONSTANTES CONSTANTES QUE SE USAN PARA LA FUNCION DE LA LOGICA DE LOS OPERADORES
    companion object {
        const val SUMA = 1
        const val RESTA = 2
        const val MULTIPLICACION = 3
        const val DIVISION = 4
        const val SIN_OPERACION = 0
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // FUNCION DEL BOTON INFO
        // MANDA A LLAMAR AL ACTIVITY DE LA INFORMACION
        val regresar:Button= findViewById(R.id.back)
        regresar.setOnClickListener{
            val intent  = Intent(this,INFO::class.java
            )
        startActivity(intent)
        }


        //ESTADO INICIAL DE LA CALCULADORA CUANDO INICIE EL PROGRAMA
        //ESTADO INICIAL CUANDO PRESIONES EL BORTON BORRAR
        resultado.text = "0"
        operacion = SIN_OPERACION


        //FUNCION DE LOS BOTONES DE LOS NUMEROS
        uno.setOnClickListener { eventoClick("1") }
        dos.setOnClickListener { eventoClick("2") }
        tres.setOnClickListener { eventoClick("3") }
        cuatro.setOnClickListener { eventoClick("4") }
        cinco.setOnClickListener { eventoClick("5") }
        seis.setOnClickListener { eventoClick("6") }
        siete.setOnClickListener { eventoClick("7") }
        ocho.setOnClickListener { eventoClick("8") }
        nueve.setOnClickListener { eventoClick("9") }
        cero.setOnClickListener { eventoClick("0") }
        decimales.setOnClickListener { eventoClick(".") }



        //FUNCION DE LOS BOTONES DE LOS OPERADORES
        suma.setOnClickListener {eventoOperacion(SUMA) }
        resta.setOnClickListener { eventoOperacion(RESTA) }
        multiplicacion.setOnClickListener { eventoOperacion(MULTIPLICACION) }
        division.setOnClickListener { eventoOperacion(DIVISION) }


        //FUNCION DEL BOTON IGUAL
        igual.setOnClickListener { resuelveOperacion() }

        //FUNCION DEL BOTON LIMPIAR
        button16.setOnClickListener {resetAll() }
    }

    // FUNCION DEL EVENTO LIMPIAR
    // SERA EL ESTADO INICIAL CUANDO SE OPRIMA EL BOTON
    private fun resetAll(){
        val resultado:TextView = findViewById(R.id.resultado)
        resultado.text = "0"
        operacion = 0
        num1 = 0.0
        num2 = 0.0
    }

    // FUNCION QUE HACE QUE CUANDO SE OPRIMA EL BOTON DIGA QUE SE HACE CON LOS NUMEROS
    // ES LA FUNCION DEL EVENTO CLICK DE LOS BOTONES
    private fun eventoClick(num: String){
        if(resultado.text == "0" && num != ".") {
            resultado.text = "$num"
        } else {
            resultado.text = "${resultado.text}$num"
        }

        if(operacion == SIN_OPERACION){
            num1 = resultado.text.toString().toDouble()
        } else {
            num2 = resultado.text.toString().toDouble()
        }
    }


    // EVENTO DE LA FUNCION OPERACION
    // CUANDO LA OPERACION ESTE EN CURSO LLAMA A LA FUNCION DE LA OPERACIOON

    private fun eventoOperacion(operacion: Int){
        this.operacion = operacion
        num1 = resultado.text.toString().toDouble()

        resultado.text = "0"
    }


    //FUNCION DE LA PARTE LOGICA DE LAS OPERACIONES
    // RESUELVE TODAS LAS OPERACIONES
    private fun resuelveOperacion(){

        val result = when(operacion) {
            SUMA -> num1 + num2
            RESTA -> num1 - num2
            MULTIPLICACION -> num1 * num2
            DIVISION -> num1 / num2
            else -> 0
        }

        //SE GUARDA EL RESULTADO EN FORMA DE STRING Y SE CONCATENA
        //FUNCION PARA UTILIZAR EL PUNTO OSEA DECIMALES
        num1 = result as Double

        resultado.text = if("$result".endsWith(".0"))
        {
            "$result".replace(".0","")
        }
        else { "%.2f".format(result) }
    }



}