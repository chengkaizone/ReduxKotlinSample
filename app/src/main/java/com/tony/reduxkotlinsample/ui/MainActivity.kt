package com.tony.reduxkotlinsample.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.tony.reduxkotlinsample.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setup()
    }

    fun setup() {
        findViewById<Button>(R.id.bt_login).setOnClickListener {
            startActivity(Intent(this@MainActivity, LoginActivity::class.java))
        }

        findViewById<Button>(R.id.bt_register).setOnClickListener {
            startActivity(Intent(this@MainActivity, RegisterActivity::class.java))
        }
    }
}
