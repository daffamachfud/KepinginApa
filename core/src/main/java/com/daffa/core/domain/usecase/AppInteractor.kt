package com.daffa.core.domain.usecase

import com.daffa.core.data.Resource
import com.daffa.core.domain.model.User
import com.daffa.core.domain.model.Wallet
import com.daffa.core.domain.model.Wishlist
import com.daffa.core.domain.repository.IAppRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AppInteractor @Inject constructor(private val appRepository: IAppRepository) : AppUseCase {
    override fun getUserData(): Flow<Resource<User>> = appRepository.getUserData()

    override fun getWishList(): Flow<Resource<List<Wishlist>>> = appRepository.getWishList()
    override fun getWalletData(): Flow<Resource<Wallet>> = appRepository.getWalletData()

    override suspend fun insertUser(user: User) {
        appRepository.insertUser(user)
    }

    override suspend fun insertWish(wishlist: Wishlist) {
        appRepository.insertWishlist(wishlist)
    }

    override suspend fun insertWallet(wallet: Wallet) {
        appRepository.insertWallet(wallet)
    }

    override suspend fun deleteWish(wishlist: Wishlist) {
        appRepository.deleteWish(wishlist)
    }

    override suspend fun updateBoughtWish(wishId: Int) {
       appRepository.updateBoughtWish(wishId)
    }


}