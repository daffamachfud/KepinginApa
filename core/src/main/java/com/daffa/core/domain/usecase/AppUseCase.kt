package com.daffa.core.domain.usecase

import com.daffa.core.data.Resource
import com.daffa.core.domain.model.User
import com.daffa.core.domain.model.Wishlist
import kotlinx.coroutines.flow.Flow

interface AppUseCase {
    fun getUserData(): Flow<Resource<User>>
    fun getWishList():Flow<Resource<List<Wishlist>>>

   suspend fun insertUser(user:User)
    suspend fun insertWish(wishlist: Wishlist)
    suspend fun deleteWish(wishlist: Wishlist)
    suspend fun updateBoughtWish(wishId:Int)
}