package com.example.pdm12021

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.widget.Button
import android.widget.Toast

class ToastActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_toast)

        val btnLongToast: Button = findViewById(R.id.longToastBtn)
        btnLongToast.setOnClickListener{
            Toast.makeText(applicationContext,"this is toast message",Toast.LENGTH_LONG).show()
        }

        val btnShortToast: Button = findViewById(R.id.shortToastBtn)
        btnShortToast.setOnClickListener{
            Toast.makeText(applicationContext,"this is toast message",Toast.LENGTH_SHORT).show()
        }
    }
}