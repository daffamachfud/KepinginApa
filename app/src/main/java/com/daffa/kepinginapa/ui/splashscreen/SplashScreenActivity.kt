package com.daffa.kepinginapa.ui.splashscreen

import android.content.Intent
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.daffa.kepinginapa.databinding.ActivitySplashScreenBinding
import com.daffa.kepinginapa.ui.home.MainActivity


class SplashScreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //set version code
        try {
            val version: PackageInfo =
                packageManager.getPackageInfo(packageName, 0)
            binding.tvVersionApp.text = version.versionName
        } catch (e: PackageManager.NameNotFoundException) {
            e.printStackTrace()
        }

        // we used the postDelayed(Runnable, time) method
        // to send a message with a delayed time.
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 3000)
    }
}