package com.shiqiliu.movieapplication.data.network

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.shiqiliu.movieapplication.data.respository.NowPlayingResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieNowPlayingRespository {
    var api_key ="198564c5fabf8c62626e1fefed61dad8"
    var language = "en-US"
    var page = 1

    fun movieNowPlaying():LiveData<String>{
        var movieResponse = MutableLiveData<String>()
        var api = MyApi()
        api.getMoive(api_key,language,page).enqueue(object :Callback<NowPlayingResponse>{
            override fun onResponse(
                call: Call<NowPlayingResponse>,
                response: Response<NowPlayingResponse>
            ) {
               if (response.isSuccessful){
                   Log.d("abc","movie now playing load successful")
                   movieResponse.value = "load successful"
               }
                Log.d("abc","movie now playing load failed")
            }

            override fun onFailure(call: Call<NowPlayingResponse>, t: Throwable) {
                Log.d("abc","movie now playing on failure")
                movieResponse.value ="load failed"
            }

        })
        return movieResponse
    }


}