package com.shiqiliu.movieapplication.ui.Trending

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shiqiliu.movieapplication.data.respository.MainRepository
import com.shiqiliu.movieapplication.data.respository.TrendingResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import java.lang.Exception

class TrendingMovieViewModel(val mainRepository: MainRepository):ViewModel() {
    val trendingMovieResponse = MutableLiveData<TrendingResponse>()
    val msg = MutableLiveData<String>()
    var processing = MutableLiveData<Boolean>(true)

    fun getTrendingMovie(){
        viewModelScope.launch(Dispatchers.IO){//this is for reading api
            processing.postValue(true)
            try {
                var response = mainRepository.getTrendingMovie()
                if(response.isSuccessful){
                    msg.postValue("Successful")
                    trendingMovieResponse.postValue(response.body())//get the api movie information
                    Log.d("abc","${response.body()}")
                }
                else{
                    msg.postValue("Error here")
                }
            }
            catch (e:Exception){//catch the error
                processing.postValue(false)
                msg.postValue("Exception error here:${e.toString()}")
            }
        }

    }
}