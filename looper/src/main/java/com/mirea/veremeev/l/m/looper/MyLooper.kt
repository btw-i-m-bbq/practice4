package com.mirea.veremeev.l.m.looper

import android.annotation.SuppressLint
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.util.Log

class MyLooper : Thread() {
    private var number = 0
    lateinit var handler : Handler
    @SuppressLint("HandLeak")
    override fun run() {
        Log.d("MyLooper", "run")
        Looper.prepare()
        handler = object : android.os.Handler(Looper.getMainLooper()) {
            override fun handleMessage(msg: Message) {
                Log.d("MyLooper", number.toString() + ":"+ msg.data.getString("KEY"))
                number++
            }
        }
        Looper.loop()
    }
}