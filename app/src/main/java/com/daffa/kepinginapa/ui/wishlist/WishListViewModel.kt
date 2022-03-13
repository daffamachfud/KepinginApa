package com.daffa.kepinginapa.ui.wishlist

import androidx.lifecycle.ViewModel
import com.daffa.kepinginapa.data.AppRepository
import com.daffa.kepinginapa.data.local.entity.WishlistEntity

class WishListViewModel(private val appRepository: AppRepository) : ViewModel() {
    fun inputWish(wish: WishlistEntity) {
        appRepository.insertWishlist(
            wish
        )
    }
}