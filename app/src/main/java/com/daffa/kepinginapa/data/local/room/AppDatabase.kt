package com.daffa.kepinginapa.data.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.daffa.kepinginapa.data.local.entity.CategoryEntity
import com.daffa.kepinginapa.data.local.entity.UserEntity
import com.daffa.kepinginapa.data.local.entity.WalletEntity
import com.daffa.kepinginapa.data.local.entity.WishlistEntity

@Database(
    entities = [UserEntity::class, CategoryEntity::class, WalletEntity::class, WishlistEntity::class],
    version = 1, exportSchema = false
)

abstract class AppDatabase : RoomDatabase() {
    abstract fun appDao(): AppDao

    companion object {

        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "kepinginApa.db"
                ).build()
            }
    }
}