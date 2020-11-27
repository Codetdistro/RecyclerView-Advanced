package com.example.recyclerview


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerview.layout_2.recycler_adapter
import com.example.recyclerview.layout_2.recycler_data
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var  list=ArrayList<RecyclerData>() // [RecyclerData,RecyclerData,RecyclerData]
    lateinit var  data : RecyclerData


    private var list2 = ArrayList<recycler_data>()
    lateinit var  data2:recycler_data

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.layoutManager = LinearLayoutManager(this)


//        val names = arrayListOf("Anne", "Peter", "Jeff","Inside Out","Fury","Martian","Fantasy",
//            "Awakens","Rogue","Anne", "Peter", "Jeff","Inside Out","Fury","Anne", "Peter", "Jeff","Inside Out","Fury")
//        for (i in 0..17){
//            data = RecyclerData(i,names[i])
//            list.add(data)
//        }
//        recyclerView.adapter = RecyclerAdapter(list)


        val img: Int = R.drawable.demo

        val head = arrayListOf("Anne", "Peter", "Jeff","Inside Out","Fury","Martian","Fantasy",
            "Awakens","Rogue","Anne", "Peter", "Jeff","Inside Out","Fury","Anne", "Peter", "Jeff","Inside Out","Fury",)

        val body = "This sample, implemented in the DbRedditPostRepository " +
                "class, demonstrates how to set up a Repository that will use the local"

        for (i in 0..17){
            data2 = recycler_data(img,head[i],body)
            list2.add(data2)
        }
        recyclerView.adapter = recycler_adapter(list2)

    }
}
