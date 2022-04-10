package com.daffa.kepinginapa.ui.profile

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.daffa.kepinginapa.data.local.entity.WishlistEntity
import com.daffa.kepinginapa.databinding.ProfileWishlistAdapterBinding
import com.daffa.kepinginapa.ui.wishlist.DetailWishlistActivity
import com.daffa.kepinginapa.utils.Utils

class ProfileWishAdapter : RecyclerView.Adapter<ProfileWishAdapter.WishViewHolder>() {
    private var listProfileWishlist = ArrayList<WishlistEntity>()

    @SuppressLint("NotifyDataSetChanged")
    fun setProfileWishList(wishlists: List<WishlistEntity>) {
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

    class WishViewHolder(private val binding: ProfileWishlistAdapterBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(wishlist: WishlistEntity) {
            with(binding) {
                val uriPathHelper = Utils.UriPathHelper()
                val filePath =
                    uriPathHelper.getPath(binding.root.context, Uri.parse(wishlist.imagePath))
                imgHomeWishlist.setImageURI(Uri.parse(filePath))
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