package com.example.biscuit.mydrawer.com.example.biscuit.mydrawer.fragments

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import com.example.biscuit.mydrawer.R

class DetailArticleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_article)

        val url = intent.getStringExtra("url")

        val webview = findViewById<WebView>(R.id.webview)
        webview.webViewClient = WebViewClient()
        webview.loadUrl(url)
    }
}