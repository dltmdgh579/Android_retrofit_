package com.example.myapplication

import retrofit2.Call
import retrofit2.http.*

interface Server_test{

    @FormUrlEncoded
//    @Headers("Content-Type:application/json")
    @Headers("Content-Type:application/x-www-form-urlencoded; charset=utf-8")
    @POST("/")
    fun requestServer(
        @Field("responseTest") responseTest:String
    ) : Call<Send_test>

}