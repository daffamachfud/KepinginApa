package com.daffa.core.data

import com.daffa.core.data.source.local.LocalDataSource
import com.daffa.core.domain.model.User
import com.daffa.core.domain.model.Wishlist
import com.daffa.core.domain.repository.IAppRepository
import com.daffa.core.utils.AppExecutors
import com.daffa.core.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class AppRepository @Inject constructor(
    private val localDataSource: LocalDataSource
) : IAppRepository {

    companion object {
        @Volatile
        private var instance: AppRepository? = null
        fun getInstance(
            localData: LocalDataSource
        ): AppRepository =
            instance ?: synchronized(this) {
                instance ?: AppRepository(localData)
            }
    }

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

    override suspend fun deleteWish(wishlist: Wishlist) {
        val wishEntity = DataMapper.mapWishlistDomainToEntities(wishlist)
        localDataSource.deleteWish(wishEntity)
    }

    override suspend fun updateBoughtWish(wishId: Int) {
        localDataSource.updateBoughtWish(wishId)
    }


//    override fun getUserData(): LiveData<Resource<UserEntity>> {
//        return object : NetworkBoundResource<UserEntity>(){
//            override fun loadFromDB(): LiveData<UserEntity> = localDataSource.getUserData()
//        }.asLiveData()
//    }
//
//    override fun getWishlist(): LiveData<Resource<List<WishlistEntity>>> {
//        return object : NetworkBoundResource<List<WishlistEntity>>(){
//            override fun loadFromDB(): LiveData<List<WishlistEntity>> = localDataSource.getWishlist()
//        }.asLiveData()
//    }
//
//    override fun getDetailWish(wishId: Int): LiveData<Resource<WishlistEntity>> {
//        return object : NetworkBoundResource<WishlistEntity>() {
//            override fun loadFromDB(): LiveData<WishlistEntity> =
//                localDataSource.getDetailWish(wishId)
//        }.asLiveData()
//    }
//
//
//    override fun insertUser(user: UserEntity) {
//        val runnable = { localDataSource.insertUser(user) }
//        appExecutors.diskIO().execute(runnable)
//    }
//
//    override fun insertWishlist(wish: WishlistEntity) {
//        val runnable = {
//            localDataSource.insertWish(wish)
//        }
//        appExecutors.diskIO().execute(runnable)
//    }
//
//    override fun deleteWish(wish: WishlistEntity) {
//        val runnable = {
//            localDataSource.deleteWish(wish)
//        }
//        appExecutors.diskIO().execute(runnable)
//    }
//
//    override fun updateBoughtWish(wish: WishlistEntity) {
//        val runnable = {
//            localDataSource.updateBoughtWish(wish.id)
//        }
//        appExecutors.diskIO().execute(runnable)
//    }

}