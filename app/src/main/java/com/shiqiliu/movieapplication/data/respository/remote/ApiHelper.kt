package com.shiqiliu.movieapplication.data.respository.remote

class ApiHelper(val apiService: ApiService) {
    suspend fun getTrendingMovie() = apiService.getTrendingMovie()
    suspend fun getPlayingMovie() = apiService.getPlayingMovie()
}