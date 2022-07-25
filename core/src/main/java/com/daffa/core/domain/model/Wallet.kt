package com.daffa.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Wallet(
    val id: String,
    val date: String,
    val balance: String
) : Parcelable