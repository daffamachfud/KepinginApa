package com.daffa.core.ui

import android.annotation.SuppressLint
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.daffa.core.databinding.WishlistMonthChooseAdapterBinding
import com.daffa.core.domain.model.Wishlist
import com.daffa.core.utils.Utils
import com.daffa.core.utils.Utils.formatCurrencyRupiah

class WishlistMonthChooseAdapter : RecyclerView.Adapter<WishlistMonthChooseAdapter.WishViewHolder>() {
    private var listWish = ArrayList<Wishlist>()
    var onItemClick: ((Wishlist) -> Unit)? = null

    @SuppressLint("NotifyDataSetChanged")
    fun setWishlist(wishlists: List<Wishlist>?) {
        if (wishlists == null) return
        this.listWish.clear()
        this.listWish.addAll(wishlists)

        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): WishViewHolder {
        val wishlistMonthChooseBinding =
            WishlistMonthChooseAdapterBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return WishViewHolder(wishlistMonthChooseBinding)
    }

    override fun onBindViewHolder(holder: WishViewHolder, position: Int) {
        val wishlist = listWish[position]
        holder.bind(wishlist)
    }

    override fun getItemCount(): Int = listWish.size

    inner class WishViewHolder(private val binding: WishlistMonthChooseAdapterBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(wishlist: Wishlist) {
            with(binding) {
                val uriPathHelper = Utils.UriPathHelper()
                val filePath =
                    uriPathHelper.getPath(binding.root.context, Uri.parse(wishlist.imagePath))
                if (filePath != null) {
                    imgWishTransaction.setImageURI(Uri.parse(filePath))
                }
                tvWishlistName.text = wishlist.title
                tvWishlistPrice.text = wishlist.price.formatCurrencyRupiah()
            }
        }

        init {
            binding.root.setOnClickListener {
                onItemClick?.invoke(listWish[adapterPosition])
            }
        }
    }
}