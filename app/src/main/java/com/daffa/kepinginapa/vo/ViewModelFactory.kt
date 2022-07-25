package com.daffa.kepinginapa.vo

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.daffa.kepinginapa.di.Injection
import com.daffa.kepinginapa.ui.home.MainViewModel
import com.daffa.kepinginapa.ui.landingpage.InputDataUserViewModel
import com.daffa.kepinginapa.ui.profile.ProfileViewModel
import com.daffa.kepinginapa.ui.wishlist.DetailWishViewModel
import com.daffa.kepinginapa.ui.wishlist.WishListViewModel

class ViewModelFactory private constructor(private val mAppRepository: AppRepository) :
    ViewModelProvider.NewInstanceFactory() {
    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(context: Context): ViewModelFactory =
            instance ?: synchronized(this) {
                instance ?: ViewModelFactory(Injection.provideRepository(context))
            }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(InputDataUserViewModel::class.java) -> {
                InputDataUserViewModel(mAppRepository) as T
            }
            modelClass.isAssignableFrom(MainViewModel::class.java) -> {
                MainViewModel(mAppRepository) as T
            }
            modelClass.isAssignableFrom(WishListViewModel::class.java) -> {
                WishListViewModel(mAppRepository) as T
            }
            modelClass.isAssignableFrom(DetailWishViewModel::class.java) -> {
                DetailWishViewModel(mAppRepository) as T
            }
            modelClass.isAssignableFrom(ProfileViewModel::class.java) -> {
                ProfileViewModel(mAppRepository) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }
    }
}