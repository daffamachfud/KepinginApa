package com.daffa.kepinginapa.data

import androidx.lifecycle.LiveData
import com.daffa.kepinginapa.data.local.entity.UserEntity
import com.daffa.kepinginapa.data.local.entity.WishlistEntity
import com.daffa.kepinginapa.vo.Resource


interface AppDataSource {
    fun getUserData(): LiveData<Resource<UserEntity>>
    fun getWishlist(): LiveData<Resource<List<WishlistEntity>>>
    fun getDetailWish(wishId: Int): LiveData<Resource<WishlistEntity>>
    fun insertUser(user: UserEntity)
    fun insertWishlist(wish: WishlistEntity)
    fun deleteWish(wish: WishlistEntity)
    fun updateBoughtWish(wish: WishlistEntity)
}