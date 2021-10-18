package com.example.pdm12021

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class DetailQrCodeActivity : AppCompatActivity() {

    private lateinit var QrMessage: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_qr_code)

        QrMessage = findViewById(R.id.qr_message)
        val qrCodeMessage = intent.getStringExtra("QrCodeValue")

        QrMessage.setText(qrCodeMessage)
    }
}