package com.daffa.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class WishlistMonth(
    val id: Int,
    val month: Int,
    val wishlistId: Int
) : Parcelable