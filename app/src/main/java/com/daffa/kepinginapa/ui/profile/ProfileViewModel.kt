package com.daffa.kepinginapa.ui.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.daffa.kepinginapa.data.local.entity.UserEntity
import com.daffa.kepinginapa.data.local.entity.WishlistEntity
import com.daffa.kepinginapa.vo.Resource

class ProfileViewModel(private val appRepository: AppRepository) : ViewModel() {
    fun getUserData(): LiveData<Resource<UserEntity>> = appRepository.getUserData()
    fun getWishListData(): LiveData<Resource<List<WishlistEntity>>> = appRepository.getWishlist()
}