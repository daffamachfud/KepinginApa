package com.daffa.core.utils

import com.daffa.core.data.source.local.entity.UserEntity
import com.daffa.core.data.source.local.entity.WalletEntity
import com.daffa.core.data.source.local.entity.WishlistEntity
import com.daffa.core.data.source.local.entity.WishlistMonthEntity
import com.daffa.core.domain.model.User
import com.daffa.core.domain.model.Wallet
import com.daffa.core.domain.model.Wishlist
import com.daffa.core.domain.model.WishlistMonth


object DataMapper {

    fun mapUserEntityToDomain(input: UserEntity?) =
        User(
            id = input?.id ?: 0,
            userName = input?.userName ?: "",
            profilePicture = input?.profilePicture ?: ""
        )


    fun mapUserDomainToEntity(input: User) = UserEntity(
        id = input.id,
        userName = input.userName,
        profilePicture = input.profilePicture
    )

    fun mapWishlistEntityToDomain(input: List<WishlistEntity>): List<Wishlist> =
        input.map {
            Wishlist(
                it.id,
                it.title,
                it.category,
                it.note,
                it.price,
                it.link,
                it.imagePath,
                it.bought,
                it.deleted
            )
        }

    fun mapWishlistDomainToEntities(input: Wishlist) = WishlistEntity(
        input.id,
        input.title,
        input.category,
        input.note,
        input.price,
        input.link,
        input.imagePath,
        input.bought,
        input.deleted
    )

    fun mapWalletEntityToDomain(input: WalletEntity?) = Wallet(
        id = input?.id ?: 0,
        date = input?.date ?: "",
        balance = input?.balance ?: 0.0
    )

    fun mapWalletDomainToEntities(input: Wallet) = WalletEntity(
        id = input.id,
        date = input.date,
        balance = input.balance
    )

//    fun mapWishlistMonthEntityToDomain(input: WishlistMonthEntity?) = WishlistMonth(
//        id = input?.id ?: 0,
//        month = input?.month ?: 0,
//        wishlistId = input?.wishlistId ?: 0
//    )
//
//    fun mapWishlistMonthDomainToEntities(input: WishlistMonth) = WishlistMonthEntity(
//        id = input.id,
//        month = input.month,
//        wishlistId = input.wishlistId
//    )


}