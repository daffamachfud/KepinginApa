package com.daffa.core.utils

import androidx.room.TypeConverter
import com.daffa.core.domain.model.Wishlist
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class CustomTypeConverter {

    @TypeConverter
    fun wishlistToString(value: Wishlist?): String? {
        return Gson().toJson(value)
    }

    @TypeConverter
    fun stringToWishlist(value: String?): Wishlist? {
        return Gson().fromJson(value, object : TypeToken<Wishlist?>() {}.type)
    }
}