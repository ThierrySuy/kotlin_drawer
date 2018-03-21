package com.example.biscuit.mydrawer.com.example.biscuit.mydrawer

import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by christophersaez on 20/03/2018.
 */
interface ApiInterface {


    @GET("/bitcoin/feed")
    fun getBitcoinArticles() : Call<ArticlesObjectResponse>

    @GET("/ethereum/feed")
    fun getEthereumArticles() : Call<ArticlesObjectResponse>

    @GET("/crypto-monnaies/feed")
    fun getCryptoArticles() : Call<ArticlesObjectResponse>
}