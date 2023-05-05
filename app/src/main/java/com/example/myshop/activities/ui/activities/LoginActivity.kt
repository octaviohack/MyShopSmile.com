package com.example.myshop.activities.ui.activities

import android.content.ContentValues.TAG
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.widget.TextView
import android.widget.Toast
import com.example.myshop.Firestore.FirestoreClass
import com.example.myshop.R
import com.example.myshop.models.User
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : BaseActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)



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

        // Click event for login button
         findViewById<TextView>(R.id.btn_login).setOnClickListener(this)
        // Click event for sign up text
            findViewById<TextView>(R.id.forgotpasswordLogin).setOnClickListener(this)
        // Click event for sign up text
            findViewById<TextView>(R.id.registerhere).setOnClickListener(this)





        // Click event for sign up text
            findViewById<TextView>(R.id.registerhere).setOnClickListener {
            // Launch the register screen when the user clicks on the text
            val intent = Intent(this@LoginActivity, RegisterActivity::class.java)
            startActivity(intent)
        }


    }
    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.btn_login -> {
                // Here we have called the validate function which will validate the credentials
                // And if the credentials are proper then only we will allow the user to login
                // else show the error message.
                logInRegisteredUser()
                validateLoginDetails()

            }
            R.id.forgotpasswordLogin -> {
                // Launch the register screen when the user clicks on the text
                val intent = Intent(this@LoginActivity, ForgotPasswordActivity::class.java)

            }

            R.id .registerhere -> {
                // Launch the register screen when the user clicks on the text
                val intent = Intent(this@LoginActivity, RegisterActivity::class.java)
            }

        }
    }

    private fun validateLoginDetails(): Boolean{
        return when {
            TextUtils.isEmpty(findViewById<TextView>(R.id.tv_email).text.toString().trim { it <= ' ' }) -> {
                showErrorSnackBar(resources.getString(R.string.err_msg_enter_email), true)
                false
            }
            TextUtils.isEmpty(findViewById<TextView>(R.id.tv_password).text.toString().trim { it <= ' ' }) -> {
                showErrorSnackBar(resources.getString(R.string.err_msg_enter_password), true)
                false
            }
            else -> {
                // showErrorSnackBar("Your details are valid.", false)
                true
            }

        }
    }

    private fun logInRegisteredUser() {

        validateLoginDetails()
        // Get the text from editText and trim the space
        val email = findViewById<TextView>(R.id.tv_email).text.toString().trim { it <= ' ' }
        val password = findViewById<TextView>(R.id.tv_password).text.toString().trim { it <= ' ' }

        // Log-In using FirebaseAuth
        FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->

                if (task.isSuccessful) {
                    // Firebase sign in success
                     Log.d(TAG, "signInWithEmail:success")
                    // val user = auth.currentUser
                    // updateUI(user)
                     FirestoreClass().getUserDetails(this@LoginActivity)
                } else {
                    // If sign in fails, display a message to the user.
                    // Log.w(TAG, "signInWithEmail:failure", task.exception)
                     Toast.makeText(baseContext, "Authentication failed.",
                     Toast.LENGTH_SHORT).show()
                    // updateUI(null)
                    showErrorSnackBar(task.exception!!.message.toString(), true)
                }


            }
    }

    fun userLoggedInSuccess(user: User) {

        // Print the user details in the log as of now.
        Log.i("First Name: ", user.firstName)
        Log.i("Last Name: ", user.lastName)
        Log.i("Email: ", user.email)

        if (user.profileCompleted == 0) {
            // If the user profile is incomplete then launch the UserProfileActivity.
            val intent = Intent(this@LoginActivity, DashboarActivity::class.java)
            startActivity(intent)
//        } else {
//            // Redirect the user to Main Screen after log in.
//            startActivity(Intent(this@LoginActivity, MainActivity::class.java))
//        }

            finish()
        }
    }



}