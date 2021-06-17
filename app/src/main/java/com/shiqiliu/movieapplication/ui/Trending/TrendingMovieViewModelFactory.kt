package com.shiqiliu.movieapplication.ui.Trending

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.shiqiliu.movieapplication.data.respository.MainRepository

class TrendingMovieViewModelFactory (val mainRepository: MainRepository):ViewModelProvider.NewInstanceFactory(){
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return TrendingMovieViewModel(mainRepository) as T
    }
}