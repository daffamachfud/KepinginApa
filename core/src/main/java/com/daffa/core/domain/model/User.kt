package com.daffa.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    val id: Int,
    val userName: String,
    val profilePicture: String
) : Parcelable