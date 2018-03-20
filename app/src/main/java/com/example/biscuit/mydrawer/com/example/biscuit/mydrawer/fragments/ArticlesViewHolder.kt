package com.example.biscuit.mydrawer.com.example.biscuit.mydrawer.fragments

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.example.biscuit.mydrawer.R

/**
 * Created by christophersaez on 20/03/2018.
 */

class ArticlesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    var imageArticle: ImageView? = itemView.findViewById(R.id.articles_imv)
    var imageTitle: TextView? = itemView.findViewById(R.id.articles_title)
    var imageDescription: TextView? = itemView.findViewById(R.id.articles_detail)

}
