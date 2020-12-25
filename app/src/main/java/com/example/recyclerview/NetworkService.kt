package net.simplifiedcoding.data.network



import com.example.recyclerview.news.data
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface NetworkService {

    @GET("v2/top-headlines?country=us&category=business")
    fun getNews(
        @Query("apiKey") key:String
    ):Call<data>

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
