package com.mirea.veremeev.l.m.loadermanager

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.annotation.NonNull
import androidx.loader.content.AsyncTaskLoader

class MyLoader(context: Context) : AsyncTaskLoader<String>(context) {

    private var firstName : String = "NULL"
    val ARG_WORD : String = "word"

    constructor(@NonNull context: Context, args: Bundle?) : this(context) {
        super.getContext()
        if (args != null){
            firstName = args.getString(ARG_WORD).toString()
            Log.d("WORD", firstName)
            var builder = StringBuilder()
            for(i in 0..firstName.length){
                if(i % 2 == 0){
                    try {
                        builder.append(firstName[i + 2])
                    }catch (e : Exception){

                    }
                }else{
                    try {
                        builder.append(firstName[i - 1])
                    }catch (e : Exception){

                    }
                }
            }
            firstName = builder.toString()
        }

    }

    override fun onStartLoading() {
        super.onStartLoading()
        forceLoad()
    }

    override fun loadInBackground(): String? {
        return firstName
    }
}