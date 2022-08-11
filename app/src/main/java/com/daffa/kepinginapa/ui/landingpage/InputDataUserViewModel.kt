package com.daffa.kepinginapa.ui.landingpage

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.daffa.core.domain.model.User
import com.daffa.core.domain.usecase.AppUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class InputDataUserViewModel @Inject constructor(val useCase: AppUseCase) : ViewModel() {

    fun inputDataUser(uriImage: String, userName: String) {
        viewModelScope.launch {
            useCase.insertUser(
                User(
                    id = 0,
                    userName = userName,
                    profilePicture = uriImage
                )
            )
        }
    }

}