package com.penny.pennyutils

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.widget.Toast

class BackPressHandler(private val context: Context) {
    private var backPressedTime = 0L
    private var toast: Toast? = null

    fun onBackPressed() {
        if (System.currentTimeMillis() > backPressedTime + 1500) {
            backPressedTime = System.currentTimeMillis()
            toast = Toast.makeText(context, context.getText(R.string.back_pressed), Toast.LENGTH_SHORT)
            toast!!.show()
            toast = null
        } else {
            (context as AppCompatActivity).finish()
            toast?.let {
                it.cancel()
            }
        }
    }
}