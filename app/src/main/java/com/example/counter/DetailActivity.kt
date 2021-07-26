package com.example.counter

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {
    lateinit var countTV: TextView

    companion object {
        const val SAVE_COUNT = "com.example.counter.SEVE"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        initView()
        if (savedInstanceState != null) {
            countTV.text = savedInstanceState.getString(SAVE_COUNT)
        }
        val intent = intent
        var count = intent.getStringExtra(MainActivity.COUNT_MESSAGE)
        countTV.text = count.toString()
    }


    private fun initView() {
        countTV = findViewById(R.id.count_textView)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(SAVE_COUNT, countTV.text.toString())
    }

}