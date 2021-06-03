package com.mirea.veremeev.l.m.workmanager

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var uploadWorkRequest = OneTimeWorkRequest.Builder(UploadWorker::class.java).build()

        WorkManager.getInstance(this)
                   .enqueue(uploadWorkRequest)
    }
}