package com.example.biscuit.mydrawer

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.view.MenuItem
import android.support.v4.widget.DrawerLayout
import android.support.v7.widget.Toolbar
import android.support.v4.view.GravityCompat
import com.example.biscuit.mydrawer.com.example.biscuit.mydrawer.fragments.BtcFragment
import com.example.biscuit.mydrawer.com.example.biscuit.mydrawer.fragments.EthFragment
import com.example.biscuit.mydrawer.com.example.biscuit.mydrawer.fragments.HomeFragment
import com.example.biscuit.mydrawer.com.example.biscuit.mydrawer.fragments.CryptoFragment


class MainActivity : AppCompatActivity() {

    var mDrawerLayout: DrawerLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mDrawerLayout = findViewById(R.id.drawer_layout)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        val actionbar = supportActionBar
        actionbar!!.setDisplayHomeAsUpEnabled(true)
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu)

        val navigationView = findViewById<NavigationView>(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(
                object : NavigationView.OnNavigationItemSelectedListener {
                    override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {
                        if(!menuItem.isChecked) {
                            menuItem.isChecked = true

                            // close drawer when item is tapped
                            displayFragment(menuItem)
                        }
                        mDrawerLayout?.closeDrawers()
                        return true
                    }
                })

        supportFragmentManager.beginTransaction().replace(R.id.content_frame, BtcFragment()).commit()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            android.R.id.home -> {
                mDrawerLayout?.openDrawer(GravityCompat.START)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    fun displayFragment(item: MenuItem) {
        val fragmentManager = supportFragmentManager.beginTransaction()

        when (item.itemId) {
            R.id.nav_btc -> {
                fragmentManager.replace(R.id.content_frame, BtcFragment()).commit()
            }
            R.id.nav_eth -> {
                fragmentManager.replace(R.id.content_frame, EthFragment()).commit()
            }
            R.id.nav_trx -> {
                fragmentManager.replace(R.id.content_frame, CryptoFragment()).commit()
            }
        }
    }

}
