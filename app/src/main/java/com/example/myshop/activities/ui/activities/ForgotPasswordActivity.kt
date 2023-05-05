package com.example.myshop.activities.ui.activities

import android.os.Bundle
import android.widget.TextView
import com.example.myshop.R
import com.google.firebase.auth.FirebaseAuth

class ForgotPasswordActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)


        findViewById<TextView>(R.id.btn_submit_forgotpassword).setOnClickListener {
          val email: String = findViewById<TextView>(R.id.editTextTextEmailAddress).text.toString().trim { it <= ' ' }
            if (email.isEmpty()) {
                showErrorSnackBar(resources.getString(R.string.err_msg_enter_email), true)
            } else {
                FirebaseAuth.getInstance().sendPasswordResetEmail(email)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            showErrorSnackBar("Email sent successfully", false)
                            finish()
                        } else {
                            showErrorSnackBar(task.exception!!.message.toString(), true)
                        }
                    }
            }

        }
    }
}