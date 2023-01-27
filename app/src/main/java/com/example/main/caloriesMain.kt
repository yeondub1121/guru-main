package com.example.main

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

class caloriesMain : AppCompatActivity() {

    lateinit var Kcal1: EditText
    lateinit var Kcal2: EditText
    lateinit var Kcal3: EditText
    lateinit var Kcal4: EditText
    lateinit var Kcal5: EditText

    lateinit var ResultText: TextView

    lateinit var kcal1Text : String
    lateinit var kcal2Text : String
    lateinit var kcal3Text : String
    lateinit var kcal4Text : String
    lateinit var kcal5Text : String
    lateinit var button: Button

    var totalKcal : Int =0
    //     var totalKcal: Int =0
    var cal1 : Int=0
    var cal2 : Int=0
    var cal3 : Int=0
    var cal4 : Int=0
    var cal5 : Int=0

    @SuppressLint("MissingInflatedId", "SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calories_main)

        Kcal1 = findViewById(R.id.kcalNum1)
        Kcal2 = findViewById(R.id.kcalNum2)
        Kcal3 = findViewById(R.id.kcalNum3)
        Kcal4 = findViewById(R.id.kcalNum4)
        Kcal5 = findViewById(R.id.kcalNum5)

        ResultText = findViewById<TextView>(R.id.ResultTextView)
        button = findViewById(R.id.button)

        loadDataKcal()

        button.setOnClickListener(View.OnClickListener {
            kcal1Text=Kcal1.getText().toString()
            cal1 = Integer.parseInt(kcal1Text)
            kcal2Text=Kcal1.getText().toString()
            cal2 = Integer.parseInt(kcal2Text)
            kcal3Text=Kcal1.getText().toString()
            cal3 = Integer.parseInt(kcal3Text)
            kcal4Text=Kcal1.getText().toString()
            cal4 = Integer.parseInt(kcal4Text)
            kcal5Text=Kcal1.getText().toString()
            cal5 = Integer.parseInt(kcal5Text)

            totalKcal = cal1 + cal2 + cal3 + cal4 + cal5

            ResultText.setText("오늘 섭취한 칼로리는 총 "+ totalKcal + "입니다.")

            saveDataKcal(Kcal1.text.toString().toInt(),Kcal2.text.toString().toInt(),
                    Kcal3.text.toString().toInt(), Kcal4.text.toString().toInt(), Kcal5.text.toString().toInt())
        })

    }

    private fun saveDataKcal(kcal1: Int, kcal2: Int, kcal3: Int, kcal4: Int, kcal5: Int){
        val pref = PreferenceManager.getDefaultSharedPreferences(this)
        val editor = pref.edit()

        editor.putInt("kcal1", kcal1)
                .putInt("kcal2", kcal2)
                .putInt("kcal3", kcal3)
                .putInt("kcal4", kcal4)
                .putInt("kcal5", kcal5)
                .apply()
    }


    private fun loadDataKcal(){
        val pref = PreferenceManager.getDefaultSharedPreferences(this)
        val kcal1 = pref.getInt("kcal1",0)
        val kcal2 = pref.getInt("kcal2",0)
        val kcal3 = pref.getInt("kcal3",0)
        val kcal4 = pref.getInt("kcal4",0)
        val kcal5 = pref.getInt("kcal5",0)

        if(kcal1 != 0 || kcal2 !=0 || kcal3 !=0 || kcal4 != 0 || kcal5 !=0){
            Kcal1.setText(kcal1.toString())
            Kcal2.setText(kcal2.toString())
            Kcal3.setText(kcal3.toString())
            Kcal4.setText(kcal4.toString())
            Kcal5.setText(kcal5.toString())
        }
    }
}