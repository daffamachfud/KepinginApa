package com.daffa.kepinginapa.ui.home.adapter

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.daffa.kepinginapa.data.local.entity.WishlistEntity
import com.daffa.kepinginapa.databinding.HomeWishlistAdapterBinding
import com.daffa.kepinginapa.ui.wishlist.DetailWishlistActivity
import com.daffa.kepinginapa.utils.Utils
import com.daffa.kepinginapa.utils.Utils.formatCurrencyRupiah
import com.google.gson.Gson

class HomeWishlistAdapter : RecyclerView.Adapter<HomeWishlistAdapter.WishViewHolder>() {
    private var listHomeWishlist = ArrayList<WishlistEntity>()

    @SuppressLint("NotifyDataSetChanged")
    fun setHomeWishlist(wishlists: List<WishlistEntity>) {
        this.listHomeWishlist.clear()
        this.listHomeWishlist.addAll(wishlists)

        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): WishViewHolder {
        val homeWishlistAdapterBinding =
            HomeWishlistAdapterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return WishViewHolder(homeWishlistAdapterBinding)
    }

    override fun onBindViewHolder(holder: WishViewHolder, position: Int) {
        println("onresponse masok")
        Log.d("onresponse ", Gson().toJson(listHomeWishlist))
        val wishlist = listHomeWishlist[position]
        holder.bind(wishlist)
    }

    override fun getItemCount(): Int = listHomeWishlist.size

    class WishViewHolder(private val binding: HomeWishlistAdapterBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(wishlist: WishlistEntity) {
            println("onresponse masok 1")
            with(binding) {
                val uriPathHelper = Utils.UriPathHelper()
                val filePath =
                    uriPathHelper.getPath(binding.root.context, Uri.parse(wishlist.imagePath))
                imgHomeWishlist.setImageURI(Uri.parse(filePath))
                titleHomeWishlist.text = wishlist.title

                categoryHomeWishlist.text = wishlist.category
//                categoryHomeWishlist.setCompoundDrawablesWithIntrinsicBounds(
//                    Utils.getCategoryIcon(
//                        wishlist.title
//                    ), 0, 0, 0
//                )

                priceHomeWishlist.text = wishlist.price.formatCurrencyRupiah()
                descHomeWishlist.text = wishlist.note

                binding.layoutWishAdapter.setOnClickListener {
                    val intent =
                        Intent(binding.root.context, DetailWishlistActivity::class.java).apply {
                            putExtra(DetailWishlistActivity.EXTRA_WISH, wishlist.id)
                        }
                    binding.root.context.startActivity(intent)
                }
            }
        }
    }
}