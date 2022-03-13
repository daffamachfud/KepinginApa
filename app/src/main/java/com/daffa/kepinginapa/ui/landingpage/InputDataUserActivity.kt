package com.daffa.kepinginapa.ui.landingpage

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.lifecycle.ViewModelProvider
import com.daffa.kepinginapa.databinding.ActivityInputDataUserBinding
import com.daffa.kepinginapa.ui.home.MainActivity
import com.daffa.kepinginapa.utils.DialogLoading
import com.daffa.kepinginapa.vo.ViewModelFactory

class InputDataUserActivity : AppCompatActivity() {
    private lateinit var binding: ActivityInputDataUserBinding
    private val getContent =
        registerForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
            setProfilePicture(uri)
        }
    private lateinit var profileImgPath :String
    private lateinit var viewModel: InputDataUserViewModel

    private fun setProfilePicture(uri: Uri?) {
        profileImgPath = uri.toString()
        binding.imgProfileLanding.setImageURI(uri)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInputDataUserBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val factory = ViewModelFactory.getInstance(this)
        viewModel = ViewModelProvider(this,factory)[InputDataUserViewModel::class.java]

        binding.tvBack.setOnClickListener {
            finish()
        }

        binding.imgProfileLanding.setOnClickListener {
            getContent.launch("image/*")
        }

        binding.btnStartInputLanding.setOnClickListener {
            inputUser()
        }
        requestPermission()

    }
    private fun haveStoragePermission() =
        ActivityCompat.checkSelfPermission(this, Manifest
            .permission.READ_EXTERNAL_STORAGE)== PackageManager.PERMISSION_GRANTED

    private fun requestPermission() {
        if (!haveStoragePermission()) {
            val permissions = arrayOf(
                Manifest.permission.READ_EXTERNAL_STORAGE
            )
            ActivityCompat.requestPermissions(this, permissions, 100)
        }
    }


    private fun inputUser() {
        val progress = DialogLoading(this@InputDataUserActivity)
        progress.show()
        viewModel.inputDataUser(profileImgPath,binding.etUsername.text.toString())
        progress.dismiss()
        finish()
        val intentMainActivity = Intent(this, MainActivity::class.java)
        startActivity(intentMainActivity)
    }


}