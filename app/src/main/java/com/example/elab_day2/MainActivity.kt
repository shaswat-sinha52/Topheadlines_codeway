package com.example.elab_day2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getnews()
    }

    private fun getnews() {
        val news: Call<News> = NewsServices.newsinstance.getheadlines("in",1)
        news.enqueue(object: Callback<News> {
            override fun onResponse(call: Call<News>, response: Response<News>) {
                val news:News?=response.body()
                if (news!=null) {
                    var adapter:Adapter = Adapter(this@MainActivity, news.articles)
                    val newslist: RecyclerView = findViewById(R.id.newslist)
                    newslist.adapter = adapter
                    newslist.layoutManager = LinearLayoutManager(this@MainActivity)
                }
            }
            override fun onFailure(call: Call<News>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }
}