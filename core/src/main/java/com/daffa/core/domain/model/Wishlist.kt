package com.daffa.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Wishlist(
    val id: Int,
    val title: String,
    val category: String,
    val note: String,
    val price: Double,
    val link: String,
    val imagePath: String,
    val bought: Boolean,
    val deleted: Boolean
) : Parcelable