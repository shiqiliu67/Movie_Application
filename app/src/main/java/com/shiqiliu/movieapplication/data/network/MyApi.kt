package com.shiqiliu.movieapplication.data.network

import com.shiqiliu.movieapplication.data.respository.NowPlayingResponse
import com.shiqiliu.movieapplication.data.respository.TrendingResponse
import com.shiqiliu.movieapplication.data.respository.TrendingResult
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.Path
import retrofit2.http.Query

interface MyApi {
    //https://api.themoviedb.org/3/movie/now_playing?api_key=198564c5fabf8c62626e1fefed61dad8&language=en-US&page=1
//now playing
    @GET("/movie/now_playing")
    fun getMoive(
        @Query("api_key") api_key:String,
        @Query("language") language:String,
        @Query("page") page:Int
    ):Call<NowPlayingResponse>

//trending
//https://api.themoviedb.org/3/trending/all/day?api_key=198564c5fabf8c62626e1fefed61dad8
    @GET("/trending/{media_type}/{time_window}")
    fun getTrending(
        @Path("media_type") media_type:String,
        @Path("time_window") time_window:String,
        @Query("api_key") api_key: String
    ):Call<TrendingResult>

    //@Multipart
    companion object{
        operator fun invoke():MyApi{
            return Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/3")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(MyApi::class.java)
        }
    }
}