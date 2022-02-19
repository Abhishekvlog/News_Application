package com.dexter.news_application.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.dexter.news_application.R
import com.dexter.news_application.model.MyRepo
import com.dexter.news_application.model.remote.Article
import com.dexter.news_application.view.adapter.NewsAdapter
import com.dexter.news_application.viewModel.MainViewModel
import com.dexter.news_application.viewModel.MainViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel
    private lateinit var repo: MyRepo
    private lateinit var newsAdapter: NewsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        repo = MyRepo()

        viewModel =
            ViewModelProvider(this, MainViewModelFactory(repo)).get(MainViewModel::class.java)

       loadApi("tesla")
        editTXT.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(start: CharSequence?, p1: Int, p2: Int, p3: Int) {
               loadApi(start.toString())
            }

            override fun afterTextChanged(p0: Editable?) {

            }
        })


    }

    private fun loadApi(s: String) {
        viewModel.getNews(s).observe(this, Observer {
            val list = it as ArrayList<Article>
            Log.d("abhi",list.toString())
            setRecyclerView(list)
            count.text = "Total count:- ${it.size.toString()}"
        })
    }

    private fun setRecyclerView(list: ArrayList<Article>) {
        val linearLayout = LinearLayoutManager(this)
        newsAdapter = NewsAdapter(list)
        recyclerview.apply {
            layoutManager = linearLayout
            this.adapter = newsAdapter
        }
    }

}