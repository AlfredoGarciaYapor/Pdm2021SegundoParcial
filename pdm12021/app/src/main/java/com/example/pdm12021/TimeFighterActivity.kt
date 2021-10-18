package com.example.pdm12021

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.TextView
import android.widget.Toast


class TimeFighterActivity : AppCompatActivity() {

    private var musicAudio: MediaPlayer? = null
    internal lateinit var gameScore: TextView
    internal lateinit var timeLeftLabel: TextView
    internal lateinit var btnTapMe: Button

    lateinit var countDownTimer: CountDownTimer
    var initialCountDown : Long = 5000
    val countDownInterval : Long = 500

    var score: Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_time_fighter)

        gameScore = findViewById(R.id.gameScore)
        timeLeftLabel = findViewById(R.id.timeLeft)

        val bounceAnimation = AnimationUtils.loadAnimation(this, R.anim.bounce)
        val shakeAnimation = AnimationUtils.loadAnimation(this, R.anim.shake)

        timerInIt()

        btnTapMe = findViewById(R.id.tapMeBtn)
        btnTapMe.setOnClickListener{

            if(score === 0){
                musicAudio = MediaPlayer.create(this, R.raw.game)
                musicAudio?.start()
                it.startAnimation(shakeAnimation)
            } else {
                it.startAnimation(bounceAnimation)
            }
            //musicAudio = MediaPlayer.create(this, R.raw.game)
            //musicAudio?.start()
            incrementScore()
            countDownTimer.start()
        }
    }

    private fun incrementScore(){
        score++
        val newScore: String = getString(R.string.score, score.toString())
        gameScore.text = newScore
    }

    private fun timerInIt(){
        countDownTimer = object: CountDownTimer(initialCountDown, countDownInterval) {
            override fun onTick(millisUntilFinished: Long) {
                val timeLeft: Long = millisUntilFinished / 1000
                Log.d("onTick", "onTick")
                timeLeftLabel.text = getString(R.string.timeLeftLabel, timeLeft.toString())
            }

            override fun onFinish() {
                endGame()
                Log.d("EndGame", "endGame")
            }
        }
    }

    private fun endGame(){
        //Detiene la musica
        musicAudio?.stop()
        // Libera Memoria
        musicAudio?.release()
        // Reproduce sonido de juego finalizado
        musicAudio = MediaPlayer.create(this, R.raw.endgame)
        musicAudio?.start()
        // Muestra toast con el puntaje
        Toast.makeText(this, getString(R.string.end_game, score.toString()), Toast.LENGTH_LONG).show()
        btnTapMe.isEnabled = false
    }

}