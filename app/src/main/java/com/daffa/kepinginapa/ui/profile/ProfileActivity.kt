package com.daffa.kepinginapa.ui.profile

import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.daffa.kepinginapa.R
import com.daffa.kepinginapa.databinding.ActivityProfileBinding
import com.daffa.kepinginapa.utils.Utils
import com.daffa.kepinginapa.vo.ViewModelFactory

class ProfileActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProfileBinding
    private lateinit var viewModel: ProfileViewModel
    private val wishlistAdapter = ProfileWishAdapter()
    private var username = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val factory = ViewModelFactory.getInstance(this)
        viewModel = ViewModelProvider(this, factory)[ProfileViewModel::class.java]

        binding.loadingListWishlist.visibility = View.VISIBLE
        //load data page
        //data user
        viewModel.getUserData().observe(this) { dataUser ->
            if (dataUser.data != null) {
                binding.tvUsernameProfile.visibility = View.VISIBLE
                binding.imgProfile.visibility = View.VISIBLE
                binding.tvHello.visibility = View.VISIBLE

                binding.tvUsernameProfile.text = dataUser.data.userName.toString()
                username = dataUser.data.userName.toString()
                val uriPathHelper = Utils.UriPathHelper()
                val filePath = uriPathHelper.getPath(this, Uri.parse(dataUser.data.profilePicture))
                binding.imgProfile.setImageURI(Uri.parse(filePath))

            }
        }

        binding.btnBack.setOnClickListener {
            finish()
        }

        loadProfileWishList()

        with(binding.rvWishProfile) {
            layoutManager = GridLayoutManager(context,3)
            adapter = wishlistAdapter
        }
    }

    private fun loadProfileWishList() {
        viewModel.getWishListData().observe(this) {
            if (it.data != null) {
                if (it.data.isNotEmpty()) {
                    binding.loadingListWishlist.visibility = View.GONE
                    binding.tvCountWish.visibility = View.VISIBLE
                    binding.bgEmpty.visibility = View.GONE
                    binding.rvWishProfile.visibility = View.VISIBLE
                    wishlistAdapter.setProfileWishList(it.data)
                    binding.tvCountWish.text = resources.getString(
                        R.string.kamu_punya,
                        it.data.count().toString()
                    )
                }else{
                    binding.bgEmpty.visibility = View.VISIBLE
                    binding.loadingListWishlist.visibility = View.GONE
                    binding.rvWishProfile.visibility = View.GONE
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        loadProfileWishList()
    }
}