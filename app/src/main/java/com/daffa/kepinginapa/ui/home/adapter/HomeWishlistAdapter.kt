package com.daffa.kepinginapa.ui.home.adapter

import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.daffa.kepinginapa.R
import com.daffa.kepinginapa.data.local.entity.WishlistEntity
import com.daffa.kepinginapa.databinding.HomeWishlistAdapterBinding
import com.daffa.kepinginapa.utils.Utils
import com.daffa.kepinginapa.utils.Utils.formatCurrencyRupiah
import java.io.File

class HomeWishlistAdapter : RecyclerView.Adapter<HomeWishlistAdapter.WishViewHolder>() {
    private var listHomeWishlist = ArrayList<WishlistEntity>()

    fun setHomeWishlist(wishlists: List<WishlistEntity>) {
        this.listHomeWishlist.clear()
        this.listHomeWishlist.addAll(wishlists)
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
        val wishlist = listHomeWishlist[position]
        holder.bind(wishlist)
    }

    override fun getItemCount(): Int = listHomeWishlist.size

    class WishViewHolder(private val binding: HomeWishlistAdapterBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(wishlist: WishlistEntity) {
            with(binding) {
                imgHomeWishlist.setImageURI(Uri.parse(wishlist.imagePath))
                titleHomeWishlist.text = wishlist.title

                categoryHomeWishlist.text = wishlist.category
//                categoryHomeWishlist.setCompoundDrawablesWithIntrinsicBounds(
//                    Utils.getCategoryIcon(
//                        wishlist.title
//                    ), 0, 0, 0
//                )

                priceHomeWishlist.text = wishlist.price.formatCurrencyRupiah()
                descHomeWishlist.text = wishlist.note
            }
        }
    }
}