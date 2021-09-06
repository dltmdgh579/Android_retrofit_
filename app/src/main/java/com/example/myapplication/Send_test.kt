package com.example.myapplication

import com.google.gson.annotations.SerializedName

data class Send_test(
    var response: String,
    @SerializedName("Naver_title") var NaverTitle: ArrayList<String>
)