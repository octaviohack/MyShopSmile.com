package com.example.myshop.activities.ui.activities

import android.os.Build
import android.os.Bundle
import android.text.TextUtils
import android.view.WindowManager
import android.widget.TextView
import android.widget.Toast
import com.example.myshop.Firestore.FirestoreClass
import com.example.myshop.R
import com.example.myshop.models.User
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.FirebaseFirestore

class RegisterActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

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




// Click event for sign up text
        findViewById<TextView>(R.id.register_login).setOnClickListener {
            // Launch the register screen when the user clicks on the text
            onBackPressed()
        }

        findViewById<TextView>(R.id.btn_register).setOnClickListener {
            registerUser()

        }

    }

 private fun  validateRegisterDetails(): Boolean {
     return when {
         TextUtils.isEmpty(findViewById<TextView>(R.id.et_name_register).text.toString().trim { it <= ' ' }) -> {
             showErrorSnackBar(resources.getString(R.string.err_msg_enter_fist_name), true)
             false
         }
            TextUtils.isEmpty(findViewById<TextView>(R.id.et_email_register).text.toString().trim { it <= ' ' }) -> {
                showErrorSnackBar(resources.getString(R.string.err_msg_enter_email), true)
                false
            }
            TextUtils.isEmpty(findViewById<TextView>(R.id.et_password_register).text.toString().trim { it <= ' ' }) -> {
                showErrorSnackBar(resources.getString(R.string.err_msg_enter_password), true)
                false
            }
            TextUtils.isEmpty(findViewById<TextView>(R.id.et_confirm_password_register).text.toString().trim { it <= ' ' }) -> {
                showErrorSnackBar(resources.getString(R.string.err_msg_enter_confirm_password), true)
                false
            }
            else -> {
              //  showErrorSnackBar(resources.getString(R.string.registery_successfull), false)
                true
            }

     }
 }


    private fun registerUser() {


        if (validateRegisterDetails()){

            // Get the text from editText and trim the space
            val email: String = findViewById<TextView>(R.id.et_email_register).text.toString().trim { it <= ' ' }
            val password: String = findViewById<TextView>(R.id.et_password_register).text.toString().trim { it <= ' ' }

            // Create an instance and create a register a user with email and password.
            FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(

                    OnCompleteListener<AuthResult> { task ->
                        // Hide the progress dialog
                        if (task.isSuccessful) {
                            // Firebase registered user
                            val firebaseUser: FirebaseUser = task.result!!.user!!


                            val user = User (
                                firebaseUser.uid,
                                findViewById<TextView>(R.id.et_name_register).text.toString().trim { it <= ' ' },
                                findViewById<TextView>(R.id.et_last_name_register).text.toString().trim { it <= ' ' },
                                findViewById<TextView>(R.id.et_email_register).text.toString().trim { it <= ' ' }
                            )



                            FirestoreClass().registerUser(this@RegisterActivity, user)
                               FirebaseFirestore.getInstance().collection("users").document(firebaseUser.uid).set(user)


                            // Registered Email
                            showErrorSnackBar(
                                "You are registered successfully. Your user id is ${firebaseUser.uid}",
                                false
                            )

                            FirebaseAuth.getInstance().signOut()

                            // Finish the Register Screen
                            finish()
                        } else {
                            showErrorSnackBar(task.exception!!.message.toString(), true)
                        }
                    })
        }
    }


   fun userRegisteredSuccess(){

       Toast.makeText(
           this@RegisterActivity, resources.getString(R.string.registery_successfull),
           Toast.LENGTH_SHORT
       ).show()

   }







}