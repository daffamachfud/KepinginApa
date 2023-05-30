package com.daffa.core.data.source.local.room

import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.daffa.core.data.source.local.entity.*
import com.daffa.core.utils.CustomTypeConverter

/**Version DB
 * 1 = Initial
 * 2 = Add Table wishlist month entity
 **/
@Database(
    entities = [
        WishlistEntity::class,
        UserEntity::class,
        CategoryEntity::class,
        WalletEntity::class, ],
    version = 2,
    exportSchema = false
)
@TypeConverters(CustomTypeConverter::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun appDao(): AppDao

    companion object {

    }

}