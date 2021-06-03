package com.mirea.veremeev.l.m.looper

import android.os.Bundle
import android.os.Message
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var myLooper : MyLooper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myLooper = MyLooper()
        myLooper.start()
    }

    fun onClick(view : View){
        var msg = Message()
        var bundle = Bundle()
        bundle.putString("KEY", "mirea")
        msg.data = bundle
        if(myLooper != null){
            myLooper.handler.sendMessage(msg)
        }
    }
}