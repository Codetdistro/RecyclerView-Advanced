
package com.example.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.Glide.init
import com.example.recyclerview.news.Article


class YoutubeAdapter(private var data: ArrayList<Article>,private val clickListener: OnItemClickListener) :
    RecyclerView.Adapter<YoutubeAdapter.MyViewHolder>() {



    interface OnItemClickListener {
        fun onItemClick(item: Article)
    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val img: ImageView = view.findViewById(R.id.newImage)
        val author: TextView = view.findViewById(R.id.author)
        val content: TextView = view.findViewById(R.id.content)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.newslayout, parent, false)
        return MyViewHolder(view)
    }



    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        //Accessing Single Item
        val newsData = data[position]


        holder.author.text = newsData.author
        holder.content.text = newsData.content

        //Glide library for Fetching Image
        Glide.with(holder.itemView)
            .load(newsData.urlToImage)
            .into(holder.img)

            holder.itemView.setOnClickListener {
                clickListener.onItemClick(newsData)
            }

    }

    override fun getItemCount(): Int {
        return data.size
    }
}