package com.example.startup

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_home.*

class home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        offbu.setOnClickListener{
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
        botbu.setOnClickListener{
            val intent = Intent(this,bot::class.java)
            startActivity(intent)
        }

        onbu.setOnClickListener{
            val intent = Intent(this,online::class.java)
            startActivity(intent)
        }
    }
}