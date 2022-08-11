package com.daffa.kepinginapa.ui.profile

import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.daffa.core.data.Resource
import com.daffa.core.ui.ProfileWishAdapter
import com.daffa.kepinginapa.R
import com.daffa.kepinginapa.databinding.ActivityProfileBinding
import com.daffa.kepinginapa.utils.Utils
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProfileActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProfileBinding
    private val viewModel: ProfileViewModel by viewModels()

    private val wishlistAdapter = ProfileWishAdapter()
    private var username = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.loadingListWishlist.visibility = View.VISIBLE
        //load data page
        //data user

        viewModel.user.observe(this) { dataUser ->
            if (dataUser != null) {
                when (dataUser) {
                    is Resource.Loading -> {}
                    is Resource.Success -> {
                        binding.tvUsernameProfile.text = dataUser.data?.userName ?: ""
                        val uriPathHelper = Utils.UriPathHelper()
                        val filePath = uriPathHelper.getPath(
                            this, Uri.parse(
                                dataUser.data?.profilePicture
                                    ?: ""
                            )
                        )
                        binding.imgProfile.setImageURI(Uri.parse(filePath))
                    }
                    is Resource.Error -> {}
                }
            }
        }


        binding.btnBack.setOnClickListener {
            finish()
        }

        loadProfileWishList()

        with(binding.rvWishProfile) {
            layoutManager = GridLayoutManager(context, 3)
            adapter = wishlistAdapter
        }

        binding.btnHelp.setOnClickListener {
            FaqDialogFragment().show(
                supportFragmentManager, ""
            )
        }

        binding.imgProfile.setOnLongClickListener {
            Toast.makeText(this, "Fitur ini belum tersedia", Toast.LENGTH_SHORT).show()
            return@setOnLongClickListener true
        }
    }

    private fun loadProfileWishList() {

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
                            binding.tvCountWish.visibility = View.VISIBLE
                            wishlistAdapter.setProfileWishList(wishlist.data)
                            binding.rvWishProfile.visibility = View.VISIBLE

                            val count = wishlist.data?.count() ?: ""

                            binding.tvCountWish.text = resources.getString(
                                R.string.list_kepingin_main,
                                username,
                                count.toString()
                            )
                        } else {
                            binding.loadingListWishlist.visibility = View.GONE
                            binding.bgEmpty.visibility = View.VISIBLE
                            binding.tvCountWish.visibility = View.GONE
                            binding.rvWishProfile.visibility = View.GONE
                        }
                    }
                    is Resource.Error -> {}
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        loadProfileWishList()
    }
}