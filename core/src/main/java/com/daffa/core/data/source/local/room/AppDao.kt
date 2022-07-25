package com.daffa.core.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.daffa.core.data.source.local.entity.UserEntity
import com.daffa.core.data.source.local.entity.WishlistEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface AppDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: UserEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertWish(wish: WishlistEntity)

    @Query("SELECT * FROM user")
    fun getUserData(): Flow<UserEntity>

    @Query("SELECT * FROM wishlist WHERE bought = 0 AND deleted = 0")
    fun getWishlist(): Flow<List<WishlistEntity>>

    @Query("SELECT * FROM wishlist WHERE id = :wishId")
    fun getDetailWish(wishId: Int): LiveData<WishlistEntity>

    @Query("UPDATE `wishlist` SET bought=1 WHERE id = :id")
    fun updateStatusWish(id: Int?)

    @Query("UPDATE `wishlist` SET deleted=1 WHERE id = :id")
    fun deletedWish(id: Int?)

    @Delete
    fun deleteWish(wish: WishlistEntity)
}