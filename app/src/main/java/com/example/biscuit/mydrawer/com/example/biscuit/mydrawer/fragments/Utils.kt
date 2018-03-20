package com.example.biscuit.mydrawer.com.example.biscuit.mydrawer.fragments

/**
 * Created by christophersaez on 20/03/2018.
 */

class Utils {
    companion object {
        fun validMail(mail: String) : Boolean {
            return mail.contains("@")
        }
    }
}
