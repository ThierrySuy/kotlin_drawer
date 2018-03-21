package com.example.biscuit.mydrawer.com.example.biscuit.mydrawer

import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.simplexml.SimpleXmlConverterFactory

/**
 * Created by christophersaez on 20/03/2018.
 */

class ArticleService {


    private var api: ApiInterface?

    init {
        val retrofit = Retrofit.Builder()
                .baseUrl("https://www.crypto-france.com")
                .client(OkHttpClient())
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build()
        api = retrofit.create(ApiInterface::class.java)

    }


    fun getArticlesBtc(callback: ArticlesBtcReceivedCallback) {
        api?.getBitcoinArticles()?.enqueue(object : Callback<ArticlesObjectResponse> {
            override fun onFailure(call: Call<ArticlesObjectResponse>?, t: Throwable?) {
                callback.onInternetError()
            }

            override fun onResponse(call: Call<ArticlesObjectResponse>?, response: Response<ArticlesObjectResponse>?) {
                val image = response?.body()?.channel?.image
                val articles = response?.body()?.channel?.articles
                articles?.forEach {
                    it.imageUrl = image?.imageUrl
                }
                callback.onArticlesReceived(articles)
            }
        })
    }

    fun getArticlesEth(callback: ArticlesEthReceivedCallback) {
        api?.getEthereumArticles()?.enqueue(object: Callback<ArticlesObjectResponse>{
            override fun onFailure(call: Call<ArticlesObjectResponse>?, t: Throwable?) {
                callback.onInternetError()
            }

            override fun onResponse(call: Call<ArticlesObjectResponse>?, response: Response<ArticlesObjectResponse>?) {
                val image =  response?.body()?.channel?.image
                val articles = response?.body()?.channel?.articles
                articles?.forEach {
                    it.imageUrl = image?.imageUrl
                }
                callback.onArticlesReceived(articles)
            }
        })
    }

    fun getArticlesCrypto(callback: ArticlesCryptoReceivedCallback) {
        api?.getCryptoArticles()?.enqueue(object: Callback<ArticlesObjectResponse>{
            override fun onFailure(call: Call<ArticlesObjectResponse>?, t: Throwable?) {
                callback.onInternetError()
            }

            override fun onResponse(call: Call<ArticlesObjectResponse>?, response: Response<ArticlesObjectResponse>?) {
                val image =  response?.body()?.channel?.image
                val articles = response?.body()?.channel?.articles
                articles?.forEach {
                    it.imageUrl = image?.imageUrl
                }
                callback.onArticlesReceived(articles)
            }
        })
    }
}