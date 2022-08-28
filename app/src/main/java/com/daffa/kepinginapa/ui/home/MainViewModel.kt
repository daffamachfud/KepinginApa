package com.daffa.kepinginapa.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.daffa.core.domain.usecase.AppUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
@HiltViewModel
class MainViewModel @Inject constructor(useCase: AppUseCase) : ViewModel() {
    val user = useCase.getUserData().asLiveData()
    val wishlist = useCase.getWishList().asLiveData()
    val wallet = useCase.getWalletData().asLiveData()
}