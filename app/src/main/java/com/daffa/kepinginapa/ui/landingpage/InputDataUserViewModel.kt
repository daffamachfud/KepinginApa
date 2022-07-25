package com.daffa.kepinginapa.ui.landingpage

import androidx.lifecycle.ViewModel
import com.daffa.kepinginapa.data.local.entity.UserEntity

class InputDataUserViewModel(private val appRepository: AppRepository) : ViewModel() {

    fun inputDataUser(uriImage: String, userName: String) {
        appRepository.insertUser(
            UserEntity(
                0, userName, uriImage
            )
        )
    }

}