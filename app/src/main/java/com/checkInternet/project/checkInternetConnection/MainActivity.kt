package com.checkInternet.project.checkInternetConnection

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.lifecycle.Observer

class MainActivity : AppCompatActivity() {
    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvConnection = findViewById<TextView>(R.id.tvConnection)
        val imgConnection = findViewById<ImageView>(R.id.imgConnection)

        val networkConnection = checkConnection(applicationContext)
        networkConnection.observe(this, Observer { isConnected ->
            if (isConnected) {
                tvConnection.text = "Connected"
                tvConnection.setTextColor(resources.getColor(R.color.connected))
                imgConnection.setImageResource(R.drawable.shield)
            } else {
                tvConnection.text = "disConnected"
                tvConnection.setTextColor(resources.getColor(R.color.disConnected))
                imgConnection.setImageResource(R.drawable.unplugged)
            }
        })

    }

}