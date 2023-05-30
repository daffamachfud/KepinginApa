package com.daffa.kepinginapa.ui.wishlist

import android.net.Uri
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.daffa.core.domain.model.Wishlist
import com.daffa.kepinginapa.databinding.ActivityDetailWishlistBinding
import com.daffa.kepinginapa.utils.Utils
import com.daffa.kepinginapa.utils.Utils.formatCurrencyRupiah
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailWishlistActivity : AppCompatActivity(), WishSuccessCallback {

    private lateinit var binding: ActivityDetailWishlistBinding
    private val viewModel: DetailWishViewModel by viewModels()
    private lateinit var dataWish: Wishlist

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailWishlistBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val extras = intent.getParcelableExtra<Wishlist>(EXTRA_WISH)
        showDetailWishlist(extras)


        binding.btnDelete.setOnClickListener {
            val alert = AlertDialog.Builder(this)
            alert.setTitle("Apakah kamu yakin menghapus keinginan mu ini ?")

            alert.setPositiveButton("Ya") { _, _ ->
                viewModel.deleteWish(dataWish)
                finish()
            }
            alert.setNegativeButton("Nggak") { _, _ ->

            }
            alert.show()
        }

        binding.btnBuy.setOnClickListener {
            viewModel.updateBoughtWish(dataWish)
            WishlistSuccessDialogFragment(this).show(
                supportFragmentManager, ""
            )
        }

        binding.btnBack.setOnClickListener {
            finish()
        }
    }

    private fun showDetailWishlist(detail: Wishlist?) {
        detail?.let { dataWishlist ->
            dataWish = dataWishlist
            val uriPathHelper = Utils.UriPathHelper()
            val filePath = uriPathHelper.getPath(this, Uri.parse(dataWishlist.imagePath)) ?: ""
            if(filePath.isNotEmpty()){
                binding.imgDetail.setImageURI(Uri.parse(filePath))
            }

            binding.tvTitle.text = dataWishlist.title
            binding.tvDesc.text = dataWishlist.note
            binding.tvCategory.text = dataWishlist.category
            binding.tvLink.text = dataWishlist.link

            binding.tvPrice.text = dataWishlist.price.formatCurrencyRupiah()
        }
    }

    override fun successBought() {
        finish()
    }


    companion object {
        const val EXTRA_WISH = "extra_wish"
    }

}