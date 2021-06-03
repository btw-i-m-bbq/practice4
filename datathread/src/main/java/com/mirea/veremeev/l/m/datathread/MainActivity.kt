package com.mirea.veremeev.l.m.datathread

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    lateinit var runInfo : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        runInfo = findViewById<TextView>(R.id.textView)

        val runn1 = Runnable() {
            runInfo.text = "runn1"
        }
        val runn2 = Runnable() {
            runInfo.text = "runn2"
        }
        val runn3 = Runnable() {
            runInfo.text = "runn3"
        }

        val t = Thread(Runnable() {
            fun run(){
                try{
                    TimeUnit.SECONDS.sleep(2)
                    runOnUiThread(runn1)
                    TimeUnit.SECONDS.sleep(1)
                    runInfo.postDelayed(runn3, 2000)
                    runInfo.post(runn2)
                }catch (e : InterruptedException){
                    e.printStackTrace()
                }
            }
        })
        t.start()
    }
}