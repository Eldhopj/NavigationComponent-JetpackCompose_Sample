package com.example.navigationcomponent_jetpackcompose

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ExtraDetails(val age: Int, val phoneNum: String) : Parcelable
