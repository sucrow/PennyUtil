package com.penny.pennyutils

import android.content.Context
import android.content.Context.MODE_PRIVATE

class SharedUtil(private val context: Context) {
    fun set(name: String = "pref", key: String, value: Any) {
        val editor = context.getSharedPreferences(name, MODE_PRIVATE).edit()

        when (value) {
            is String -> editor.putString(key, value)
            is Boolean -> editor.putBoolean(key, value)
            is Int -> editor.putInt(key, value)
            is Float -> editor.putFloat(key, value)
            is Long -> editor.putLong(key, value)
        }

        editor.apply()
    }

    fun getString(name: String = "pref", key: String): String? {
        val pref = context.getSharedPreferences(name, MODE_PRIVATE)
        return pref.getString(key, null)
    }

    fun getBoolean(name: String = "pref", key: String): Boolean {
        val pref = context.getSharedPreferences(name, MODE_PRIVATE)
        return pref.getBoolean(key, false)
    }

    fun getInt(name: String = "pref", key: String): Int {
        val pref = context.getSharedPreferences(name, MODE_PRIVATE)
        return pref.getInt(key, 0)
    }


    fun getFloat(name: String = "pref", key: String): Float {
        val pref = context.getSharedPreferences(name, MODE_PRIVATE)
        return pref.getFloat(key, 0f)
    }


    fun getLong(name: String = "pref", key: String): Long {
        val pref = context.getSharedPreferences(name, MODE_PRIVATE)
        return pref.getLong(key, 0)
    }

    fun setEncryptionString(encryptionKey : String, key : String, value: String){
        val editor = context.getSharedPreferences("pref", MODE_PRIVATE).edit()
        editor.putString(key, EncryptionUtil(encryptionKey.toByteArray()).encrypt(value.toByteArray()).toString())
        editor.apply()
    }

    fun getEncryptionString(encryptionKey: String, key: String) : String? {
        val pref = context.getSharedPreferences("pref", MODE_PRIVATE)
        return EncryptionUtil(encryptionKey.toByteArray()).decrypt(pref.getString(key, "").toByteArray()).toString()
    }
}