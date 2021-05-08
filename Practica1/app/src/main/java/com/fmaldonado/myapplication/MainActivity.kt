package com.fmaldonado.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val boton = findViewById<Button>(R.id.button)
        val imagen = findViewById<ImageView>(R.id.imageView)
        boton.setOnClickListener {
            val numero = seleccionarNumero()
            when (numero) {
                1 -> imagen.setImageResource(R.drawable.s1)
                2 -> imagen.setImageResource(R.drawable.s2)
                3 -> imagen.setImageResource(R.drawable.s3)
                4 -> imagen.setImageResource(R.drawable.s4)
                5 -> imagen.setImageResource(R.drawable.s5)
                6 -> imagen.setImageResource(R.drawable.s6)
            }
            Snackbar.make(boton, "Episodio $numero" , Snackbar.LENGTH_SHORT).show()
        }

    }

    fun seleccionarNumero(): Int {
        return (1..6).random()
    }

}