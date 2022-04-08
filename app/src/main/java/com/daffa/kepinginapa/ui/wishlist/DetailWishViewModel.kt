package com.daffa.kepinginapa.ui.wishlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.daffa.kepinginapa.data.AppRepository
import com.daffa.kepinginapa.data.local.entity.WishlistEntity
import com.daffa.kepinginapa.vo.Resource

class DetailWishViewModel(private val appRepository: AppRepository) : ViewModel() {

    private val wishId =MutableLiveData<Int>()

    fun setSelectedWish(wishId: Int){
        this.wishId.value = wishId
    }

    fun deleteWish(wish: WishlistEntity) {
        appRepository.deleteWish(
            wish
        )
    }

    var detailWish: LiveData<Resource<WishlistEntity>> = Transformations.switchMap(wishId){
        appRepository.getDetailWish(it)
    }
}