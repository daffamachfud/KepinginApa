package com.daffa.kepinginapa.ui.landingpage

import androidx.lifecycle.ViewModel

class InputDataUserViewModel : ViewModel() {
    private lateinit var uriImage: String
    private lateinit var userName: String

    fun setDataUser(uriImage: String, userName: String) {
        this.uriImage = uriImage
        this.userName = userName
    }
}