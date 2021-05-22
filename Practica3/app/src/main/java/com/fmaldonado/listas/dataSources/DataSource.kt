package com.fmaldonado.listas.dataSources

import com.fmaldonado.listas.R
import com.fmaldonado.listas.models.Frase

class DataSource {

    fun obtenerFrases():List<Frase>{
        return listOf(
            Frase(R.string.affirmation1,R.drawable.image1),
            Frase(R.string.affirmation2,R.drawable.image2),
            Frase(R.string.affirmation3,R.drawable.image3),
            Frase(R.string.affirmation4,R.drawable.image4),
            Frase(R.string.affirmation5,R.drawable.image5),
            Frase(R.string.affirmation6,R.drawable.image6),
            Frase(R.string.affirmation7,R.drawable.image7),
            Frase(R.string.affirmation8,R.drawable.image8),
            Frase(R.string.affirmation9,R.drawable.image9),
            Frase(R.string.affirmation10,R.drawable.image10),
        )
    }

}