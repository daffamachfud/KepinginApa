package com.daffa.kepinginapa.data.local.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.daffa.kepinginapa.data.local.entity.UserEntity
import com.daffa.kepinginapa.data.local.entity.WishlistEntity


@Dao
interface AppDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(user: UserEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertWish(wish: WishlistEntity)

    @Query("SELECT * FROM user")
    fun getUserData(): LiveData<UserEntity>

    @Query("SELECT * FROM wishlist WHERE bought = 0 AND deleted = 0")
    fun getWishlist(): LiveData<List<WishlistEntity>>

    @Query("SELECT * FROM wishlist WHERE id = :wishId")
    fun getDetailWish(wishId:Int):LiveData<WishlistEntity>

    @Query("UPDATE `wishlist` SET bought=1 WHERE id = :id")
    fun updateStatusWish(id: Int?)

    @Query("UPDATE `wishlist` SET deleted=1 WHERE id = :id")
    fun deletedWish(id: Int?)

    @Delete
    fun deleteWish(wish: WishlistEntity)

}