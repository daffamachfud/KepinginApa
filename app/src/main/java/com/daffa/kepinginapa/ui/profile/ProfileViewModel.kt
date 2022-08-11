package com.daffa.kepinginapa.ui.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.daffa.core.domain.usecase.AppUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
@HiltViewModel
class ProfileViewModel @Inject constructor(private val useCase: AppUseCase) : ViewModel() {
    val user = useCase.getUserData().asLiveData()
    val wishlist = useCase.getWishList().asLiveData()
}