package com.fmaldonado.calculadorapropinas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fmaldonado.calculadorapropinas.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.calcularBoton.setOnClickListener { calcularPropina() }
    }

    fun calcularPropina() {
        val total = binding.total.text.toString().toDoubleOrNull()

        if (total == null) {
            Snackbar.make(
                binding.calcularBoton,
                "Por favor ingrese un valor",
                Snackbar.LENGTH_SHORT
            ).show()
            return
        }

        val porcentaje = when (binding.opciones.checkedRadioButtonId) {
            binding.opcionExcelente.id -> .20
            binding.opcionBien.id -> .18
            else -> .15
        }

        var propina = total * porcentaje
        val redondear = binding.switchRedondear.isChecked

        if (redondear) {
            propina = kotlin.math.ceil(propina)
        }

        val propinaFormato = NumberFormat.getCurrencyInstance().format(propina)

        binding.propina.text = resources.getString(R.string.cantidad_propina, propinaFormato)
    }

}