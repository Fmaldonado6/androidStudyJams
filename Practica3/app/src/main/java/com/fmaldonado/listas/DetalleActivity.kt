package com.fmaldonado.listas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.fmaldonado.listas.databinding.ActivityDetalleBinding

class DetalleActivity : AppCompatActivity() {

    lateinit var binding: ActivityDetalleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetalleBinding.inflate(layoutInflater)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val fraseId = intent.getIntExtra("fraseId", R.string.affirmation1)
        val imagenId = intent.getIntExtra("imagenId", R.drawable.image1)

        binding.fraseDetalle.text = getString(fraseId)
        binding.imagenDetalle.setImageResource(imagenId)

        setContentView(binding.root)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if(item.itemId == android.R.id.home){
            finish()
        }

        return super.onOptionsItemSelected(item)
    }

}