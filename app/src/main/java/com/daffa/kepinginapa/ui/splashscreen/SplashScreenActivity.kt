package com.daffa.kepinginapa.ui.splashscreen

import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.daffa.kepinginapa.databinding.ActivitySplashScreenBinding
import com.daffa.kepinginapa.ui.home.MainActivity
import com.daffa.kepinginapa.ui.landingpage.LandingPageActivity
import com.daffa.kepinginapa.utils.AppPreference

@SuppressLint("CustomSplashScreen")
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


        val prefLandingPage = AppPreference(this)
        Handler(Looper.getMainLooper()).postDelayed({
            if (prefLandingPage.getLandingPage()) {
                prefLandingPage.setLandingPage(false)
                val intentLanding = Intent(this, LandingPageActivity::class.java)
                startActivity(intentLanding)
                finish()
            } else {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }, 3000)
    }
}