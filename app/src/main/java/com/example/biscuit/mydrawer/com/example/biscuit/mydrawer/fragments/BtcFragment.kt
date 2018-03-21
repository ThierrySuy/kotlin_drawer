package com.example.biscuit.mydrawer.com.example.biscuit.mydrawer.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.biscuit.mydrawer.R
import com.example.biscuit.mydrawer.com.example.biscuit.mydrawer.Articles
import com.example.biscuit.mydrawer.com.example.biscuit.mydrawer.BtcFragmentPresenter
import com.example.biscuit.mydrawer.com.example.biscuit.mydrawer.BtcFragmentPresenterImpl

/**
 * Created by Biscuit on 19/03/2018.
 */

interface BtcViewInterface {

    fun onArticlesReceived(articles: List<Articles>?)

}

class BtcFragment : Fragment(), BtcViewInterface {

    var presenter : BtcFragmentPresenter = BtcFragmentPresenterImpl(this)
    private var adapter: ArticlesAdapter = ArticlesAdapter()
    private var pullToRefreshLayout: SwipeRefreshLayout? = null

    override fun onArticlesReceived(articles: List<Articles>?) {
        adapter.articles = articles
        adapter.notifyDataSetChanged()
        pullToRefreshLayout?.isRefreshing = false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        presenter.refreshArticlesList()

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView =  inflater.inflate(R.layout.btc_fragment, container, false)
        val rv = rootView.findViewById<RecyclerView>(R.id.articles_rv_btc)
        val pullToRefreshLaout = rootView.findViewById<SwipeRefreshLayout>(R.id.swipeRefreshLayout)
        rv.layoutManager = LinearLayoutManager(context)
        adapter = ArticlesAdapter()
        rv.adapter = adapter

        return rootView
    }
}