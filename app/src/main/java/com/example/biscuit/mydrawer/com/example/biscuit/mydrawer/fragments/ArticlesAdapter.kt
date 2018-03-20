package com.example.biscuit.mydrawer.com.example.biscuit.mydrawer.fragments

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.biscuit.mydrawer.R
import com.example.biscuit.mydrawer.com.example.biscuit.mydrawer.Articles
import com.example.biscuit.mydrawer.com.example.biscuit.mydrawer.DetailArticleActivity

/**
 * Created by christophersaez on 20/03/2018.
 */

class ArticlesAdapter : RecyclerView.Adapter<ArticlesViewHolder>() {

    var articles = arrayListOf<Articles>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticlesViewHolder {
        val view = parent.inflate(R.layout.cell_articles)
        return ArticlesViewHolder(view)
    }

    override fun getItemCount(): Int {
        return articles.size
    }

    override fun onBindViewHolder(holder: ArticlesViewHolder, position: Int) {
        val context = holder.itemView.context
        val article = articles.get(position)

        holder.imageTitle.text = article.title
        Glide.with(context).load(article.imageUrl).into(holder.imageArticle)
        holder.imageDescription.text = article.description

        holder.itemView.setOnClickListener({
            context.startActivity(Intent(context, DetailArticleActivity::class.java))
        })

    }

}