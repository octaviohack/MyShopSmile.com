package com.example.myshop.activities.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myshop.R
import com.google.android.material.snackbar.Snackbar

open class BaseActivity : AppCompatActivity() {

    private var doubleBackToExitPressedOnce = false

    fun showErrorSnackBar(message: String, errorMessage: Boolean) {

        val snackbar =
            Snackbar.make(findViewById(android.R.id.content), message, Snackbar.LENGTH_LONG)
        val snackBarView = snackbar.view

        if (errorMessage) {
            snackBarView.setBackgroundColor(
                resources.getColor(R.color.colorSnackBarError))
        } else {
            snackBarView.setBackgroundColor(
                resources.getColor(R.color.colorSnackBarSuccess))
        }
        snackbar.show()

    }
    fun doubleBackToExit() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed()
            return
        }
        this.doubleBackToExitPressedOnce = true

        showErrorSnackBar(resources.getString(R.string.please_click_back_again_to_exit), false)

        android.os.Handler().postDelayed({ doubleBackToExitPressedOnce = false }, 2000)
    }




}