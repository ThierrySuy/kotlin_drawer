package com.example.biscuit.mydrawer.com.example.biscuit.mydrawer

import com.example.biscuit.mydrawer.com.example.biscuit.mydrawer.fragments.BtcViewInterface


interface BtcFragmentPresenter {
    fun refreshArticlesList()
}


class BtcFragmentPresenterImpl(val viewCallback: BtcViewInterface) : BtcFragmentPresenter {

    val service = ArticleService()

    override fun refreshArticlesList() {

        service.getArticles(object : ArticlesReceivedCallback{
            override fun onInternetError() {
            }

            override fun onArticlesReceived(articles: List<Articles>?) {
                viewCallback.onArticlesReceived(articles)
            }

        })
    }

}

interface ArticlesReceivedCallback {
    fun onArticlesReceived(articles: List<Articles>?)
    fun onInternetError()
}
