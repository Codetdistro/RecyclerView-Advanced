package com.example.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.databinding.RecyclerDataBinding

class RecyclerAdapter(private var data: ArrayList<RecyclerData>) :
    RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>() {


    class MyViewHolder(val binding: RecyclerDataBinding ) : RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):MyViewHolder{
        val itemView = LayoutInflater.from(parent.context).inflate( R.layout.recycler_data, parent,false)
        /** binding our view with RecyclerDataBinding**/
        val a = RecyclerDataBinding.bind(itemView)
        return MyViewHolder(a)
    }


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.myData = data[position]

    }

    override fun getItemCount(): Int {
        return data.size
    }
}