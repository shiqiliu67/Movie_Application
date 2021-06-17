package com.shiqiliu.movieapplication.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.shiqiliu.movieapplication.R
import com.shiqiliu.movieapplication.data.respository.NowPlayingResult
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.row_movie_now_playing_adapter.view.*

class MovieNowPlayingAdapter (var mContext:Context):RecyclerView.Adapter<MovieNowPlayingAdapter.MyViewHolder>(){
    var mList:ArrayList<NowPlayingResult> = ArrayList()
    inner class MyViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        fun bind(movie:NowPlayingResult){
            itemView.text_view_title.text = movie.title
            itemView.text_view_over_view.text = movie.overview
            Picasso.get().load("https://image.tmdb.org/t/p/w500/${movie.poster_path}").into(itemView.row_adapter_image_view)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var view = LayoutInflater.from(mContext).inflate(R.layout.row_movie_now_playing_adapter,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var movie = mList[position]
        return holder.bind(movie)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    fun setData(movieList: ArrayList<NowPlayingResult>){
        mList = movieList
        notifyDataSetChanged()
    }
}