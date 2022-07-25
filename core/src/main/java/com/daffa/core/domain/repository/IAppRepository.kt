package com.daffa.core.domain.repository

import com.daffa.core.data.Resource
import com.daffa.core.domain.model.User
import com.daffa.core.domain.model.Wishlist
import kotlinx.coroutines.flow.Flow

interface IAppRepository {

    fun getUserData(): Flow<Resource<User>>
    fun getWishList(): Flow<Resource<List<Wishlist>>>
    fun getDetailWish(wishid:Int):Flow<Resource<Wishlist>>

    suspend fun insertUser(user:User)
    suspend fun insertWishlist(wishlist: Wishlist)
    fun deleteWish(wishlist: Wishlist)

    fun updateBoughtWish(wishlist: Wishlist)
}