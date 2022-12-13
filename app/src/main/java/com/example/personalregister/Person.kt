package com.example.personalregister

import android.net.Uri


data class Person(
    val name: String,
    val email:String,
    val age: Int,
    val phone:Int,
    val profilePictureUri: String ,

):java.io.Serializable