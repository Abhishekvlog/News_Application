package com.dexter.news_application.model.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [NewsModel::class], version = 1)

abstract class NewsDatabase() : RoomDatabase() {

    abstract fun getItemDao(): NewsDAO

    companion object {
        private var INSTANCE: NewsDatabase? = null

        fun getDataBaseObject(context: Context): NewsDatabase {
            if (INSTANCE == null) {
                val builder = Room.databaseBuilder(
                    context.applicationContext,
                    NewsDatabase::class.java,
                    "NewsDb"
                )
                builder.fallbackToDestructiveMigration()

                INSTANCE = builder.build()

                return INSTANCE!!

            } else {

                return INSTANCE!!

            }


        }

    }
}