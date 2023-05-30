package com.daffa.kepinginapa.ui.home

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.daffa.core.data.Resource
import com.daffa.core.ui.HomeWishlistAdapter
import com.daffa.kepinginapa.databinding.ActivityWalletBinding
import com.daffa.kepinginapa.databinding.FragmentHomeBinding
import com.daffa.kepinginapa.ui.wishlist.DetailWishlistActivity
import com.daffa.kepinginapa.ui.wishlist.InputWishlistActivity
import com.daffa.kepinginapa.utils.Utils
import com.daffa.kepinginapa.utils.Utils.formatCurrencyRupiah
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val viewModel: MainViewModel by viewModels()
    private val wishlistAdapter = HomeWishlistAdapter()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        viewModel.user.observe(requireActivity()) { dataUser ->
            if (dataUser != null) {
                when (dataUser) {
                    is Resource.Loading -> {}
                    is Resource.Success -> {
                        binding.tvUsernameHome.text = dataUser.data?.userName ?: ""
                        val uriPathHelper = Utils.UriPathHelper()
                        val filePath = uriPathHelper.getPath(
                            requireActivity(), Uri.parse(
                                dataUser.data?.profilePicture
                                    ?: ""
                            )
                        )
                        try {
                            binding.imgProfileHome.setImageURI(Uri.parse(filePath))
                        }catch (e:Exception){
                            Log.e("HoemFragment","Error = ${e.localizedMessage}")
                        }
                    }
                    is Resource.Error -> {}
                }
            }
        }

        //data wallet
        viewModel.wallet.observe(requireActivity()) { dataWallet ->
            if (dataWallet != null) {
                when (dataWallet) {
                    is Resource.Loading -> {}
                    is Resource.Success -> {
                        binding.tvTotalNeeded.text = dataWallet.data?.balance.formatCurrencyRupiah()
                    }
                    is Resource.Error -> {}
                }
            }
        }

        loadWishlist()

        with(binding.rvWishlistHome) {
            this.layoutManager = StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL)
//            this?.addItemDecoration(Utils.WishlistDecoration(requireContext()))
            this.adapter = wishlistAdapter

        }

        wishlistAdapter.onItemClick = { select ->
            val intent = Intent(requireActivity(), DetailWishlistActivity::class.java)
            intent.putExtra(DetailWishlistActivity.EXTRA_WISH, select)
            startActivity(intent)
        }

        binding.btnAddWishlist.setOnClickListener {
            val intent = Intent(requireActivity(),InputWishlistActivity::class.java)
            startActivity(intent)
        }


        return binding.root
    }

    private fun loadWishlist() {
        //data wishlist
        viewModel.wishlist.observe(requireActivity()) { wishlist ->
            if (wishlist != null) {
                when (wishlist) {
                    is Resource.Loading -> {
                        binding.loadingListWishlist.visibility = View.VISIBLE
                    }

                    is Resource.Success -> {
                        binding.loadingListWishlist.visibility = View.GONE
                        if (wishlist.data?.isNotEmpty() == true) {
                            binding.bgEmpty.visibility = View.GONE
                            wishlistAdapter.setHomeWishlist(wishlist.data)
                            binding.rvWishlistHome.visibility = View.VISIBLE

                            //set total balance
                            val total = wishlist.data?.sumOf { it.price }
                            val wishlistBought =
                                wishlist.data?.filter { it.bought }?.map { it.price }
                            binding.tvTotalNeeded.text = total.formatCurrencyRupiah()
                            binding.tvTotalDeposit.text =
                                wishlistBought?.sum().formatCurrencyRupiah()
                        } else {
                            binding.loadingListWishlist.visibility = View.GONE
                            binding.bgEmpty.visibility = View.VISIBLE
                            binding.rvWishlistHome.visibility = View.GONE
                        }
                    }
                    is Resource.Error -> {}
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}