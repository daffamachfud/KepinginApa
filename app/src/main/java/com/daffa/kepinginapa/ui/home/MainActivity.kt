package com.daffa.kepinginapa.ui.home

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.daffa.kepinginapa.R
import com.daffa.kepinginapa.databinding.ActivityMainBinding
import com.daffa.kepinginapa.ui.home.adapter.HomeWishlistAdapter
import com.daffa.kepinginapa.ui.profile.ProfileActivity
import com.daffa.kepinginapa.ui.wishlist.InputWishlistActivity
import com.daffa.kepinginapa.utils.Utils
import com.daffa.kepinginapa.vo.ViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private val wishlistAdapter = HomeWishlistAdapter()
    private var username = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val factory = ViewModelFactory.getInstance(this)
        viewModel = ViewModelProvider(this, factory)[MainViewModel::class.java]

        binding.loadingListWishlist.visibility = View.VISIBLE
        //load data page
        //data user
        viewModel.getUserData().observe(this) { dataUser ->
            if (dataUser.data != null) {
                binding.tvUserName.text = dataUser.data.userName.toString()
                username = dataUser.data.userName.toString()
                val uriPathHelper = Utils.UriPathHelper()
                val filePath = uriPathHelper.getPath(this, Uri.parse(dataUser.data.profilePicture))
                binding.imgProfilePicture.setImageURI(Uri.parse(filePath))

            }
        }

        loadWishlist()

        with(binding.rvHomeWishlist) {
            layoutManager = GridLayoutManager(context, 2)
            adapter = wishlistAdapter
        }

        binding.fab.setOnClickListener {
            val intentWish = Intent(this, InputWishlistActivity::class.java)
            startActivity(intentWish)
        }

//        binding.imgProfilePicture.setOnClickListener {
//            val intentProfile = Intent(this, ProfileActivity::class.java)
//            startActivity(intentProfile)
//        }
    }

    override fun onResume() {
        super.onResume()
        loadWishlist()
    }

    private fun loadWishlist() {
        //data wishlist
        viewModel.getWishListData().observe(this) {
            if (it.data != null) {
                for(item in it.data){
                    Log.d("onResumeDataAfterDelete","Nama Barang : ${item.title}")
                }
                if (it.data.isNotEmpty()) {
                    binding.loadingListWishlist.visibility = View.GONE
                    binding.bgEmpty.visibility = View.GONE
                    binding.tvListCountWishList.visibility = View.VISIBLE
                    wishlistAdapter.setHomeWishlist(it.data)
                    binding.rvHomeWishlist.visibility = View.VISIBLE
                    binding.tvListCountWishList.text = resources.getString(
                        R.string.kamu_punya_keinginan,
                        it.data.count().toString()
                    )
                } else {
                    binding.loadingListWishlist.visibility = View.GONE
                    binding.bgEmpty.visibility = View.VISIBLE
                    binding.tvListCountWishList.visibility = View.GONE
                    binding.rvHomeWishlist.visibility = View.GONE
                }
            }
        }
    }


}