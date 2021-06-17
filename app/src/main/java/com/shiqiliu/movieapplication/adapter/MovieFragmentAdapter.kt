package com.shiqiliu.movieapplication.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.shiqiliu.movieapplication.ui.Trending.TrendingFragment
import com.shiqiliu.movieapplication.ui.nowPlaying.MovieNowPlayingFragment

class MovieFragmentAdapter (fm:FragmentManager):FragmentPagerAdapter(fm){
    override fun getCount(): Int {
        return 2
    }

    override fun getItem(position: Int): Fragment {
       return when(position){
           0 -> MovieNowPlayingFragment()
           else ->TrendingFragment()
       }
    }
    override fun getPageTitle(position: Int): CharSequence? {
        //  return mTitle[position]
        return when (position) {
            0 -> "Movie Now Playing"
            else -> "Trending Movie"
        }
    }

}