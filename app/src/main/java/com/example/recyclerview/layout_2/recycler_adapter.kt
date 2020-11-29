package com.example.recyclerview.layout_2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.R
import com.example.recyclerview.RecyclerAdapter
import com.example.recyclerview.databinding.YoutubeBinding


class YoutubeAdapter(private var data: ArrayList<YoutubeData>) :
    RecyclerView.Adapter<YoutubeAdapter.MyViewHolder>() {

    class MyViewHolder(val binding: YoutubeBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        /** layout binding with RecyclerView **/
        MyViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.youtube,
                parent,
                false
            )
        )



    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
       holder.binding.youtubeData = data[position]
    }

    override fun getItemCount(): Int {
        return data.size
    }
}