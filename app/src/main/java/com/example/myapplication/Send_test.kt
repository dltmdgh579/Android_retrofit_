package com.example.myapplication

import com.google.gson.annotations.SerializedName

data class Politics_requests(
    var response: String,
    @SerializedName("similar_list") var SimilarList: ArrayList<String>,
    @SerializedName("SNU_title") var SNUTitle: ArrayList<String>,
    @SerializedName("SNU_score") var SNUScore: ArrayList<String>,
    @SerializedName("Naver_title") var NaverTitle: ArrayList<String>,
    @SerializedName("Naver_link") var NaverLink: ArrayList<String>,
    @SerializedName("Naver_score") var NaverScore: ArrayList<String>,
    @SerializedName("top10_list") var KeywordTop10: ArrayList<String>
)

data class Economy_requests(
    var response: String,
    @SerializedName("similar_list") var SimilarList: ArrayList<String>,
    @SerializedName("SNU_title") var SNUTitle: ArrayList<String>,
    @SerializedName("SNU_score") var SNUScore: ArrayList<String>,
    @SerializedName("Naver_title") var NaverTitle: ArrayList<String>,
    @SerializedName("Naver_link") var NaverLink: ArrayList<String>,
    @SerializedName("Naver_score") var NaverScore: ArrayList<String>,
    @SerializedName("top10_list") var KeywordTop10: ArrayList<String>
)

data class Society_requests(
    var response: String,
    @SerializedName("similar_list") var SimilarList: ArrayList<String>,
    @SerializedName("SNU_title") var SNUTitle: ArrayList<String>,
    @SerializedName("SNU_score") var SNUScore: ArrayList<String>,
    @SerializedName("Naver_title") var NaverTitle: ArrayList<String>,
    @SerializedName("Naver_link") var NaverLink: ArrayList<String>,
    @SerializedName("Naver_score") var NaverScore: ArrayList<String>,
    @SerializedName("top10_list") var KeywordTop10: ArrayList<String>
)

data class Others_requests(
    var response: String,
    @SerializedName("similar_list") var SimilarList: ArrayList<String>,
    @SerializedName("SNU_title") var SNUTitle: ArrayList<String>,
    @SerializedName("SNU_score") var SNUScore: ArrayList<String>,
    @SerializedName("Naver_title") var NaverTitle: ArrayList<String>,
    @SerializedName("Naver_link") var NaverLink: ArrayList<String>,
    @SerializedName("Naver_score") var NaverScore: ArrayList<String>,
    @SerializedName("top10_list") var KeywordTop10: ArrayList<String>
)

data class Kakao_requests(
    var response: String,
    var objectivity: String,
    @SerializedName("similar_list") var SimilarList: ArrayList<String>,
    @SerializedName("SNU_title") var SNUTitle: ArrayList<String>,
    @SerializedName("SNU_score") var SNUScore: ArrayList<String>,
    @SerializedName("Naver_title") var NaverTitle: ArrayList<String>,
    @SerializedName("Naver_link") var NaverLink: ArrayList<String>,
    @SerializedName("Naver_score") var NaverScore: ArrayList<String>,
    @SerializedName("top10_list") var KeywordTop10: ArrayList<String>
)