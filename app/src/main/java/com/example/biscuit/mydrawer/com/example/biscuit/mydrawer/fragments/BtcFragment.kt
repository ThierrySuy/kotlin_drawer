package com.example.biscuit.mydrawer.com.example.biscuit.mydrawer.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.biscuit.mydrawer.R
import com.example.biscuit.mydrawer.com.example.biscuit.mydrawer.BtcFragmentPresenter

/**
 * Created by Biscuit on 19/03/2018.
 */

class BtcFragment : Fragment() {

    var presenter : BtcFragmentPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView =  inflater.inflate(R.layout.btc_fragment, container, false)
        val rv = rootView.findViewById<RecyclerView>(R.id.articles_rv)
        rv.layoutManager = LinearLayoutManager(context)
        rv.adapter = ArticlesAdapter()



        return rootView
    }
}