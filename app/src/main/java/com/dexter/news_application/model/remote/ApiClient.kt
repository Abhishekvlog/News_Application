package com.dexter.news_application.model.remote

import retrofit2.http.GET
import retrofit2.http.Query

interface ApiClient {


    /**
     * It is used for making an api calling and here I am passing queries
     */
    @GET("v2/everything")
    suspend fun getNews(
        @Query("q") q: String,
        @Query("apiKey") apiKey: String,
        @Query("pageSize") pageSize: Int,
    ): ResponseDto
}