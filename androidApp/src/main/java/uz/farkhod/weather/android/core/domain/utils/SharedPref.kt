package uz.farkhod.weather.android.core.domain.utils

import android.annotation.SuppressLint
import android.content.Context

object SharedPref {



    @SuppressLint("ApplySharedPref")
    fun setCountryCode(context: Context, code: Int) {
        val sharedPreferences = context.getSharedPreferences("cnt_code", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putInt("cnt_code", code).commit()
    }

    fun getCountryCode(context: Context): Int {
        val sharedPreferences = context.getSharedPreferences("cnt_code", Context.MODE_PRIVATE)
        return sharedPreferences.getInt("cnt_code", 1)
    }




}