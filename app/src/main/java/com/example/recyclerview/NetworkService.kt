package net.simplifiedcoding.data.network



import com.example.recyclerview.news.data
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


interface NetworkService {

    @GET("v2/everything?q=bitcoin&from=2020-11-02&sortBy=publishedAt&apiKey=b150f9940f014f67bbf4d95413a274b4")
    fun getNews() : Call<data>



    companion object{
        operator fun invoke() : NetworkService {
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://newsapi.org/")
                .build()
                .create(NetworkService::class.java)
        }
    }
}
