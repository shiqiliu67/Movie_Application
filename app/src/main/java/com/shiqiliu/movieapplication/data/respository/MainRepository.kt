package com.shiqiliu.movieapplication.data.respository

import com.shiqiliu.movieapplication.data.respository.remote.ApiHelper

class MainRepository(val apiHelper: ApiHelper) {
    suspend fun getTrendingMovie() = apiHelper.getTrendingMovie()
    suspend fun getPlayingMovie() = apiHelper.getPlayingMovie()
}