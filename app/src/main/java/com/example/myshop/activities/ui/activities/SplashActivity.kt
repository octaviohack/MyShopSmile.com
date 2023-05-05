package com.example.myshop.activities.ui.activities

import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import com.example.myshop.R
import com.google.firebase.auth.FirebaseAuth

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // Check if the user is already logged in
        val currentUser = FirebaseAuth.getInstance().currentUser
        if (currentUser != null) {
            startActivity(Intent(this, DashboarActivity::class.java))
            finish()
            return
        }


        @Suppress("DEPRECATION")
        // This is to hide the status bar and make the splash screen full screen
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.setDecorFitsSystemWindows(false)

        } else {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }
        @Suppress("DEPRECATION")
        // This is to delay the splash screen for 2.3 seconds
        Handler().postDelayed({
            if (currentUser != null) { // If the user is logged in then send him to DashboardActivity
                startActivity(Intent(this, DashboarActivity::class.java))
                finish()
                return@postDelayed

            }else{ // If the user is not logged in then send him to LoginActivity
                startActivity(Intent(this, LoginActivity::class.java))
                finish()
                return@postDelayed
            }

            finish() // Call this when your activity is done and should be closed.
        }, 2300)


    }

}