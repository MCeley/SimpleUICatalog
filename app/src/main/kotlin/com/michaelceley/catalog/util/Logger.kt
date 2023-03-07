package com.michaelceley.catalog.util

import android.util.Log

object Logger {
    private const val TAG = "UI_Catalog"
    fun log(message: String) = Log.d(TAG, message)
}