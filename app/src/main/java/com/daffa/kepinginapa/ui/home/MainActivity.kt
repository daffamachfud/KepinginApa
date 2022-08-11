package com.daffa.kepinginapa.ui.home

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.daffa.core.data.Resource
import com.daffa.core.ui.HomeWishlistAdapter
import com.daffa.kepinginapa.R
import com.daffa.kepinginapa.databinding.ActivityMainBinding
import com.daffa.kepinginapa.ui.profile.ProfileActivity
import com.daffa.kepinginapa.ui.wishlist.DetailWishlistActivity
import com.daffa.kepinginapa.ui.wishlist.InputWishlistActivity
import com.daffa.kepinginapa.utils.Utils
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()
    private val wishlistAdapter = HomeWishlistAdapter()
    private var username = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //load data page
        //data user
        viewModel.user.observe(this) { dataUser ->
            if (dataUser != null) {
                when (dataUser) {
                    is Resource.Loading -> {}
                    is Resource.Success -> {
                        binding.tvUserName.text = dataUser.data?.userName ?: ""
                        val uriPathHelper = Utils.UriPathHelper()
                        val filePath = uriPathHelper.getPath(
                            this, Uri.parse(
                                dataUser.data?.profilePicture
                                    ?: ""
                            )
                        )
                        binding.imgProfilePicture.setImageURI(Uri.parse(filePath))
                    }
                    is Resource.Error -> {}
                }
            }
        }

        loadWishlist()

        with(binding.rvHomeWishlist) {
            layoutManager = LinearLayoutManager(context)
            adapter = wishlistAdapter
        }

        wishlistAdapter.onItemClick = { select ->
            val intent = Intent(this, DetailWishlistActivity::class.java)
            intent.putExtra(DetailWishlistActivity.EXTRA_WISH, select)
            startActivity(intent)
        }

        binding.fab.setOnClickListener {
            val intentWish = Intent(this, InputWishlistActivity::class.java)
            startActivity(intentWish)
        }

        binding.imgProfilePicture.setOnClickListener {
            val intentProfile = Intent(this, ProfileActivity::class.java)
            startActivity(intentProfile)
        }
    }

    override fun onResume() {
        super.onResume()
        loadWishlist()
    }

    private fun loadWishlist() {
        //data wishlist
        viewModel.wishlist.observe(this) { wishlist ->
            if (wishlist != null) {
                when (wishlist) {
                    is Resource.Loading -> {
                        binding.loadingListWishlist.visibility = View.VISIBLE
                    }

                    is Resource.Success -> {
                        binding.loadingListWishlist.visibility = View.GONE
                        if (wishlist.data?.isNotEmpty() == true) {
                            binding.bgEmpty.visibility = View.GONE
                            binding.tvListCountWishList.visibility = View.VISIBLE
                            wishlistAdapter.setHomeWishlist(wishlist.data)
                            binding.rvHomeWishlist.visibility = View.VISIBLE

                            val count = wishlist.data?.count() ?: ""

                            binding.tvListCountWishList.text = resources.getString(
                                R.string.list_kepingin_main,
                                username,
                                count.toString()
                            )
                        } else {
                            binding.loadingListWishlist.visibility = View.GONE
                            binding.bgEmpty.visibility = View.VISIBLE
                            binding.tvListCountWishList.visibility = View.GONE
                            binding.rvHomeWishlist.visibility = View.GONE
                        }
                    }
                    is Resource.Error -> {}
                }
            }
        }
    }
}