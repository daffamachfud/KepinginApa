package com.daffa.kepinginapa.ui.wishlistmonth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.daffa.kepinginapa.R
import com.daffa.kepinginapa.databinding.ActivityAddWishMonthBinding
import com.daffa.kepinginapa.databinding.ActivityWalletBinding

class AddWishMonthActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddWishMonthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddWishMonthBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnBack.setOnClickListener {
            finish()
        }


    }
}