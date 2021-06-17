package com.shiqiliu.movieapplication.ui.nowPlaying

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.shiqiliu.movieapplication.data.respository.MainRepository

class MovieViewModelFactory(val mainRepository: MainRepository): ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MovieNowPlayingViewModel(mainRepository) as T
    }
}