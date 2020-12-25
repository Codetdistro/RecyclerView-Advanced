package com.example.recyclerview


import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerview.news.Article
import com.example.recyclerview.news.data
import kotlinx.android.synthetic.main.activity_main.*
import net.simplifiedcoding.data.network.NetworkService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity(),YoutubeAdapter.OnItemClickListener {


    private val API_KEY:String = "b150f9940f014f67bbf4d95413a274b4"

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.layoutManager = LinearLayoutManager(this)//Linear, Grid, Card, Horizontal

        //Line Between RecyclerView Item
        recyclerView.addItemDecoration(
            DividerItemDecoration(
                recyclerView.context,
                DividerItemDecoration.VERTICAL
            )
        )

        val api = NetworkService()
        api.getNews(API_KEY).enqueue(object : Callback<data> {
            override fun onResponse(call: Call<data>, response: Response<data>) {
                val body = response.body()

                recyclerView.adapter = YoutubeAdapter(body!!.articles, this@MainActivity)
            }

            override fun onFailure(call: Call<data>, t: Throwable) {
            }


        })
    }

    override fun onItemClick(item: Article) {
        val intent = Intent(this,SecondActivty::class.java)
        intent.putExtra("dataKey",item.source.name)
        startActivity(intent)

    }
}



