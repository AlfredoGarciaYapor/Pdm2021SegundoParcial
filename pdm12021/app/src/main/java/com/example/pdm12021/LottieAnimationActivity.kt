package com.example.pdm12021

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.airbnb.lottie.LottieAnimationView


class LottieAnimationActivity : AppCompatActivity() {
    private lateinit var paperAnimation: LottieAnimationView
    private lateinit var rockAnimation: LottieAnimationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lottie_animation)
        rockAnimation = findViewById(R.id.rockAnim)
        paperAnimation = findViewById(R.id.paperAnim)
        rockAnimation.speed = 1.0f
        paperAnimation.speed = 1.0f

    }
}