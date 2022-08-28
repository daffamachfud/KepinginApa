package com.daffa.kepinginapa.ui.wallet

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.daffa.core.domain.model.Wallet
import com.daffa.core.domain.usecase.AppUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WalletViewModel @Inject constructor(val useCase: AppUseCase) : ViewModel() {
    val wishlist = useCase.getWishList().asLiveData()
    val wallet = useCase.getWalletData().asLiveData()

    fun inputWallet(wallet: Wallet) {
        viewModelScope.launch {
            useCase.insertWallet(wallet)
        }
    }
}