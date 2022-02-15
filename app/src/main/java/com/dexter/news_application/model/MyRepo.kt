package com.dexter.news_application.model

import androidx.lifecycle.liveData
import com.dexter.news_application.model.remote.Article
import com.dexter.news_application.model.remote.Network

import java.lang.Exception

class MyRepo() {

    fun getApiData() =
        liveData<List<Article>>() {
            try {
                emit(Network.apiClient.getNews().articles)

            } catch (e: Exception) {

            }
        }

}

