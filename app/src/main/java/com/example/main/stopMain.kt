package com.example.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.util.*
import kotlin.concurrent.timer

class stopMain : AppCompatActivity() {
    private var time=0;
    private var timerTask:Timer?=null
    private var isRunning=false
    private  var lap=1


    lateinit var  secTextView:TextView
    lateinit var milliTextView:TextView
    lateinit var secEditText: EditText
    lateinit var setButton: Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stop_main)


        secTextView = findViewById<TextView>(R.id.secTextView)
        milliTextView = findViewById<TextView>(R.id.milliTextView)
        secEditText=findViewById(R.id.secEditText)
        setButton=findViewById(R.id.setButton)

        setButton.setOnClickListener{
            time=secEditText.text.toString().toInt()*100
            start()
        }

    }



    private fun pause(){
        // fab.setImageResource(R.drawable.ic_baseline_play_arrow_24)
        timerTask?.cancel()

    }
    private fun start(){
        //fab.setImageResource(R.drawable.ic_baseline_pause_24)

        timerTask = timer(period=10){
            time--
            val sec=time/100
            val milli=time%100

            if(sec==0&&milli==0) timerTask?.cancel()
            runOnUiThread{
                secTextView.text="$sec"
                milliTextView.text="$milli"

            }
        }
    }

    private fun reset() {
        timerTask?.cancel()

        time = 0
        isRunning = false
        // fab.setImageResource(R.drawable.ic_baseline_play_arrow_24)
        secTextView.text="0"
        milliTextView.text="00"
        //labLayout.removeAllViews()
        lap=1
    }
}
