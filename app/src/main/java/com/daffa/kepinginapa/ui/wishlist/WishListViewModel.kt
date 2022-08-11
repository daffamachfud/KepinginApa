package com.daffa.kepinginapa.ui.wishlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.daffa.core.domain.model.Wishlist
import com.daffa.core.domain.usecase.AppUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WishListViewModel @Inject constructor(private val useCase: AppUseCase) : ViewModel() {

    fun inputWish(wish: Wishlist) {
        viewModelScope.launch {
            useCase.insertWish(wish)
        }
    }
}