package com.daffa.kepinginapa.ui.landingpage

import android.net.Uri
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.daffa.kepinginapa.databinding.ActivityInputDataUserBinding

class InputDataUserActivity : AppCompatActivity() {
    private lateinit var binding: ActivityInputDataUserBinding
    private val getContent =
        registerForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
            setProfilePicture(uri)
        }

    private fun setProfilePicture(uri: Uri?) {
        binding.imgProfileLanding.setImageURI(uri)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInputDataUserBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.tvBack.setOnClickListener {
            finish()
        }

        binding.imgProfileLanding.setOnClickListener {
            getContent.launch("image/*")
        }
    }


}