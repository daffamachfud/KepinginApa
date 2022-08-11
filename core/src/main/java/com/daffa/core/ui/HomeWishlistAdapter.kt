package com.daffa.core.ui

import android.annotation.SuppressLint
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.daffa.core.databinding.HomeWishlistAdapterBinding
import com.daffa.core.domain.model.Wishlist
import com.daffa.core.utils.Utils
import com.daffa.core.utils.Utils.formatCurrencyRupiah
import com.google.gson.Gson

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
        println("onresponse masok")
        Log.d("onresponse ", Gson().toJson(listHomeWishlist))
        val wishlist = listHomeWishlist[position]
        holder.bind(wishlist)
    }

    override fun getItemCount(): Int = listHomeWishlist.size

    inner class WishViewHolder(private val binding: HomeWishlistAdapterBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(wishlist: Wishlist) {
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

            }
        }

        init {
            binding.root.setOnClickListener {
                onItemClick?.invoke(listHomeWishlist[adapterPosition])
            }
        }
    }
}