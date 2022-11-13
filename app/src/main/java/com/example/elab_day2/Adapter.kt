package com.example.elab_day2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adapter(val context:Context,val articles:List<Article>):
    androidx.recyclerview.widget.RecyclerView.Adapter<Adapter.NewsViewHolder>() {

    class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val headlinestxt: TextView =itemView.findViewById(R.id.headlinestxt)
        val descriptiontxt:TextView=itemView.findViewById(R.id.descriptiontxt)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view= LayoutInflater.from(context).inflate(R.layout.item_view,parent,false)
        return NewsViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val article=articles[position]
        holder.headlinestxt.text=article.title
        holder.descriptiontxt.text=article.description
    }
    override fun getItemCount(): Int {
        return articles.size
    }

}