package com.fmaldonado.listas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fmaldonado.listas.adapters.FraseAdapter
import com.fmaldonado.listas.dataSources.DataSource
import com.fmaldonado.listas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val datos = DataSource().obtenerFrases()
        binding.lista.adapter = FraseAdapter(datos, this)
    }
}