package com.mirea.veremeev.l.m.workmanager

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import java.util.concurrent.TimeUnit

class UploadWorker(context: Context, workerParams: WorkerParameters) : Worker(context, workerParams) {
    val TAG = "UploadWorker"
    override fun doWork(): Result {
        Log.d(TAG, "doWork: start")
        try{
            TimeUnit.SECONDS.sleep(10)
        } catch (e : InterruptedException){
            e.printStackTrace()
        }
        Log.d(TAG, "doWork: end")
        return Result.success()
    }
}