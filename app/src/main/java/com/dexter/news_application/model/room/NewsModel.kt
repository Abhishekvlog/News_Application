package com.dexter.news_application.model.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "NewsDatabase")
data class NewsModel(
    @ColumnInfo(name = "time") var time: String,
    @ColumnInfo(name = "from") var from: String,
    @ColumnInfo(name = "title") var title: String,
    @ColumnInfo(name = "image") var image: String,
    @ColumnInfo(name = "description") var description: String
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int? = null
}