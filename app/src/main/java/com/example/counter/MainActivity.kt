package com.example.counter

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.TextView
import androidx.annotation.RequiresApi

class MainActivity : AppCompatActivity() {
    lateinit var countTV : TextView
    lateinit var btn : Button
    var count = 0

    companion object{
        const val COUNT_MESSAGE = "com.example.counter.COUNTER"
        const val PUT_KEY = "COUNT"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        if (savedInstanceState != null){
            countTV.text = savedInstanceState.getString(PUT_KEY)
            count = savedInstanceState.getInt(PUT_KEY)
            countTV.text = count.toString()
        }
        btnClick(btn)
        textViewClick(countTV)
    }

    private fun initView(){
        countTV = findViewById(R.id.count_textView)
        btn = findViewById(R.id.button)
    }

    private fun btnClick(btn: Button){
        btn.setOnClickListener {
            count++
            if (countTV!=null)
                countTV.text = count.toString()
        }
    }

    private fun textViewClick(textView: TextView){
        textView.setOnClickListener {
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra(COUNT_MESSAGE, count.toString())
            startActivity(intent)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState, )
        outState.putString(PUT_KEY, countTV.text.toString())
        outState.putInt(PUT_KEY, count)
    }
}