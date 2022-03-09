package com.daffa.kepinginapa.ui.landingpage

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.daffa.kepinginapa.databinding.ActivityInputDataUserBinding

class InputDataUserActivity : AppCompatActivity() {
    private lateinit var binding: ActivityInputDataUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInputDataUserBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.tvBack.setOnClickListener {
            finish()
        }
    }
}