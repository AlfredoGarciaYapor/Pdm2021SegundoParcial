package com.example.pdm12021

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnHello: Button = findViewById(R.id.holaBtn)
        btnHello.setOnClickListener{
            Log.d("Button", "el boton hello fue clickeado")
            val intent = Intent(this, SecondActivity::class.java).apply {
            }
            startActivity(intent)
        }

        val btnToast: Button = findViewById(R.id.toastBtn)
        btnToast.setOnClickListener{
            Log.d("Button", "el boton toast fue clickeado")
            val intent = Intent(this, ToastActivity::class.java).apply {
            }
            startActivity(intent)
        }

        val btnOcultar: Button = findViewById(R.id.ocultarBtn)
        btnOcultar.setOnClickListener{
            Log.d("Button", "el boton toast fue clickeado")
            val omniImage: ImageView = findViewById(R.id.omnimanImg)

            omniImage.visibility = View.INVISIBLE
        }

        val btnGame: Button = findViewById(R.id.gameBtn)
        btnGame.setOnClickListener{
            Log.d("Button", "el boton toast fue clickeado")
            val intent = Intent(this, TimeFighterActivity::class.java).apply {
            }
            startActivity(intent)
        }

        val btnPrimerParcial: Button = findViewById(R.id.primerParcialBtn)
        btnPrimerParcial.setOnClickListener{
            Log.d("Button", "el boton toast fue clickeado")
            val intent = Intent(this, PrimerParcial::class.java).apply {
            }
            startActivity(intent)
        }

        val btnGeoQuiz: Button = findViewById(R.id.geoQuizBtn)
        btnGeoQuiz.setOnClickListener{
            Log.d("Button", "el boton toast fue clickeado")
            val intent = Intent(this, GeoQuizActivity::class.java).apply {
            }
            startActivity(intent)
        }

        val btnPokeDex: Button = findViewById(R.id.pokeDexBtn)
        btnPokeDex.setOnClickListener{
            Log.d("Button", "el boton toast fue clickeado")
            val intent = Intent(this, PokeDexActivity::class.java).apply {
            }
            startActivity(intent)
        }

        val btnMaps: Button = findViewById(R.id.mapsBtn)
        btnMaps.setOnClickListener{
            Log.d("Button", "el boton toast fue clickeado")
            val intent = Intent(this, MapsActivity::class.java).apply {
            }
            startActivity(intent)
        }

        val btnRps: Button = findViewById(R.id.rpsBtn)
        btnRps.setOnClickListener{
            Log.d("Button", "el boton toast fue clickeado")
            val intent = Intent(this, RpsAvtivity::class.java).apply {
            }
            startActivity(intent)
        }

        val btnShake: Button = findViewById(R.id.shakeGestureBtn)
        btnShake.setOnClickListener{
            Log.d("Button", "el boton toast fue clickeado")
            val intent = Intent(this, ShakeGestureActivity::class.java).apply {
            }
            startActivity(intent)
        }

        val btnLottie: Button = findViewById(R.id.lottieAnimBtn)
        btnLottie.setOnClickListener{
            Log.d("Button", "el boton toast fue clickeado")
            val intent = Intent(this, LottieAnimationActivity::class.java).apply {
            }
            startActivity(intent)
        }

        val btnQr: Button = findViewById(R.id.qrBtn)
        btnQr.setOnClickListener{
            Log.d("Button", "el boton toast fue clickeado")
            val intent = Intent(this, QrActivity::class.java).apply {
            }
            startActivity(intent)
        }
    }
}