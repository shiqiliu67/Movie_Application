package com.shiqiliu.movieapplication.ui.Trending

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.shiqiliu.movieapplication.R
import com.shiqiliu.movieapplication.adapter.MovieTrendingAdapter
import com.shiqiliu.movieapplication.data.respository.MainRepository
import com.shiqiliu.movieapplication.data.respository.remote.ApiClient
import com.shiqiliu.movieapplication.data.respository.remote.ApiHelper
import com.shiqiliu.movieapplication.data.respository.remote.ApiService
import com.shiqiliu.movieapplication.ui.nowPlaying.MovieViewModelFactory
import kotlinx.android.synthetic.main.fragment_trending.view.*
import kotlinx.android.synthetic.main.row_movie_trending_adapter.view.*


class TrendingFragment : Fragment() {

lateinit var movieTrendingAdapter: MovieTrendingAdapter
lateinit var trendingMovieViewModel : TrendingMovieViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_trending, container, false)
        movieTrendingAdapter = MovieTrendingAdapter(requireContext())
        view.recycler_view.adapter = movieTrendingAdapter
        view.recycler_view.layoutManager = GridLayoutManager(requireContext(),2)

        init(view)

        return view
    }

    private fun init(view: View?) {
        var mainRepository = MainRepository(ApiHelper(ApiClient.getApiClient().create(ApiService::class.java)))
        var factory = TrendingMovieViewModelFactory(mainRepository)
        trendingMovieViewModel = ViewModelProvider(this,factory).get(TrendingMovieViewModel::class.java)

        setUpObsever()
        trendingMovieViewModel.getTrendingMovie()
    }

    private fun setUpObsever() {
       trendingMovieViewModel.msg.observe(viewLifecycleOwner){
           Toast.makeText(activity,it,Toast.LENGTH_SHORT).show()
       }
        trendingMovieViewModel.trendingMovieResponse.observe(viewLifecycleOwner){
            trendingMovieResponse ->
            if(trendingMovieResponse.total_results>0){
                //successful
                movieTrendingAdapter.setData(trendingMovieResponse.results)
            }
            else{
                Log.d("abc","no data")
            }
        }
    }


}