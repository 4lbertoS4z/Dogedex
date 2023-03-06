package com.example.dogedex.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


 class User(
    val id : Long,
    val email : String,
    val authenticationToken : String,

)