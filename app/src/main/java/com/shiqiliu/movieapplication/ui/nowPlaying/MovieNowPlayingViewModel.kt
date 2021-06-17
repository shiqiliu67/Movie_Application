package com.shiqiliu.movieapplication.ui.nowPlaying

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shiqiliu.movieapplication.data.respository.MainRepository
import com.shiqiliu.movieapplication.data.respository.NowPlayingResponse
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class MovieNowPlayingViewModel(val mainRepository: MainRepository) : ViewModel() {
    val playingMovieResponse = MutableLiveData<NowPlayingResponse>()
    val processing = MutableLiveData<Boolean>(true)
    val msg = MutableLiveData<String>()

    fun getPlayingMovie() {
        viewModelScope.launch(IO) {//read response form api
            processing.postValue(true)
            try {
                val response = mainRepository.getPlayingMovie()
                if (!response.isSuccessful) {
                    msg.postValue("Error occurred when get Playing movies")
                } else {
                    playingMovieResponse.postValue(response.body())
                    Log.d("abc","${response.body()}")
                }
                processing.postValue(false)
            } catch (e: Exception) {
                processing.postValue(false)
                Log.d("abc", "Error occured. Error is : ${e.toString()}")
                msg.postValue("Error occured. Error is : ${e.toString()}")
            }
        }
    }

}