package com.daffa.kepinginapa.ui.home

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.daffa.kepinginapa.databinding.ActivityMainBinding
import com.daffa.kepinginapa.ui.home.adapter.HomeWishlistAdapter
import com.daffa.kepinginapa.ui.wishlist.InputWishlistActivity
import com.daffa.kepinginapa.vo.ViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private val wishlistAdapter = HomeWishlistAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        val factory = ViewModelFactory.getInstance(this)
        viewModel = ViewModelProvider(this, factory)[MainViewModel::class.java]

        binding.loadingListWishlist.visibility = View.VISIBLE
        //load data halaman
        //data user
        viewModel.getUserData().observe(this) { dataUser ->
            if (dataUser.data != null) {
                binding.tvUserName.text = dataUser.data.userName.toString()
                binding.imgProfilePicture.setImageURI(Uri.parse(dataUser.data.profilePicture))
            }
        }

//        loadWishlist()

        with(binding.rvHomeWishlist) {
            layoutManager = LinearLayoutManager(context)
            adapter = wishlistAdapter
        }

        binding.fab.setOnClickListener {
            val intentWish = Intent(this, InputWishlistActivity::class.java)
            startActivity(intentWish)
        }
    }

    override fun onResume() {
        super.onResume()
//        loadWishlist()
    }

    private fun loadWishlist() {
        println("onresponse 1")
        //data wishlist
        viewModel.getWihslistData().observe(this) {
            if (it.data != null) {
                if (it.data.isNotEmpty()) {
                    binding.loadingListWishlist.visibility = View.GONE
                    binding.bgEmpty.visibility = View.GONE
                    binding.tvListCountWishList.visibility = View.VISIBLE
                    wishlistAdapter.setHomeWishlist(it.data)
                    binding.rvHomeWishlist.visibility = View.VISIBLE
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