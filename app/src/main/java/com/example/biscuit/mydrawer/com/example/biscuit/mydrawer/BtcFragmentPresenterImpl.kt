package com.example.biscuit.mydrawer.com.example.biscuit.mydrawer

import com.example.biscuit.mydrawer.com.example.biscuit.mydrawer.fragments.BtcViewInterface


interface BtcFragmentPresenter {
    fun refreshArticlesList()
}


class BtcFragmentPresenterImpl(val viewCallback: BtcViewInterface) : BtcFragmentPresenter {

    val service = ArticleService()

    override fun refreshArticlesList() {

        service.getArticlesBtc(object : ArticlesBtcReceivedCallback{
            override fun onInternetError() {
            }

            override fun onArticlesReceived(articles: List<Articles>?) {
                viewCallback.onArticlesReceived(articles)
            }

        })
    }

}

interface ArticlesBtcReceivedCallback {
    fun onArticlesReceived(articles: List<Articles>?)
    fun onInternetError()
}
