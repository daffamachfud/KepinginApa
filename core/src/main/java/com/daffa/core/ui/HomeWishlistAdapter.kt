package com.daffa.core.ui

import android.annotation.SuppressLint
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.daffa.core.databinding.HomeWishlistAdapterBinding
import com.daffa.core.domain.model.Wishlist
import com.daffa.core.utils.Utils
import com.daffa.core.utils.Utils.formatCurrencyRupiah

class HomeWishlistAdapter : RecyclerView.Adapter<HomeWishlistAdapter.WishViewHolder>() {
    private var listHomeWishlist = ArrayList<Wishlist>()
    var onItemClick: ((Wishlist) -> Unit)? = null

    @SuppressLint("NotifyDataSetChanged")
    fun setHomeWishlist(wishlists: List<Wishlist>?) {
        if (wishlists == null) return
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
        val wishlist = listHomeWishlist[position]
        holder.bind(wishlist)
    }

    override fun getItemCount(): Int = listHomeWishlist.size

    inner class WishViewHolder(private val binding: HomeWishlistAdapterBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(wishlist: Wishlist) {
            with(binding) {
                val uriPathHelper = Utils.UriPathHelper()
                val filePath =
                    uriPathHelper.getPath(binding.root.context, Uri.parse(wishlist.imagePath))
                if (filePath != null) {
                    imgHomeWishlist.load(Uri.parse(filePath)) {
                        crossfade(true)
                        crossfade(500)
                    }
                }
                titleHomeWishlist.text = wishlist.title
                priceHomeWishlist.text = wishlist.price.formatCurrencyRupiah()
            }
        }

        init {
            binding.root.setOnClickListener {
                onItemClick?.invoke(listHomeWishlist[adapterPosition])
            }
        }
    }
}