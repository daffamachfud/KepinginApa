package com.daffa.core.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "wallet")
data class WalletEntity(
    @PrimaryKey
    @ColumnInfo(name = "id")
    var id:Int?,

    @ColumnInfo(name = "date")
    var date:String?,

    @ColumnInfo(name = "balance")
    var balance:Double?
)