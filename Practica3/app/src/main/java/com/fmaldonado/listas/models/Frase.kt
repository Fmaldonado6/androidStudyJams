package com.fmaldonado.listas.models

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Frase(
    @StringRes  val fraseId: Int,
    @DrawableRes val imagenId: Int
)
