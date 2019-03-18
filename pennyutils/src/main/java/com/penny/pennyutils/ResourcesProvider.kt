package com.penny.pennyutils

import android.content.Context

interface ResourcesProvider {
    fun getString(resId: Int): CharSequence
    fun getPackageName(): CharSequence
}

class ResourceProviderImpl(private val context: Context) : ResourcesProvider {
    override fun getString(resId: Int): CharSequence = context.getString(resId)

    override fun getPackageName(): CharSequence = context.packageName
}