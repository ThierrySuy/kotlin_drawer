package com.example.biscuit.mydrawer.com.example.biscuit.mydrawer

import com.example.biscuit.mydrawer.com.example.biscuit.mydrawer.fragments.CryptoViewInterface


interface CryptoFragmentPresenter {
    fun refreshArticlesList()
}


class CryptoFragmentPresenterImpl(val viewCallback: CryptoViewInterface) : CryptoFragmentPresenter {

    val service = ArticleService()

    override fun refreshArticlesList() {

        service.getArticlesCrypto(object : ArticlesCryptoReceivedCallback{
            override fun onInternetError() {
            }

            override fun onArticlesReceived(articles: List<Articles>?) {
                viewCallback.onArticlesReceived(articles!!)
            }

        })
    }

}

interface ArticlesCryptoReceivedCallback {
    fun onArticlesReceived(articles: List<Articles>?)
    fun onInternetError()
}
