package com.daffa.kepinginapa.ui.wishlist

import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.daffa.core.domain.model.Wishlist
import com.daffa.kepinginapa.R
import com.daffa.kepinginapa.databinding.ActivityInputWishlistBinding
import com.daffa.kepinginapa.utils.DialogLoading
import com.daffa.kepinginapa.utils.Utils.MoneyTextWatcher
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class InputWishlistActivity : AppCompatActivity() {
    private lateinit var binding: ActivityInputWishlistBinding
    private val getContent =
        registerForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
            setImageWish(uri)
        }

    private fun setImageWish(uri: Uri?) {
        imgWishlist = uri.toString()
        binding.imgViewWish.setImageURI(uri)
    }

    private lateinit var imgWishlist: String
    private lateinit var selectedCategory: String
    private val viewModel: WishListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInputWishlistBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.imgViewWish.setOnClickListener {
            getContent.launch("image/*")
        }

        //set currency edit text
        binding.priceWish.addTextChangedListener(MoneyTextWatcher(binding.priceWish))

        // access the items of the list
        val category = resources.getStringArray(R.array.category_array)

        // access the spinner
        val spinner = findViewById<Spinner>(R.id.categoryDropdown)
        if (spinner != null) {
            val adapter = ArrayAdapter(
                this,
                com.daffa.core.R.layout.category_list, category
            )
            spinner.adapter = adapter

            spinner.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View, position: Int, id: Long
                ) {
                    selectedCategory = category[position]
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // write code to perform some action
                }
            }
        }

        binding.btnBack.setOnClickListener {
            finish()
        }

        binding.btnSubmitWish.setOnClickListener {
            val progress = DialogLoading(this)
            progress.show()
            viewModel.inputWish(
                Wishlist(
                    0,
                    binding.titleWish.text.toString(),
                    selectedCategory,
                    binding.descWish.text.toString(),
                    MoneyTextWatcher.parseCurrencyValue(binding.priceWish.text.toString())
                        .toDouble(),
                    binding.linkWish.text.toString(),
                    imgWishlist,
                    bought = false,
                    deleted = false
                )
            )
            progress.dismiss()
            finish()
        }
    }

}