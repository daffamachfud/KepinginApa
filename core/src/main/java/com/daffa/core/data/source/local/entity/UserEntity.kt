package com.daffa.core.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class UserEntity(
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "id")
    var id:Int,

    @ColumnInfo(name = "username")
    var userName:String,

    @ColumnInfo(name = "profilePicture")
    var profilePicture:String
)
