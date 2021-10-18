package com.example.pdm12021

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.airbnb.lottie.LottieAnimationView

class RpsAvtivity : AppCompatActivity() {

    private var mSensorManager: SensorManager? = null
    private var mSensorListener: ShakeEventListener? = null
    private lateinit var paperRockScissorsAnim: LottieAnimationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rps_avtivity)

        mSensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager?
        mSensorListener = ShakeEventListener()
        paperRockScissorsAnim = findViewById(R.id.gameAnim)


        this.mSensorListener!!.setOnShakeListener {
            Log.d("animacion", "se hizo el shake")

            var random = (1..3).random()
            Log.d("randomNumber", random.toString())

            when(random){
                1-> paperRockScissorsAnim.setAnimation("rock.json")
                2-> paperRockScissorsAnim.setAnimation("scissors.json")
                3-> paperRockScissorsAnim.setAnimation("paper.json")
            }
            paperRockScissorsAnim.speed = 1.0f
            paperRockScissorsAnim.playAnimation()
        }


    }

    override fun onResume() {
        super.onResume()
        mSensorManager!!.registerListener(
            mSensorListener,
            mSensorManager!!.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
            SensorManager.SENSOR_DELAY_UI
        )
    }

    override fun onPause(){
        mSensorManager!!.unregisterListener(mSensorListener)
        super.onPause()
    }
}