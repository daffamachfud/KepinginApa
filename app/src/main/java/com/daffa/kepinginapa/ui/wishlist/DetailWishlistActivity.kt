package com.daffa.kepinginapa.ui.wishlist

import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider
import com.daffa.kepinginapa.data.local.entity.WishlistEntity
import com.daffa.kepinginapa.databinding.ActivityDetailWishlistBinding
import com.daffa.kepinginapa.utils.DialogLoading
import com.daffa.kepinginapa.utils.Utils
import com.daffa.kepinginapa.utils.Utils.formatCurrencyRupiah
import com.daffa.kepinginapa.vo.Resource
import com.daffa.kepinginapa.vo.Status
import com.daffa.kepinginapa.vo.ViewModelFactory

class DetailWishlistActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_WISH = "extra_wish"
    }

    private lateinit var binding: ActivityDetailWishlistBinding
    private lateinit var viewModel: DetailWishViewModel
    private lateinit var dataWish: WishlistEntity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailWishlistBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val factory = ViewModelFactory.getInstance(this)
        viewModel = ViewModelProvider(this, factory)[DetailWishViewModel::class.java]
        val extras = intent.extras

        if (extras != null) {
            val wishId = extras.getInt(EXTRA_WISH)
            if (wishId != 0) {
                //load data detail
                val progress = DialogLoading(this@DetailWishlistActivity)
                progress.show()
                viewModel.setSelectedWish(wishId)
                setupDetail(viewModel.detailWish, progress)
            }
        }

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
    }

    private fun setupDetail(
        detailWish: LiveData<Resource<WishlistEntity>>,
        progress: DialogLoading
    ) {
        detailWish.observe(this) {
            if (it.data != null) {
                when (it.status) {
                    Status.LOADING -> progress.show()
                    Status.SUCCESS -> {
                        progress.dismiss()
                        dataWish = it.data
                        val uriPathHelper = Utils.UriPathHelper()
                        val filePath = uriPathHelper.getPath(this, Uri.parse(it.data.imagePath))
                        binding.imgDetail.setImageURI(Uri.parse(filePath))

                        binding.tvTitle.text = it.data.title
                        binding.tvDesc.text = it.data.note
                        binding.tvCategory.text = it.data.category
                        binding.tvLink.text = it.data.link

                        binding.tvPrice.text = it.data.price.formatCurrencyRupiah()
                    }
                    Status.ERROR -> {
                        progress.dismiss()
                        Toast.makeText(applicationContext, "Terjadi kesalahan", Toast.LENGTH_SHORT)
                            .show()
                    }
                }
            }
        }
    }
}