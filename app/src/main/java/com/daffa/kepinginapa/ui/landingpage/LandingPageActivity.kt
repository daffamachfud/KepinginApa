package com.daffa.kepinginapa.ui.landingpage

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.daffa.kepinginapa.databinding.ActivityLandingPageBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LandingPageActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLandingPageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLandingPageBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnStartLanding.setOnClickListener {
            val intentInput = Intent(this, InputDataUserActivity::class.java)
            startActivity(intentInput)
            finish()
        }


    }
}