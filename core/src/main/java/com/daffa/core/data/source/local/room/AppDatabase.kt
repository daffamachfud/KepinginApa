package com.daffa.core.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.daffa.core.data.source.local.entity.CategoryEntity
import com.daffa.core.data.source.local.entity.UserEntity
import com.daffa.core.data.source.local.entity.WalletEntity
import com.daffa.core.data.source.local.entity.WishlistEntity

@Database(
    entities = [WishlistEntity::class, UserEntity::class, CategoryEntity::class, WalletEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun appDao(): AppDao

}