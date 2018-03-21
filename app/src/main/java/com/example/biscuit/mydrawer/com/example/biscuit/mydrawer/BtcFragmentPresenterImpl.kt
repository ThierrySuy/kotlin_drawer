package com.example.biscuit.mydrawer.com.example.biscuit.mydrawer



interface BtcFragmentPresenter {
    fun refreshArticlesList()
}


class BtcFragmentPresenterImpl: BtcFragmentPresenter {

    val service = ArticleService()

    override fun refreshArticlesList() {

        service.getArticles()
    }

}
