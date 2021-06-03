package com.mirea.veremeev.l.m.loadermanager

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.loader.app.LoaderManager.LoaderCallbacks
import androidx.loader.content.Loader


class MainActivity : AppCompatActivity(), LoaderCallbacks<String> {
    val TAG = this.javaClass.kotlin.simpleName
    lateinit var shuffleArea : EditText
    private val LoaderID = 1234

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        shuffleArea = findViewById(R.id.editText)
    }

    override fun onLoaderReset(loader: Loader<String>) {
        Log.d(TAG, "onLoaderReset")
    }

    override fun onCreateLoader(id: Int, bundle: Bundle?): Loader<String> {
        if (id == LoaderID){
            Toast.makeText(this, "onCreateLoader" + id.toString(), Toast.LENGTH_SHORT).show()
            return MyLoader(this, bundle)
        }
        return MyLoader(this, bundle)
    }

    override fun onLoadFinished(loader: Loader<String>, s: String?) {
        if (loader.id == LoaderID){
            Log.d(TAG, "onLoadFinished" + s)
            Toast.makeText(this, "onLoadFinished" + s, Toast.LENGTH_SHORT).show()
            shuffleArea.setText(s)
        }
    }

    fun onClickShuffle(view : View){
        var bundle = Bundle()
        bundle.putString("word", shuffleArea.text.toString())
        supportLoaderManager.initLoader(LoaderID, bundle, this)
    }

}