package com.example.navigationcomponent_jetpackcompose

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.NavType
import com.google.gson.Gson

inline fun <reified T : Parcelable> navParcelable(): NavType<T> {
    return object : NavType<T>(true) {
        override fun get(bundle: Bundle, key: String): T? {
            return bundle.getParcelable<T>(key)
        }

        override fun parseValue(value: String): T {
            val gson = Gson()
            return gson.fromJson(value, T::class.java)
        }

        override fun put(bundle: Bundle, key: String, value: T) {
            bundle.putParcelable(key, value)
        }
    }
}
