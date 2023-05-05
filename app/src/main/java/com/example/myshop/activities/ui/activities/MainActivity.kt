package com.example.myshop.activities.ui.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

import com.example.myshop.R
import com.example.myshop.utils.Constans
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        setContentView(R.layout.activity_main)
        // ...
        // Initialize Firebase Auth

        val sharedPreferences =
            getSharedPreferences(Constans.MYSHOP_PREFERENCES, MODE_PRIVATE)
        val username = sharedPreferences.getString(Constans.LOGGED_IN_USERNAME, "")!!
        findViewById<TextView>(R.id.tv_mainActivity).text = "Hello $username"



    }
}