package com.daffa.kepinginapa.data.local

import androidx.lifecycle.LiveData
import com.daffa.kepinginapa.data.local.entity.UserEntity
import com.daffa.kepinginapa.data.local.entity.WishlistEntity
import com.daffa.kepinginapa.data.local.room.AppDao

class LocalDataSource private constructor(private val mAppDao: AppDao) {

    companion object {
        private var INSTANCE: LocalDataSource? = null

        fun getInstance(appDao: AppDao): LocalDataSource =
            INSTANCE ?: LocalDataSource(appDao)
    }

    fun insertUser(user: UserEntity) = mAppDao.insertUser(user)

    fun insertWish(wish: WishlistEntity) = mAppDao.insertWish(wish)

    fun deleteWish(wish: WishlistEntity) = mAppDao.deletedWish(wish.id)

    fun updateBoughtWish(wishId: Int?) = mAppDao.updateStatusWish(wishId)

    fun getUserData(): LiveData<UserEntity> = mAppDao.getUserData()

    fun getWishlist(): LiveData<List<WishlistEntity>> = mAppDao.getWishlist()

    fun getDetailWish(wishId: Int): LiveData<WishlistEntity> = mAppDao.getDetailWish(wishId)

}