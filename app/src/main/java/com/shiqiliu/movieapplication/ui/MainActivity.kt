package com.shiqiliu.movieapplication.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.shiqiliu.movieapplication.R
import com.shiqiliu.movieapplication.adapter.MovieFragmentAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var movieFragmentAdapter: MovieFragmentAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }
    private fun init(){

        movieFragmentAdapter = MovieFragmentAdapter(supportFragmentManager)
        view_pager_movie.adapter = movieFragmentAdapter
        tab_layout.setupWithViewPager(view_pager_movie)
    }
}