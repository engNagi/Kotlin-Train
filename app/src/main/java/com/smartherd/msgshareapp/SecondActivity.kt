package com.smartherd.msgshareapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        // get the intent from the main activity and assign it to bundle nullable
        val bundle: Bundle? = intent.extras
        //use the bundle to extract the text from the intent of the MainActivity
        val msg = bundle!!.getString("user_message")

        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()

        txtViewUSerMsg.text = msg
    }
}