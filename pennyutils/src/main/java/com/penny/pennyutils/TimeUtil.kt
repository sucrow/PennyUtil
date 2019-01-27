package com.penny.pennyutils

import android.os.Handler

class TimeUtil{
    fun delay(f : () -> Unit, time : Long){
        Handler().postDelayed({
            f()
        }, time)
    }


}