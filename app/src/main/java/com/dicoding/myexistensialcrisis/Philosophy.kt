package com.dicoding.myexistensialcrisis

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Philosophy(
    val name: String,
    val description: String,
    val photos: Int
) : Parcelable
