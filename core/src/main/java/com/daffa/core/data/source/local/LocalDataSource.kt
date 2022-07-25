package com.daffa.core.data.source.local

import androidx.lifecycle.LiveData
import com.daffa.core.data.source.local.entity.UserEntity
import com.daffa.core.data.source.local.entity.WishlistEntity
import com.daffa.core.data.source.local.room.AppDao
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalDataSource @Inject constructor(private val appDao: AppDao) {
    fun insertUser(user: UserEntity) = appDao.insertUser(user)

    fun insertWish(wish: WishlistEntity) = appDao.insertWish(wish)

    fun deleteWish(wish: WishlistEntity) = appDao.deletedWish(wish.id)

    fun updateBoughtWish(wishId: Int?) = appDao.updateStatusWish(wishId)

    fun getUserData(): LiveData<UserEntity> = appDao.getUserData()

    fun getWishlist(): LiveData<List<WishlistEntity>> = appDao.getWishlist()

    fun getDetailWish(wishId: Int): LiveData<WishlistEntity> = appDao.getDetailWish(wishId)
}