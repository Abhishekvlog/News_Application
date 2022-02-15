package com.dexter.news_application.model

import android.util.Log
import androidx.lifecycle.liveData
import com.dexter.news_application.Utilities.API_KEY
import com.dexter.news_application.Utilities.PAGE_SIZE
import com.dexter.news_application.model.remote.Article
import com.dexter.news_application.model.remote.Network

import java.lang.Exception
import java.text.SimpleDateFormat
import java.util.*

class MyRepo() {

//    fun String.toDate(): Date?{
//        return SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).parse(this)
//    }
//
//    users.sortedBy { it.enrolled_at.toDate() }


    fun getApiData(q: String) = liveData {
        try {

            emit(
                Network.apiClient.getNews(
                    q, API_KEY, PAGE_SIZE
                ).articles
            )
        } catch (e: Exception) {
            Log.d("TAG", "getApiData: $e")
        }
    }
}

