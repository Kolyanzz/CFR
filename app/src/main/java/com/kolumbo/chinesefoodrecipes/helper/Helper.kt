package com.kolumbo.chinesefoodrecipes.helper

import android.app.Activity
import android.content.Context
import android.net.ConnectivityManager
import android.widget.Toast
import com.kolumbo.chinesefoodrecipes.application.App

object Helper {

    /**
     * Проверяет есть ли интернет на телефоне
     * */
    fun isConnected(context: Context): Boolean {
        val connectivity = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        return connectivity.activeNetworkInfo?.isAvailable == true && connectivity.activeNetworkInfo?.isConnected == true
    }

    fun getSharedPreferences(key: String, default: String): String {
        val sharedPreferences =
            App.instance.getSharedPreferences(Constants.SHARED_PREF_NAME, Context.MODE_PRIVATE)
        return sharedPreferences.getString(key, default) ?: default
    }

    fun putSharedPreferences(key: String, value: String) {
        val sharedPreferences =
            App.instance.getSharedPreferences(Constants.SHARED_PREF_NAME, Context.MODE_PRIVATE)
        sharedPreferences.edit().putString(key, value).apply()
    }

}