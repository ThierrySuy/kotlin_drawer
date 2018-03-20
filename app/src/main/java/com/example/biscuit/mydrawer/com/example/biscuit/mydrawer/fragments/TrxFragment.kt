package com.example.biscuit.mydrawer.com.example.biscuit.mydrawer.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.biscuit.mydrawer.R
import kotlinx.android.synthetic.main.trx_fragment.*

/**
 * Created by Biscuit on 19/03/2018.
 */

class TrxFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view: View = inflater.inflate(R.layout.trx_fragment, container, false)
        val btn: Button = view.findViewById(R.id.trx_btn)
        btn.setOnClickListener{
            btn.visibility = View.GONE
            moon_img.visibility = View.VISIBLE
        }

        return view
    }
}