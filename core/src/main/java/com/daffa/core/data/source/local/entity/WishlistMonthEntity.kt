package com.daffa.core.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.daffa.core.domain.model.Wishlist

@Entity(tableName = "wishlist_month")
data class WishlistMonthEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    var id:Int?,

    @ColumnInfo(name = "month")
    var date:Int?,

    @ColumnInfo(name = "order")
    var listOrder:ArrayList<Wishlist>?
)