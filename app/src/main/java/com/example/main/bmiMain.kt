package com.example.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class bmiMain : AppCompatActivity() {
    lateinit var  resultButton: Button
    lateinit var  heightEditText: EditText
    lateinit var  weightEditText: EditText
    lateinit var  nameEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bmi_main)
        resultButton = findViewById<Button>(R.id.resultButton)
        heightEditText = findViewById<EditText>(R.id.heightEditText)
        weightEditText = findViewById<EditText>(R.id.weightEditText)
        nameEditText = findViewById<EditText>(R.id.nameEditText)

        loadDate()

        resultButton.setOnClickListener {

            saveData(heightEditText.text.toString().toInt(),
                weightEditText.text.toString().toInt(), nameEditText.text.toString())
            var intent = Intent(this, result_Bmi::class.java)
            intent.putExtra("height", heightEditText.text.toString())
            intent.putExtra("weight", weightEditText.text.toString())
            intent.putExtra("name", nameEditText.text.toString())
            startActivity(intent)
        }
    }
    private fun saveData(height: Int, weight: Int, name:String){
        var pref = this.getPreferences(0)
        var editor = pref.edit()

        editor.putInt("KEY_HEIGHT",
            heightEditText.text.toString().toInt()).apply()
        editor.putInt("KEY_WEIGHT",
            weightEditText.text.toString().toInt()).apply()
        editor.putString("KEY_NAME",
            nameEditText.text.toString()).apply()

    }
    private fun loadDate(){
        var pref = this.getPreferences(0)
        var height = pref.getInt("KEY_HEIGHT", 0)
        var weight = pref.getInt("KEY_WEIGHT", 0)
        var name = pref.getString("KEY_NAME", 0.toString())

        if(height != 0 && weight !=0){
            heightEditText.setText(height.toString())
            weightEditText.setText(weight.toString())
            nameEditText.setText(name.toString())
        }
    }
}
