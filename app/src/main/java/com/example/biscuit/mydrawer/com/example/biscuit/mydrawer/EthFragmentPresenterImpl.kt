package com.example.biscuit.mydrawer.com.example.biscuit.mydrawer

import com.example.biscuit.mydrawer.com.example.biscuit.mydrawer.fragments.EthViewInterface


interface EthFragmentPresenter {
    fun refreshArticlesList()
}


class EthFragmentPresenterImpl(val viewCallback: EthViewInterface) : EthFragmentPresenter {

    val service = ArticleService()

    override fun refreshArticlesList() {

        service.getArticlesEth(object : ArticlesEthReceivedCallback{
            override fun onInternetError() {
            }

            override fun onArticlesReceived(articles: List<Articles>?) {
                viewCallback.onArticlesReceived(articles!!)
            }

        })
    }

}

interface ArticlesEthReceivedCallback {
    fun onArticlesReceived(articles: List<Articles>?)
    fun onInternetError()
}
