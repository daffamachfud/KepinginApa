package com.daffa.kepinginapa.ui.landingpage

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager.PERMISSION_GRANTED
import android.net.Uri
import android.os.Bundle
import android.provider.Settings.ACTION_APPLICATION_DETAILS_SETTINGS
import android.util.Log
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.daffa.kepinginapa.databinding.ActivityInputDataUserBinding
import com.daffa.kepinginapa.ui.home.MainActivity
import com.daffa.kepinginapa.utils.DialogLoading
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class InputDataUserActivity : AppCompatActivity() {

    private val viewModel: InputDataUserViewModel by viewModels()

    companion object {
        const val REQUEST_PERMISSION_STORAGE = 100
    }

    private lateinit var binding: ActivityInputDataUserBinding
    private val getContent =
        registerForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
            setProfilePicture(uri)
        }
    private var profileImgPath: String = ""

    private fun setProfilePicture(uri: Uri?) {
        profileImgPath = uri.toString()
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
            if (hasStoragePermission()) {
                getContent.launch("image/*")
            } else {
                requestStoragePermission()
            }
        }

        binding.btnStartInputLanding.setOnClickListener {
            inputUser()
        }

    }

    private fun hasStoragePermission() = ContextCompat.checkSelfPermission(
        this,
        Manifest.permission.READ_EXTERNAL_STORAGE
    ) == PERMISSION_GRANTED

    private fun requestStoragePermission() {
        if (!hasStoragePermission()) {
            val permissions = arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE)
            ActivityCompat.requestPermissions(this, permissions, REQUEST_PERMISSION_STORAGE)
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            REQUEST_PERMISSION_STORAGE -> {
                if (grantResults.isNotEmpty() && grantResults[0] == PERMISSION_GRANTED) {
                    getContent.launch("image/*")
                } else {
                    val showRational =
                        ActivityCompat.shouldShowRequestPermissionRationale(
                            this,
                            Manifest.permission.READ_EXTERNAL_STORAGE
                        )

                    if (showRational) {
                        Log.e("Permission", "Storage permission denied")
                    } else {
                        Intent(
                            ACTION_APPLICATION_DETAILS_SETTINGS,
                            Uri.parse("package:${this.packageName}")
                        ).apply {
                            addCategory(Intent.CATEGORY_DEFAULT)
                            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                        }.also { intent ->
                            startActivity(intent)
                        }
                    }
                }
            }
        }
    }


    private fun inputUser() {
        if (profileImgPath == "" || binding.etUsername.text.isEmpty()) {
            Toast.makeText(
                this,
                "Silahkan lengkapi data diatas terlebih dahulu",
                Toast.LENGTH_SHORT
            ).show()
        } else {
            val progress = DialogLoading(this@InputDataUserActivity)
            progress.show()
            viewModel.inputDataUser(profileImgPath, binding.etUsername.text.toString())
            progress.dismiss()
            finish()
            val intentMainActivity = Intent(this, MainActivity::class.java)
            startActivity(intentMainActivity)
        }
    }


}