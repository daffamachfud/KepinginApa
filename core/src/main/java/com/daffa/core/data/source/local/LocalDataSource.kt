package com.daffa.core.data.source.local

import androidx.lifecycle.LiveData
import com.daffa.core.data.source.local.entity.UserEntity
import com.daffa.core.data.source.local.entity.WalletEntity
import com.daffa.core.data.source.local.entity.WishlistEntity
import com.daffa.core.data.source.local.room.AppDao
import com.daffa.core.domain.model.Wallet
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalDataSource @Inject constructor(private val appDao: AppDao) {
    suspend fun insertUser(user: UserEntity) = appDao.insertUser(user)

    suspend fun insertWish(wish: WishlistEntity) = appDao.insertWish(wish)

    suspend fun insertWallet(wallet: WalletEntity) = appDao.insertWallet(wallet)

    suspend fun deleteWish(wish: WishlistEntity) = appDao.deletedWish(wish.id)

    suspend fun updateBoughtWish(wishId: Int?) = appDao.updateStatusWish(wishId)

    fun getUserData(): Flow<UserEntity> = appDao.getUserData()

    fun getWishlist(): Flow<List<WishlistEntity>> = appDao.getWishlist()

    fun getWalletData(): Flow<WalletEntity> = appDao.getWalletData()
}