package com.example.recyclerview


import android.annotation.SuppressLint
import android.graphics.drawable.Drawable
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerview.layout_2.YoutubeAdapter
import com.example.recyclerview.layout_2.YoutubeData
import kotlinx.android.synthetic.main.activity_main.*

class
MainActivity : AppCompatActivity() {

    private var  list=ArrayList<RecyclerData>() // [RecyclerData,RecyclerData,RecyclerData]
    lateinit var  data : RecyclerData


    private var list2 = ArrayList<YoutubeData>()
    lateinit var  data2:YoutubeData

    @SuppressLint("UseCompatLoadingForDrawables")
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.layoutManager = LinearLayoutManager(this)//Linear, Grid, Card, Horizontal



//        val names = arrayListOf("Anne", "Peter", "Jeff","Inside Out","Fury","Martian","Fantasy",
//            "Awakens","Rogue","Anne", "Peter", "Jeff","Inside Out","Fury","Anne", "Peter", "Jeff","Inside Out","Fury")
//        for (i in 0..17){
//            data = RecyclerData(i.toString(),names[i])
//            list.add(data)
//        }
//        recyclerView.apply {
//            adapter = RecyclerAdapter(list)
//        }



        val img: Drawable? = getDrawable(R.drawable.demo)

        val head = arrayListOf("Anne", "Peter", "Jeff","Inside Out","Fury","Martian","Fantasy",
            "Awakens","Rogue","Anne", "Peter", "Jeff","Inside Out","Fury","Anne", "Peter", "Jeff","Inside Out","Fury",)

        val body = "This sample, implemented in the DbRedditPostRepository " +
                "class, demonstrates how to set up a Repository that will use the local"

        for (i in 0..17){
            data2 = YoutubeData(img!!,head[i],body)
            list2.add(data2)
        }
        recyclerView.adapter = YoutubeAdapter(list2)

    }
}
