package com.daffa.kepinginapa.ui.wishlistmonth

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import com.daffa.kepinginapa.databinding.FragmentWishlistBinding
import com.daffa.kepinginapa.utils.Utils.formatCurrencyRupiah
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class WishlistFragment : Fragment() {

    private var _binding: FragmentWishlistBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentWishlistBinding.inflate(inflater, container, false)

        //bulan ini
        val date = LocalDateTime.now().format(
            DateTimeFormatter.ofPattern("MMM yyyy")
        )

        binding.tvDateWish.text = date
        binding.tvTotalNeeded.text = 0.0.formatCurrencyRupiah()

        binding.btnAddWish.setOnClickListener {
            val intent = Intent(requireActivity(),AddWishMonthActivity::class.java)
            startActivity(intent)
        }


        return binding.root


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}