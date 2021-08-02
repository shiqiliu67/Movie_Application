package com.shiqiliu.movieapplication.data.respository

import java.io.Serializable

data class TrendingResponse(
    var page: Int,
    var results: ArrayList<TrendingResult>,
    var total_pages: Int,
    var total_results: Int
): Serializable

data class TrendingResult(
    var adult: Boolean,
    var backdrop_path: String,
    var first_air_date: String,
    var genre_ids: List<Int>,
    var id: Int,
    var media_type: String,
    var name: String,
    var origin_country: List<String>,
    var original_language: String,
    var original_name: String,
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