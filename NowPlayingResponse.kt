package com.shiqiliu.movieapplication.data.respository

import java.io.Serializable
//parceable
data class NowPlayingResponse(
    var dates: Dates,
    var page: Int,
    var results:ArrayList<NowPlayingResult>,
    var total_pages: Int,
    var total_results: Int
):Serializable

data class Dates(
    var maximum: String,
    var minimum: String
):Serializable

data class NowPlayingResult(
    var adult: Boolean,
    var backdrop_path: String,
    var genre_ids: List<Int>,
    var id: Int,
    var original_language: String,
    var original_title: String,
    var overview: String,
    var popularity: Double,
    var poster_path: String,
    var release_date: String,
    var title: String,
    var video: Boolean,
    var vote_average: Double,
    var vote_count: Int
):Serializable

data class NowPlaying(
    var title: String,
    var original_language: String,
    var release_date: String,
):Serializable{
    companion object{
        const val KEY_MOVIE_INFO = "movieInfo"
    }
}