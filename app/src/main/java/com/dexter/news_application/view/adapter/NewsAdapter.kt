package com.dexter.news_application.view.adapter

import android.text.format.DateUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dexter.news_application.R
import com.dexter.news_application.model.remote.Article
import kotlinx.android.synthetic.main.item_layout.view.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class NewsAdapter(
    private val list: ArrayList<Article>
) : RecyclerView.Adapter<NewsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return NewsViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.setData(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}

class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun setData(article: Article) {
        Glide.with(itemView.poster).load(article.urlToImage).into(itemView.poster)
        itemView.apply {

            title.text = article.title
            fromWhere.text = article.author
            Description.text = article.description


            val publishAt = article.publishedAt
            val format = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
            val date = format.parse(publishAt)
            val currentDate = Date()

            val timeStamp =
                date?.time?.let {
                    DateUtils.getRelativeTimeSpanString(
                        it,
                        currentDate.time,
                        DateUtils.MINUTE_IN_MILLIS
                    )
                }
            timeAgo.text = timeStamp.toString()

        }
    }
}