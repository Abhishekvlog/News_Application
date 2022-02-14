package com.dexter.news_application.model

import androidx.lifecycle.LiveData
import com.dexter.news_application.model.remote.ApiClient
import com.dexter.news_application.model.remote.Network
import com.dexter.news_application.model.remote.ResponseDto
import com.dexter.news_application.model.room.NewsDAO
import com.dexter.news_application.model.room.NewsModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MyRepo(val newsDAO: NewsDAO) {

    fun getApi() {
        CoroutineScope(Dispatchers.IO).launch {
            val apiClient = Network.getInstance().create(ApiClient::class.java).getNews()
            saveToDB(apiClient)
        }
    }

    private fun saveToDB(apiClient: ResponseDto) {
        var list = ArrayList<NewsModel>()
        for (i in apiClient.articles){
            var news = NewsModel(i.publishedAt, i.author, i.title ,i.urlToImage , i.description)
            list.add(news)
        }
        newsDAO.deleteAllFromNews()
        newsDAO.addListOfNews(list)
    }

    fun getAllNews(): LiveData<List<NewsModel>> {
        return newsDAO.getNews()
    }

}
