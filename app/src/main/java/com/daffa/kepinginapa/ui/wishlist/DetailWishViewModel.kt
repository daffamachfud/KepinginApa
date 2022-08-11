package com.daffa.kepinginapa.ui.wishlist

import androidx.lifecycle.*
import com.daffa.core.data.Resource
import com.daffa.core.domain.model.Wishlist
import com.daffa.core.domain.usecase.AppUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailWishViewModel @Inject constructor(private val useCase: AppUseCase) : ViewModel() {

    private val wishId =MutableLiveData<Int>()

    fun setSelectedWish(wishId: Int){
        this.wishId.value = wishId
    }

    fun deleteWish(wish: Wishlist) {
        viewModelScope.launch {
            useCase.deleteWish(wish)
        }
    }

    fun updateBoughtWish(wish: Wishlist){
        viewModelScope.launch {
            useCase.updateBoughtWish(wish.id)
        }
    }
}