package com.example.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    lateinit var calenderbutton: Button
    lateinit var stopwatchbutton: Button
    lateinit var bmibutton:Button
    lateinit var todobutton:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        calenderbutton=findViewById(R.id.calenderbutton)
        calenderbutton.setOnClickListener{
            var intent=Intent(this, Calender::class.java)
            startActivity(intent)
        }

        stopwatchbutton=findViewById(R.id.stopwatchbutton)
        stopwatchbutton.setOnClickListener{
            var  intent=Intent(this,stopMain::class.java)
            startActivity(intent)
        }

        bmibutton=findViewById(R.id.bmibutton)
        bmibutton.setOnClickListener{
            var  intent=Intent(this,bmiMain::class.java)
            startActivity(intent)
        }
        todobutton=findViewById(R.id.todobutton)
        todobutton.setOnClickListener{
            var intent=Intent(this, todoMain::class.java)
            startActivity(intent)
        }
    }
}