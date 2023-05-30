package com.daffa.core.data

import com.daffa.core.data.source.local.LocalDataSource
import com.daffa.core.domain.model.User
import com.daffa.core.domain.model.Wallet
import com.daffa.core.domain.model.Wishlist
import com.daffa.core.domain.model.WishlistMonth
import com.daffa.core.domain.repository.IAppRepository
import com.daffa.core.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class AppRepository @Inject constructor(
    private val localDataSource: LocalDataSource
) : IAppRepository {

    override fun getUserData(): Flow<Resource<User>> =
        object : NetworkBoundResource<User>() {
            override fun loadFromDB(): Flow<User> {
                return localDataSource.getUserData().map {
                    DataMapper.mapUserEntityToDomain(it)
                }
            }
        }.asFlow()

    override fun getWishList(): Flow<Resource<List<Wishlist>>> =
        object : NetworkBoundResource<List<Wishlist>>() {
            override fun loadFromDB(): Flow<List<Wishlist>> {
                return localDataSource.getWishlist().map {
                    DataMapper.mapWishlistEntityToDomain(it)
                }
            }
        }.asFlow()

    override fun getWalletData(): Flow<Resource<Wallet>> =
        object : NetworkBoundResource<Wallet>() {
            override fun loadFromDB(): Flow<Wallet> {
                return localDataSource.getWalletData().map {
                    DataMapper.mapWalletEntityToDomain(it)
                }
            }
        }.asFlow()

    override fun getDepositData(): Flow<Resource<Double>> =
        object : NetworkBoundResource<Double>() {
            override fun loadFromDB(): Flow<Double> {
                return localDataSource.getDepositData()
            }
        }.asFlow()

    override fun getAllTransaction(): Flow<Resource<List<Wishlist>>> =
        object : NetworkBoundResource<List<Wishlist>>() {
            override fun loadFromDB(): Flow<List<Wishlist>> {
                return localDataSource.getAllTransaction().map {
                    DataMapper.mapWishlistEntityToDomain(it)
                }
            }
        }.asFlow()

//    override fun getWishlistMonth(month:Int): Flow<Resource<List<Wishlist>>> =
//        object : NetworkBoundResource<List<Wishlist>>() {
//            override fun loadFromDB(): Flow<List<Wishlist>> {
//                return localDataSource.getWishlistMonth(month).map {
//                    DataMapper.mapWishlistEntityToDomain(it)
//                }
//            }
//        }.asFlow()

    override suspend fun insertUser(user: User) {
        localDataSource.insertUser(
            DataMapper.mapUserDomainToEntity(user)
        )
    }

    override suspend fun insertWishlist(wishlist: Wishlist) {
        localDataSource.insertWish(
            DataMapper.mapWishlistDomainToEntities(wishlist)
        )
    }

    override suspend fun insertWallet(wallet: Wallet) {
        localDataSource.insertWallet(
            DataMapper.mapWalletDomainToEntities(wallet)
        )
    }

    override suspend fun deleteWish(wishlist: Wishlist) {
        val wishEntity = DataMapper.mapWishlistDomainToEntities(wishlist)
        localDataSource.deleteWish(wishEntity)
    }

//    override suspend fun insertWishlistMonth(wishlistMonth: WishlistMonth) {
//        localDataSource.insertWishlistMont(
//            DataMapper.mapWishlistMonthDomainToEntities(wishlistMonth)
//        )
//    }

    override suspend fun updateBoughtWish(wishId: Int) {
        localDataSource.updateBoughtWish(wishId)
    }

}