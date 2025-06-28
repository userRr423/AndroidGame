package com.example.stonegame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton

class SettingsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)


        val btnSave = findViewById<Button>(R.id.btnSave)
        val tP = findViewById<EditText>(R.id.countToWin)

        btnSave.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            // Add extra data to the Intent
            val count:String = tP.text.toString()
            intent.putExtra("countW", count.toInt())
            startActivity(intent)
        }
    }
}