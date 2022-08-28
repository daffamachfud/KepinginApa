package com.daffa.kepinginapa.ui.wallet

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View.*
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.NumberPicker
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.daffa.core.domain.model.Wallet
import com.daffa.core.ui.TransactionWishAdapter
import com.daffa.kepinginapa.R
import com.daffa.kepinginapa.databinding.ActivityWalletBinding
import com.daffa.kepinginapa.utils.Utils
import com.daffa.kepinginapa.utils.Utils.format1
import com.daffa.kepinginapa.utils.Utils.formatCurrencyRupiah
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import dagger.hilt.android.AndroidEntryPoint
import java.time.LocalDate

@AndroidEntryPoint
class WalletActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWalletBinding
    private val wishlistAdapter = TransactionWishAdapter()
    private val viewModel: WalletViewModel by viewModels()
    private var selectedMonth: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWalletBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        if (Build.VERSION.SDK_INT in 21..29) {
            window.statusBarColor = Color.TRANSPARENT
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.decorView.systemUiVisibility =
                SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or SYSTEM_UI_FLAG_LAYOUT_STABLE

        } else if (Build.VERSION.SDK_INT >= 30) {
            window.statusBarColor = Color.TRANSPARENT
            // Making status bar overlaps with the activity
            WindowCompat.setDecorFitsSystemWindows(window, false)
        }

        viewModel.wallet.observe(this) { dataWallet ->
            if (dataWallet != null) {
                if (dataWallet.data != null) {
                    binding.tvBalance.text = dataWallet.data?.balance.formatCurrencyRupiah()
                    binding.tvDateCard.text = dataWallet.data?.date
                }
            }
        }

        loadDataWishlist(selectedMonth)

        binding.tvBalance.setOnClickListener {
            val dialog = BottomSheetDialog(this)

            // on below line we are inflating a layout file which we have created.
            val bottomSheetView = layoutInflater.inflate(R.layout.input_balance_dialog, null)
            val etInputBalance = bottomSheetView.findViewById<EditText>(R.id.et_input_balance)
            val btnSubmit = bottomSheetView.findViewById<Button>(R.id.btn_input_balance)

            etInputBalance.addTextChangedListener(Utils.MoneyTextWatcher(etInputBalance))

            dialog.setContentView(bottomSheetView)
            dialog.show()

            btnSubmit.setOnClickListener {
                val balance =
                    Utils.MoneyTextWatcher.parseCurrencyValue(etInputBalance.text.toString())
                        .toDouble()
                val date = LocalDate.now()
                viewModel.inputWallet(
                    Wallet(
                        0, date.format1(), balance
                    )
                )
                dialog.dismiss()
            }
        }

        binding.cvDateMonth.setOnClickListener {
            val builder = MaterialAlertDialogBuilder(this)
                .create()
            val monthView =
                layoutInflater.inflate(com.daffa.core.R.layout.month_picker_dialog, null)
            builder.setView(monthView)
            val listMonth = monthView.findViewById<NumberPicker>(com.daffa.core.R.id.list_month)
            val tvMonth = monthView.findViewById<TextView>(com.daffa.core.R.id.tv_month_name)
            val btnOk = monthView.findViewById<Button>(com.daffa.core.R.id.btn_ok)

            val values = Utils.getMonthList()
            listMonth.minValue = 0
            listMonth.maxValue = values.size - 1
            listMonth.displayedValues = values.toTypedArray()
            listMonth.wrapSelectorWheel = true
            selectedMonth = values[0]
            tvMonth.text = selectedMonth

            listMonth.setOnValueChangedListener { _, _, newVal ->
                selectedMonth = values[newVal]
                tvMonth.text = selectedMonth
            }

            btnOk.setOnClickListener {
                builder.dismiss()
                binding.tvMonth.text = selectedMonth
                loadDataWishlist(selectedMonth)
            }

            builder.setCanceledOnTouchOutside(false)
            builder.show()
        }


    }

    private fun loadDataWishlist(selectedMonth: String) {
        viewModel.wishlist.observe(this) { dataWish ->
            if (dataWish != null) {
                if (dataWish.data != null) {
                    val list = dataWish.data?.filter { it.bought }
                    if (list?.isNotEmpty() == true) {
                        wishlistAdapter.setWishlist(list)
                        binding.rvListTransaction.visibility = VISIBLE
                        binding.bgEmpty.visibility = GONE
                        val count = if (list.isNotEmpty()) list.count() else 0
                        binding.tvListWishTitle.text = resources.getString(
                            R.string.list_kepingin_main,
                            "",
                            count.toString()
                        )
                        with(binding.rvListTransaction) {
                            adapter = wishlistAdapter
                            layoutManager = LinearLayoutManager(context)
                            setHasFixedSize(true)
                        }

                        //set deposit
                        val deposit = list.sumOf { it.price }
                        binding.tvDeposit.text = deposit.formatCurrencyRupiah()
                    } else {
                        binding.tvListWishTitle.text = resources.getString(
                            R.string.list_kepingin_main,
                            "",
                            "0"
                        )
                        binding.rvListTransaction.visibility = GONE
                        binding.bgEmpty.visibility = VISIBLE
                    }
                } else {
                    binding.tvListWishTitle.text = resources.getString(
                        R.string.list_kepingin_main,
                        "",
                        "0"
                    )
                    binding.rvListTransaction.visibility = GONE
                    binding.bgEmpty.visibility = VISIBLE
                }
            }
        }
    }
}