package com.daffa.kepinginapa.ui.wallet

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.daffa.core.data.Resource
import com.daffa.core.domain.model.Wallet
import com.daffa.core.ui.TransactionWishAdapter
import com.daffa.kepinginapa.MainActivity
import com.daffa.kepinginapa.R
import com.daffa.kepinginapa.databinding.FragmentHomeBinding
import com.daffa.kepinginapa.databinding.FragmentWalletBinding
import com.daffa.kepinginapa.utils.Utils
import com.daffa.kepinginapa.utils.Utils.format1
import com.daffa.kepinginapa.utils.Utils.formatCurrencyRupiah
import com.google.android.material.bottomsheet.BottomSheetDialog
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.observeOn
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@AndroidEntryPoint
class WalletFragment : Fragment() {

    private var _binding: FragmentWalletBinding? = null
    private val viewModel: WalletViewModel by viewModels()
    private val transactionAdapter = TransactionWishAdapter()
    private val binding get() = _binding!!

    @SuppressLint("InflateParams")
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWalletBinding.inflate(inflater, container, false)

        //data wallet
        viewModel.wallet.observe(requireActivity()) { dataWallet ->
            if (dataWallet != null) {
                when (dataWallet) {
                    is Resource.Loading -> {}
                    is Resource.Success -> {
                        Log.i("Onoh","onresponse balance ${dataWallet.data?.balance}")
                        _binding?.tvBalanceWallet?.text = dataWallet.data?.balance.formatCurrencyRupiah()
                        binding.tvDateCardWallet.text = dataWallet.data?.date
                    }
                    is Resource.Error -> {}
                }
            }
        }

        viewModel.getDeposit.observe(requireActivity()) {deposit ->
            if (deposit != null){
                when (deposit) {
                    is Resource.Loading -> {}
                    is Resource.Success -> {
                        try {
                            if(deposit.data == 0.0 || deposit.data == null){
                                binding.tvDepositWallet.text = 0.0.formatCurrencyRupiah()
                            }else{
                                binding.tvDepositWallet.text = deposit.data.formatCurrencyRupiah()
                            }
                        }catch (e:Exception){
                            binding.tvDepositWallet.text = 0.0.formatCurrencyRupiah()
                        }

                    }
                    is Resource.Error -> {}
                }
            }else{
                binding.tvDepositWallet.text = 0.0.formatCurrencyRupiah()
            }
        }

        //load transaction
        loadListTransaction()


        binding.btnEditBalanceWallet.setOnClickListener {
            val dialog = BottomSheetDialog(requireContext())
            val view = layoutInflater.inflate(R.layout.layout_bottom_input_balance_wallet,null)
            val etInputPrice = view.findViewById<EditText>(R.id.et_input_balance)
            val btnSave = view.findViewById<Button>(R.id.btn_save_input_balance)

            etInputPrice.addTextChangedListener(Utils.MoneyTextWatcher(etInputPrice))

            btnSave.setOnClickListener{
                val balance =
                    Utils.MoneyTextWatcher.parseCurrencyValue(etInputPrice.text.toString())
                        .toDouble()

                if(balance > 0.0){
                    val date = LocalDate.now()
                    viewModel.inputWallet(
                        Wallet(
                            0, date.format1(), balance
                        )
                    )
                    dialog.dismiss()
                }else{
                    Toast.makeText(requireContext(),"Input kosong !",Toast.LENGTH_SHORT).show()
                }
            }

            dialog.setCancelable(true)
            dialog.setContentView(view)
            dialog.show()
        }

        binding.btnShowAll.setOnClickListener {
            val intentMainActivity = Intent(requireActivity(), WalletAllTransactionActivity::class.java)
            startActivity(intentMainActivity)
        }


        return binding.root
    }

    private fun loadListTransaction() {
        viewModel.listTransaction.observe(requireActivity()) { dataWish ->
            if (dataWish != null) {
                if (dataWish.data != null) {
                    val list = dataWish.data?.filter { it.bought }
                    if (list?.isNotEmpty() == true) {
                        transactionAdapter.setWishlist(list)
                        binding.rvListTransactionWallet.visibility = View.VISIBLE
                        binding.tvListTransactionEmpty.visibility = View.GONE
                        with(binding.rvListTransactionWallet) {
                            adapter = transactionAdapter
                            layoutManager = LinearLayoutManager(context)
                            setHasFixedSize(true)
                        }

                    } else {
                        binding.rvListTransactionWallet.visibility = View.GONE
                        binding.tvListTransactionEmpty.visibility = View.VISIBLE
                    }
                } else {
                    binding.rvListTransactionWallet.visibility = View.GONE
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}