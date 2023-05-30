package com.daffa.core.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.daffa.core.data.source.local.entity.UserEntity
import com.daffa.core.data.source.local.entity.WalletEntity
import com.daffa.core.data.source.local.entity.WishlistEntity
import com.daffa.core.data.source.local.entity.WishlistMonthEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface AppDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: UserEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWish(wish: WishlistEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWallet(wallet:WalletEntity)

//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    suspend fun insertWishlistMonth(wishlistMonthEntity: WishlistMonthEntity)

    @Query("SELECT * FROM user")
    fun getUserData(): Flow<UserEntity>

    @Query("SELECT * FROM wishlist WHERE bought = 0 AND deleted = 0")
    fun getWishlist(): Flow<List<WishlistEntity>>

    @Query("SELECT * FROM wishlist WHERE id = :wishId")
    fun getDetailWish(wishId: Int): LiveData<WishlistEntity>

    @Query("SELECT * FROM wallet")
    fun getWalletData(): Flow<WalletEntity>

    @Query("UPDATE `wishlist` SET bought=1 WHERE id = :id")
    suspend fun updateStatusWish(id: Int?)

    @Query("UPDATE `wishlist` SET deleted=1 WHERE id = :id")
    suspend fun deletedWish(id: Int?)

    @Query("SELECT price from `wishlist` WHERE bought = 1 and deleted = 0")
    fun getDepositData(): Flow<Double>

    @Query("SELECT * from `wishlist` where bought = 1 and deleted = 0")
    fun getAllTransaction(): Flow<List<WishlistEntity>>

//    @Query("SELECT wishlist FROM wishlist_month where month= :month")
//    fun getWishlistByMonth(month : Int): Flow<List<WishlistEntity>>

    @Delete
    fun deleteWish(wish: WishlistEntity)
}