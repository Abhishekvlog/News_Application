package com.dexter.news_application.model.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface NewsDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addNews(newsModel: NewsModel)

    @Query("Select * from NewsDatabase")
    fun getNews(): LiveData<List<NewsModel>>

}