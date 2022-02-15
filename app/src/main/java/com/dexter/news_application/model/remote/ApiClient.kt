package com.dexter.news_application.model.remote

import retrofit2.http.GET

interface ApiClient {

    // https://newsapi.org/v2/everything?q=tesla&from=2022-01-14&sortBy=publishedAt&apiKey=90b71e0a0ff34c248e699ddd46014b65

    @GET("v2/everything?q=tesla&apiKey=90b71e0a0ff34c248e699ddd46014b65&pageSize=100")
    suspend fun getNews(): ResponseDto
}