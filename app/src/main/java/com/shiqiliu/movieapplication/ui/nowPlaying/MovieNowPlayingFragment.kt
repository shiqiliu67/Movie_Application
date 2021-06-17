package com.shiqiliu.movieapplication.ui.nowPlaying

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
import com.shiqiliu.movieapplication.adapter.MovieNowPlayingAdapter
import com.shiqiliu.movieapplication.data.respository.MainRepository
import com.shiqiliu.movieapplication.data.respository.remote.ApiClient
import com.shiqiliu.movieapplication.data.respository.remote.ApiHelper
import com.shiqiliu.movieapplication.data.respository.remote.ApiService
import kotlinx.android.synthetic.main.fragment_movie_now_playing.view.*


class MovieNowPlayingFragment : Fragment() {
    lateinit var movieNowPlayingAdapter: MovieNowPlayingAdapter
    lateinit var viewModel: MovieNowPlayingViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view =  inflater.inflate(R.layout.fragment_movie_now_playing, container, false)
//        movieNowPlayingAdapter = MovieNowPlayingAdapter(requireContext())
//        view.recycler_view.adapter = movieNowPlayingAdapter
//        view.recycler_view.layoutManager = LinearLayoutManager(activity)

        init(view)
        return view
    }

    private fun init(view: View) {
        movieNowPlayingAdapter = MovieNowPlayingAdapter(requireContext())
        view.recycler_view.adapter = movieNowPlayingAdapter
        view.recycler_view.layoutManager = GridLayoutManager(activity,2)

        val mainRespository = MainRepository(ApiHelper(ApiClient.getApiClient().create(ApiService::class.java)))
        val factory = MovieViewModelFactory(mainRespository)
        viewModel = ViewModelProvider(this,factory).get(MovieNowPlayingViewModel::class.java)

        setUpObsever()
        viewModel.getPlayingMovie()

    }

    private fun setUpObsever() {
        viewModel.msg.observe(viewLifecycleOwner){
            Toast.makeText(activity,it,Toast.LENGTH_SHORT).show()
        }
        viewModel.playingMovieResponse.observe(viewLifecycleOwner){
            playingMovieResponse  ->
            if (playingMovieResponse.total_results>0){
                //successful
                movieNowPlayingAdapter.setData(playingMovieResponse.results)
            }
            else{
                Log.d("abc","No data")
            }

        }
    }


}