package com.daffa.kepinginapa.ui.wishlist

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.core.content.ContextCompat
import androidx.fragment.app.DialogFragment
import com.daffa.kepinginapa.R
import com.daffa.kepinginapa.databinding.FragmentWishlistSuccessDialogBinding
import com.daffa.kepinginapa.utils.Utils
import java.util.*
import kotlin.concurrent.schedule


class WishlistSuccessDialogFragment(
    private val callback : WishSuccessCallback
) : DialogFragment() {
    private lateinit var binding: FragmentWishlistSuccessDialogBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentWishlistSuccessDialogBinding.inflate(layoutInflater, container, false)
        binding.btnClose.setOnClickListener {
            dismiss()
            callback.successBought()
        }
        binding.viewConfetti.start(Utils.Presets.explode())
        binding.viewConfetti.start(Utils.Presets.parade())
        binding.viewConfetti.start(Utils.Presets.festive())
        // Use
        Timer().schedule(1000) {
            binding.viewConfetti.start(Utils.Presets.rain())
        }
        return binding.root
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        isCancelable = false
        val dialog = super.onCreateDialog(savedInstanceState)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.window?.setBackgroundDrawable(
            ContextCompat.getDrawable(
                requireContext(),
                R.drawable.dialog_rd_bg_white
            )
        )

        dialog.setCanceledOnTouchOutside(false)
        dialog.setCancelable(false)
        return dialog
    }

    override fun onStart() {
        super.onStart()
        dialog?.let {
            it.window?.setLayout(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
        }
    }

    override fun onStop() {
        super.onStop()
        binding.viewConfetti.stopGracefully()
    }

}