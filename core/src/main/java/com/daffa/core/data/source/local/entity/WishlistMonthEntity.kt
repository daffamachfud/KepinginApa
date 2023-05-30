package com.daffa.core.data.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import com.daffa.core.domain.model.Wishlist

@Entity(tableName = "wishlist_month")
data class WishlistMonthEntity(
    @PrimaryKey
    @ColumnInfo(name = "id")
    var id:Int?,

    @ColumnInfo(name = "month")
    var month:Int?,

    @ColumnInfo(name = "wishlist")
    var wishlist: WishlistEntity
)