package com.penny.pennyutils

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.Window

class ProgressDialog(context: Context) : Dialog(context) {

    var progressDialog: ProgressDialog? = null

    init {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.layout_progress)
    }

    fun createProgressDialog() {
        progressDialog = ProgressDialog(context).apply {
            window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            setCanceledOnTouchOutside(false)
            show()
        }
    }

    fun removeProgressDialog() {
        progressDialog?.let {
            if (it.isShowing) {
                it.dismiss()
                progressDialog = null
            }
        }
    }
}
