 package com.smartherd.msgshareapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

 class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnShowToast.setOnClickListener{
            Log.i("MainActivity", "Button was Clicked")

            Toast.makeText(this, "Button Was Clicked", Toast.LENGTH_SHORT).show()
        }

        //creating a listener event for btnSendMsgToNextActivity
        btnSendMsgToNextActivity.setOnClickListener {
            //getting the text from etUserMsg textbox and save it to text value.
            val text : String = etUserMsg.text.toString()
            //send the text to Toast.makeText to show the text entered by the user.
            Toast.makeText(this, text, Toast.LENGTH_SHORT).show()

            //explicit intent where we know which activity our intent would use.
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra ("user_message", text)
            //starting our intent.
            startActivity(intent)


        }

        btnShareTOOtherApps.setOnClickListener{
            val text : String = etUserMsg.text.toString()
            //implicit intent there is no activity defined as we do not know which activity we are going to use.
            val intent = Intent()
            //starting our intent.
            intent.action = Intent.ACTION_SEND

            intent.putExtra(Intent.EXTRA_TEXT, text)
            intent.type = "text/plain"
            startActivity(Intent.createChooser(intent, "Share to"))


        }
    }
}
