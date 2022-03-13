package com.daffa.kepinginapa.data

import androidx.lifecycle.LiveData
import com.daffa.kepinginapa.data.local.LocalDataSource
import com.daffa.kepinginapa.data.local.entity.UserEntity
import com.daffa.kepinginapa.data.local.entity.WishlistEntity
import com.daffa.kepinginapa.utils.AppExecutors
import com.daffa.kepinginapa.vo.Resource


class AppRepository private constructor(
    private val localDataSource: LocalDataSource, private val appExecutors: AppExecutors
) :
    AppDataSource {

    companion object {
        @Volatile
        private var instance: AppRepository? = null
        fun getInstance(
            localData: LocalDataSource,
            appExecutors: AppExecutors
        ): AppRepository =
            instance ?: synchronized(this) {
                instance ?: AppRepository(localData, appExecutors)
            }
    }

    override fun getUserData(): LiveData<Resource<UserEntity>> {
        return object : NetworkBoundResource<UserEntity>(){
            override fun loadFromDB(): LiveData<UserEntity> = localDataSource.getUserData()
        }.asLiveData()
    }

    override fun getWishlist(): LiveData<Resource<List<WishlistEntity>>> {
        return object : NetworkBoundResource<List<WishlistEntity>>(){
            override fun loadFromDB(): LiveData<List<WishlistEntity>> = localDataSource.getWishlist()
        }.asLiveData()
    }

    override fun insertUser(user: UserEntity) {
        val runnable = { localDataSource.insertUser(user) }
        appExecutors.diskIO().execute(runnable)
    }

    override fun insertWishlist(wish: WishlistEntity) {
        val runnable = {
            localDataSource.insertWish(wish)
        }
        appExecutors.diskIO().execute(runnable)
    }

}