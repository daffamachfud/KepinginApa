package com.daffa.core.utils

import com.daffa.core.data.source.local.entity.UserEntity
import com.daffa.core.data.source.local.entity.WalletEntity
import com.daffa.core.data.source.local.entity.WishlistEntity
import com.daffa.core.domain.model.User
import com.daffa.core.domain.model.Wallet
import com.daffa.core.domain.model.Wishlist


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


}