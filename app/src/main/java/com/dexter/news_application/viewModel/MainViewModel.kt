package com.dexter.news_application.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dexter.news_application.model.MyRepo
import com.dexter.news_application.model.remote.Article

class MainViewModel(val repo: MyRepo) : ViewModel() {


    fun getNews() : LiveData<List<Article>>{
        return repo.getApiData()
    }

}
class MainViewModelFactory(val repo : MyRepo) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(repo)  as T
    }

}