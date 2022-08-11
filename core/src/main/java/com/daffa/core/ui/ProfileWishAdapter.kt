package com.daffa.core.ui

import android.annotation.SuppressLint
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.daffa.core.databinding.ProfileWishlistAdapterBinding
import com.daffa.core.domain.model.Wishlist
import com.daffa.core.utils.Utils
import dagger.hilt.android.AndroidEntryPoint

class ProfileWishAdapter : RecyclerView.Adapter<ProfileWishAdapter.WishViewHolder>() {
    private var listProfileWishlist = ArrayList<Wishlist>()
    var onItemClick: ((Wishlist) -> Unit)? = null

    @SuppressLint("NotifyDataSetChanged")
    fun setProfileWishList(wishlists: List<Wishlist>?) {
        if (wishlists == null) return
        this.listProfileWishlist.clear()
        this.listProfileWishlist.addAll(wishlists)

        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): WishViewHolder {
        val profileWishlistAdapter =
            ProfileWishlistAdapterBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return WishViewHolder(profileWishlistAdapter)
    }

    override fun onBindViewHolder(holder: WishViewHolder, position: Int) {
        val wishlist = listProfileWishlist[position]
        holder.bind(wishlist)
    }

    override fun getItemCount(): Int = listProfileWishlist.size

    inner class WishViewHolder(private val binding: ProfileWishlistAdapterBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(wishlist: Wishlist) {
            with(binding) {
                val uriPathHelper = Utils.UriPathHelper()
                val filePath =
                    uriPathHelper.getPath(binding.root.context, Uri.parse(wishlist.imagePath))
                imgHomeWishlist.setImageURI(Uri.parse(filePath))

            }
        }

        init {
            binding.root.setOnClickListener {
                onItemClick?.invoke(listProfileWishlist[adapterPosition])
            }
        }
    }
}