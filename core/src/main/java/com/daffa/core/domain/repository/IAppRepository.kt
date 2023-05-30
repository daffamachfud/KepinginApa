package com.daffa.core.domain.repository

import com.daffa.core.data.Resource
import com.daffa.core.domain.model.User
import com.daffa.core.domain.model.Wallet
import com.daffa.core.domain.model.Wishlist
import com.daffa.core.domain.model.WishlistMonth
import kotlinx.coroutines.flow.Flow

interface IAppRepository {

    fun getUserData(): Flow<Resource<User>>
    fun getWishList(): Flow<Resource<List<Wishlist>>>
    fun getWalletData(): Flow<Resource<Wallet>>

    fun getDepositData(): Flow<Resource<Double>>

    fun getAllTransaction(): Flow<Resource<List<Wishlist>>> //wishlist yang udah di beli

//    fun getWishlistMonth(month: Int): Flow<Resource<List<Wishlist>>>

    suspend fun insertUser(user:User)
    suspend fun insertWishlist(wishlist: Wishlist)
    suspend fun insertWallet(wallet: Wallet)
    suspend fun deleteWish(wishlist: Wishlist)

//    suspend fun insertWishlistMonth(wishlistMonth: WishlistMonth)

    suspend fun updateBoughtWish(wishId:Int)
}