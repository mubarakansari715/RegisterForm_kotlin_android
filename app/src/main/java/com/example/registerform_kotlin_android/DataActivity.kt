package com.example.registerform_kotlin_android

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DataActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data)

        val tvname = findViewById<TextView>(R.id.tvname)
        val tvemail = findViewById<TextView>(R.id.tvemail)
        val tvmobile = findViewById<TextView>(R.id.tvmobile)
        val tvgender = findViewById<TextView>(R.id.tvgender)
        val tvhobbie = findViewById<TextView>(R.id.tvhobbie)
        val tvpsw = findViewById<TextView>(R.id.tvpsw)

        val intent = intent
        val strname = intent.getStringExtra("Name")
        val stremail = intent.getStringExtra("Email")
        val strNumber = intent.getIntExtra("Number", 0)
        val strGander = intent.getStringExtra("Gender")
        val strSpinner = intent.getStringExtra("spineer")
        val strPassword = intent.getIntExtra("Password", 0)

        tvname.text = strname
        tvemail.text = stremail
        tvmobile.text = Integer.toString(strNumber)
        tvgender.text = strGander
        tvhobbie.text = strSpinner
        tvpsw.text = Integer.toString(strPassword)
    }
}