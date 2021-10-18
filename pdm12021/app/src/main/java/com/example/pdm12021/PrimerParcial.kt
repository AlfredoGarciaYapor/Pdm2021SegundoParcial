package com.example.pdm12021

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import java.lang.Integer.parseInt

class PrimerParcial : AppCompatActivity() {
    internal lateinit var porcentaje: TextView
    internal lateinit var totalNumber: TextView
    internal lateinit var actualNumber: TextView
    internal lateinit var plus5Btn: Button
    internal lateinit var plus15Btn: Button
    internal lateinit var plus30Btn: Button
    internal lateinit var plus50Btn: Button
    internal lateinit var calculoBtn: Button
    internal lateinit var layoutBackground: ConstraintLayout
    internal lateinit var actualImg:ImageView
    internal lateinit var totalImg:ImageView

    var actual: Int = 0
    var total: Int = 200
    var tactual: Int = 0
    var ttotal: Int = 0
    var percent: Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_primer_parcial)


        plus5Btn = findViewById(R.id.plus5Btn)
        plus15Btn = findViewById(R.id.plus15Btn)
        plus30Btn = findViewById(R.id.plus30Btn)
        plus50Btn = findViewById(R.id.plus50Btn)
        calculoBtn = findViewById(R.id.calculoBtn)
        actualImg = findViewById(R.id.actualImg)
        totalImg = findViewById(R.id.totalImg)

        actualNumber = findViewById(R.id.actualNumber)
        totalNumber = findViewById(R.id.totalNumber)
        porcentaje = findViewById(R.id.porcentaje)

        layoutBackground = findViewById(R.id.layoutBackground)

        plus5Btn.setOnClickListener(){
            incrementActual(5)
        }

        plus15Btn.setOnClickListener(){
            incrementActual(15)
        }

        plus30Btn.setOnClickListener(){
            incrementActual(30)
        }

        plus50Btn.setOnClickListener(){
            incrementActual(50)
        }

        calculoBtn.setOnClickListener(){
            porcentageCalculation()

        }

        actualImg.setOnClickListener(){
            toastTotalManzanas(1)
        }
        totalImg.setOnClickListener(){
            toastTotalManzanas(2)
        }

        totalNumber.setText(total.toString())
    }


    private fun toastTotalManzanas(length: Int) {
        tactual = actual * 80
        ttotal = total * 80
        if(length==1){
            Toast.makeText(this, getString(R.string.manzanasActuales, tactual.toString()), Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(this, getString(R.string.manzanasTotales, ttotal.toString()), Toast.LENGTH_LONG).show()
        }
    }

    private fun porcentageCalculation() {
        total = totalNumber.text.toString().toInt()

        percent = (actual.toString().toDouble() * 100)/total.toString().toDouble()

        val percentageText: String = getString(R.string.percentage, percent.toString())
        porcentaje.text = percentageText

        if(percent>=70){
            layoutBackground.setBackgroundColor(Color.RED)
        }else{
            layoutBackground.setBackgroundColor(Color.WHITE)
        }
    }

    private fun incrementActual(num: Int) {
        actual += num
        actualNumber.setText(actual.toString())
    }
}