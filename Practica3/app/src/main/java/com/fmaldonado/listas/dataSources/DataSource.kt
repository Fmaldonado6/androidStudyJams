package com.fmaldonado.listas.dataSources

import com.fmaldonado.listas.R
import com.fmaldonado.listas.models.Frase

class DataSource {

    fun obtenerFrases():List<Frase>{
        return listOf(
            Frase(R.string.affirmation1),
            Frase(R.string.affirmation2),
            Frase(R.string.affirmation3),
            Frase(R.string.affirmation4),
            Frase(R.string.affirmation5),
            Frase(R.string.affirmation6),
            Frase(R.string.affirmation7),
            Frase(R.string.affirmation8),
            Frase(R.string.affirmation9),
            Frase(R.string.affirmation10),
        )
    }

}