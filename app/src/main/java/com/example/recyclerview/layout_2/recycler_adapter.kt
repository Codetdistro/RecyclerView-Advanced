package com.example.recyclerview.layout_2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.R


class recycler_adapter(private var data: ArrayList<recycler_data>) :
    RecyclerView.Adapter<recycler_adapter.MyViewHolder>() {

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        /** binding of data change **/
        val img: ImageView = view.findViewById(R.id.image)
        val head: TextView = view.findViewById(R.id.head)
        val title:TextView = view.findViewById(R.id.body)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        /** layout chcnge **/
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.recycler_data_2, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val recyclerData = data[position]
        holder.img.setImageResource(recyclerData.img)
        holder.head.text = recyclerData.head
        holder.title.text = recyclerData.body
    }

    override fun getItemCount(): Int {
        return data.size
    }
}