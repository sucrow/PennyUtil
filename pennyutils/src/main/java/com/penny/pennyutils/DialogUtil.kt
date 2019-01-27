package com.penny.pennyutils

import android.app.AlertDialog
import android.content.Context

class DialogUtil(private val context: Context) {

    fun createDialog(
        msg: Int,
        positiveText: Int = R.string.confirm,
        positiveMethod: () -> Unit,
        negativeText: Int = R.string.cancel,
        negativeMethod: () -> Unit,
        cancelable: Boolean = false
    ) {
        AlertDialog.Builder(context).setMessage(msg).setPositiveButton(positiveText) { dialog, _ ->
            positiveMethod()
            dialog.dismiss()
        }.setNegativeButton(negativeText) { dialog, _ ->
            negativeMethod()
            dialog.dismiss()
        }.setCancelable(cancelable)
            .create().show()
    }

    fun createSingleDialog(msg : Int, positiveText: Int = R.string.confirm, positiveMethod: () -> Unit){
        AlertDialog.Builder(context).setMessage(msg).setPositiveButton(positiveText){dialog, _ ->
            positiveMethod()
            dialog.dismiss()
        }.create().show()
    }
}