package com.example.myshop.activities.ui.activities

import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.TextView
import com.example.myshop.R
import com.example.myshop.utils.Constans
import com.google.firebase.auth.FirebaseAuth

class UserProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_profile)
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

        val sharedPreferences =
            getSharedPreferences(Constans.MYSHOP_PREFERENCES, MODE_PRIVATE)

        val username = sharedPreferences.getString(Constans.LOGGED_IN_USERNAME, "")!!
        val email = sharedPreferences.getString(Constans.LOGGED_IN_EMAIL, "")!!


        findViewById<TextView>(R.id.profil_name).text = "$username"
        findViewById<TextView>(R.id.profile_email_address).text = "$email"



        findViewById<TextView>(R.id.btn_logout).setOnClickListener(this::onClick)





        findViewById<TextView>(R.id.btn_save).setOnClickListener {
            // Launch the register screen when the user clicks on the text
            val intent = Intent(this@UserProfileActivity, DashboarActivity::class.java)
            startActivity(intent)
        }

    }


     fun onClick(v: View?) {
        if (v != null) {
            when (v.id) {
                R.id.btn_logout -> {
                    FirebaseAuth.getInstance().signOut()
                    val intent = Intent(this@UserProfileActivity, LoginActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(intent)
                    finish()

                }




            }
        }
    }




}