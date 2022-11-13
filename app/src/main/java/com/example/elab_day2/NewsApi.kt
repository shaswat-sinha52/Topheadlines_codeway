package com.example.elab_day2


import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
//https://newsapi.org/v2/top-headlines?country=us&apiKey=ba524de1f2c14e5490e144928a55eb0d

const val BASE_URL="https://newsapi.org/"
const val KEY="ba524de1f2c14e5490e144928a55eb0d"
interface NewsApi{
    @GET("v2/top-headlines?apiKey=ba524de1f2c14e5490e144928a55eb0d")
    fun getheadlines(@Query("country")country:String, @Query("page")page:Int): Call<News>

}
object NewsServices{
    var newsinstance:NewsApi
    init {
        var retrofit= Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        newsinstance=retrofit.create(NewsApi::class.java)
    }
}

