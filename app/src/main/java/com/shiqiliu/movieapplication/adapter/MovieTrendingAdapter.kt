package com.shiqiliu.movieapplication.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.shiqiliu.movieapplication.R
import com.shiqiliu.movieapplication.data.respository.TrendingResult
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.row_movie_trending_adapter.view.*

class MovieTrendingAdapter(var mContext: Context):RecyclerView.Adapter<MovieTrendingAdapter.MyViewHolder>() {

    var mList : ArrayList<TrendingResult> = ArrayList()

    inner class MyViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        fun bind(movie:TrendingResult){
            itemView.text_view_title.text = movie.title
            Picasso.get().load("https://image.tmdb.org/t/p/w500/${movie.poster_path}").into(itemView.row_adapter_image_view)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var view = LayoutInflater.from(mContext).inflate(R.layout.row_movie_trending_adapter,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
       var movie = mList[position]
        return holder.bind(movie)
    }

    override fun getItemCount(): Int {
       return mList.size
    }
    fun setData(movieList: ArrayList<TrendingResult>){
        mList = movieList
        notifyDataSetChanged()
    }

}