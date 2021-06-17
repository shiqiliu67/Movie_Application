package com.shiqiliu.movieapplication.data.respository.remote

import com.shiqiliu.movieapplication.data.respository.NowPlayingResponse
import com.shiqiliu.movieapplication.data.respository.TrendingResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
//https://api.themoviedb.org/3/movie/now_playing?api_key=198564c5fabf8c62626e1fefed61dad8&language=en-US&page=1
//https://api.themoviedb.org/3/trending/all/day?api_key=198564c5fabf8c62626e1fefed61dad8
companion object{
    const val API_KEY = "198564c5fabf8c62626e1fefed61dad8"
}
   // @GET("/trending/{media_type}/{time_window}")
    @GET("trending/all/day")
    suspend fun getTrendingMovie(
       @Query("api_key") api_key :String = API_KEY
   ): Response<TrendingResponse>


    @GET("movie/now_playing")
    suspend fun getPlayingMovie(
        @Query("api_key") api_key :String = API_KEY
    ): Response<NowPlayingResponse>

}