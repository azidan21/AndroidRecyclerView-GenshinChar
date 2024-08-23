package com.dicoding.mygenshincharacter

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GenshinCharacter(
    val name: String,
    val description: String,
    val photo: Int,
    val vision: String,
    val weapon: String,
    val association: String
) :Parcelable
