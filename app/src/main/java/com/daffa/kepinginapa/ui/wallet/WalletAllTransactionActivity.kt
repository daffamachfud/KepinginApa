package com.daffa.kepinginapa.ui.wallet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.daffa.core.ui.TransactionWishAdapter
import com.daffa.kepinginapa.R
import com.daffa.kepinginapa.databinding.ActivityWalletAllTransactionBinding
import com.daffa.kepinginapa.databinding.ActivityWalletBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WalletAllTransactionActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWalletAllTransactionBinding
    private val viewModel: WalletViewModel by viewModels()
    private val transactionAdapter = TransactionWishAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWalletAllTransactionBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        loadListTransaction()

        binding.btnBack.setOnClickListener {
            finish()
        }
    }

    private fun loadListTransaction() {
        viewModel.listTransaction.observe(this) { dataWish ->
            if (dataWish != null) {
                if (dataWish.data != null) {
                    val list = dataWish.data?.filter { it.bought }
                    if (list?.isNotEmpty() == true) {
                        transactionAdapter.setWishlist(list)
                        binding.rvListTransactionWalletAll.visibility = View.VISIBLE
                        binding.tvListTransactionEmpty.visibility = View.GONE
                        with(binding.rvListTransactionWalletAll) {
                            adapter = transactionAdapter
                            layoutManager = LinearLayoutManager(context)
                            setHasFixedSize(true)
                        }

                    } else {
                        binding.rvListTransactionWalletAll.visibility = View.GONE
                        binding.tvListTransactionEmpty.visibility = View.VISIBLE
                    }
                } else {
                    binding.rvListTransactionWalletAll.visibility = View.GONE
                    binding.tvListTransactionEmpty.visibility = View.VISIBLE
                }
            }
        }
    }
}