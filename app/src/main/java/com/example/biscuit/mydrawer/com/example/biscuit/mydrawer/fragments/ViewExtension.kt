package com.example.biscuit.mydrawer.com.example.biscuit.mydrawer.fragments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by christophersaez on 20/03/2018.
 */

fun ViewGroup.inflate(resId: Int) : View {
    return LayoutInflater.from(context).inflate(resId, this, false)
}


fun String.validMail() : Boolean {
    return this.contains("@")
}
