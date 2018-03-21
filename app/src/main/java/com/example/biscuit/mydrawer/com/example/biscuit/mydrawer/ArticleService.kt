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


    fun getArticles() {
        api?.getBitcoinArticles()?.enqueue(object: Callback<ArticlesObjectResponse>{
            override fun onFailure(call: Call<ArticlesObjectResponse>?, t: Throwable?) {
                 }

            override fun onResponse(call: Call<ArticlesObjectResponse>?, response: Response<ArticlesObjectResponse>?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

        })
    }
}