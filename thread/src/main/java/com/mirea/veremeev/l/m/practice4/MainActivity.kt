package com.mirea.veremeev.l.m.practice4

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    var counter = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val infoTextView = findViewById<TextView>(R.id.textView)
        val mainThread = Thread.currentThread()
        infoTextView.setText("Текущий поток: " + mainThread.name)
        mainThread.name = "MireaThread"
        infoTextView.append("\nНовое имя потока: " + mainThread.name)
    }

    fun onClick(view: View){
        val runnable = Runnable() {
            var numberThread = counter++
            Log.i("ThreadProject", "Thread launched: " + numberThread)
            val endTime = System.currentTimeMillis() + 3 * 1000
            while(System.currentTimeMillis() < endTime){
                try{
                    Thread.sleep(endTime - System.currentTimeMillis())
                }catch (e : Exception){

                }
            }
            Log.i("ThreadProject", "Thread done: " + numberThread)
        }
        val thread = Thread(runnable)
        thread.start()
    }
}