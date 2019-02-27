package com.penny.pennyutils

import android.content.Context
import android.os.Build

class Common{
    fun dpFromPx(context: Context, px: Float): Float {
        return px / context.resources.displayMetrics.density
    }

    fun pxFromDp(context: Context, dp: Float): Float {
        return dp * context.resources.displayMetrics.density
    }

    fun isSupport(version : Int) = Build.VERSION.SDK_INT >= version

    fun isSupport(version: Int,  t : () -> Unit, f : () -> Unit) = if (Build.VERSION.SDK_INT >= version) t()
        else f()
}