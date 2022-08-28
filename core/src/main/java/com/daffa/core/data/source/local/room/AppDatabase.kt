package com.daffa.core.data.source.local.room

import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.RoomDatabase
import com.daffa.core.data.source.local.entity.*

@Database(
    entities = [
        WishlistEntity::class,
        UserEntity::class,
        CategoryEntity::class,
        WalletEntity::class,
        WishlistMonthEntity::class],
    version = 2,
    autoMigrations = [
        AutoMigration (from = 1, to = 2)
    ],
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun appDao(): AppDao

    companion object{

    }

}