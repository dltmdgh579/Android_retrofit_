package com.example.myapplication

import retrofit2.Call
import retrofit2.http.*

interface Politics_Send{

    @FormUrlEncoded
//    @Headers("Content-Type:application/json")
    @Headers("Content-Type:application/x-www-form-urlencoded; charset=utf-8")
    @POST("/politics")
    fun requestServer(
        @Field("responseTest") responseTest:String
    ) : Call<Politics_requests>

}

interface Economy_Send{

    @FormUrlEncoded
//    @Headers("Content-Type:application/json")
    @Headers("Content-Type:application/x-www-form-urlencoded; charset=utf-8")
    @POST("/economy")
    fun requestServer(
        @Field("responseTest") responseTest:String
    ) : Call<Economy_requests>

}

interface Society_Send{

    @FormUrlEncoded
//    @Headers("Content-Type:application/json")
    @Headers("Content-Type:application/x-www-form-urlencoded; charset=utf-8")
    @POST("/society")
    fun requestServer(
        @Field("responseTest") responseTest:String
    ) : Call<Society_requests>

}

interface Others_Send{

    @FormUrlEncoded
//    @Headers("Content-Type:application/json")
    @Headers("Content-Type:application/x-www-form-urlencoded; charset=utf-8")
    @POST("/others")
    fun requestServer(
        @Field("responseTest") responseTest:String
    ) : Call<Others_requests>

}

interface Kakao_Send{
    @FormUrlEncoded
//    @Headers("Content-Type:application/json")
    @Headers("Content-Type:application/x-www-form-urlencoded; charset=utf-8")
    @POST("/kakao")
    fun requestServer(
        @Field("responseTest") responseTest:String
    ) : Call<Kakao_requests>
}