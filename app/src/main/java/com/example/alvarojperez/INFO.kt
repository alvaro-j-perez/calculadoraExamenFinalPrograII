package com.example.alvarojperez

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button


class INFO : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)

        //FUNCION DEL BOTON REGRESAR
        // DESTRUYE EL ACTIVITY DE LA INFO Y RETORNA LA CALCULDORA
        val regresar:Button = findViewById(R.id.buttonRegresar)

        regresar.setOnClickListener{
           onBackPressed()

        }
        }
    }

