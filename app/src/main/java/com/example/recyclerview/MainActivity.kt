package com.example.recyclerview


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerview.news.data
import kotlinx.android.synthetic.main.activity_main.*
import net.simplifiedcoding.data.network.NetworkService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.layoutManager = LinearLayoutManager(this)//Linear, Grid, Card, Horizontal

        val api = NetworkService()
        api.getNews().enqueue(object : Callback<data> {
            override fun onResponse(call: Call<data>, response: Response<data>) {
                var body = response.body()
                recyclerView.adapter = YoutubeAdapter(body!!.articles)
            }

            override fun onFailure(call: Call<data>, t: Throwable) {
            }

        })
    }
}
