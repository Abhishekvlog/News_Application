package com.dexter.news_application.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dexter.news_application.R
import com.dexter.news_application.model.remote.Article
import kotlinx.android.synthetic.main.item_layout.view.*

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
            timeAgo.text = article.publishedAt
            title.text = article.title
            fromWhere.text = article.author
            Description.text = article.description
        }
    }
}