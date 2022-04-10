package com.daffa.kepinginapa.data.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "wishlist")
data class WishlistEntity(

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "id")
    var id: Int?,

    @ColumnInfo(name = "title")
    var title: String?,

    @ColumnInfo(name = "category")
    var category: String?,

    @ColumnInfo(name = "note")
    var note: String?,

    @ColumnInfo(name = "price")
    var price: Double?,

    @ColumnInfo(name = "link")
    var link: String?,

    @ColumnInfo(name = "imagePath")
    var imagePath:String?,

    @ColumnInfo(name = "bought")
    var bought:Boolean?,

    @ColumnInfo(name = "deleted")
    var deleted:Boolean?
)
