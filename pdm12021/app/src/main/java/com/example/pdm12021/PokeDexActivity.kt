package com.example.pdm12021

import android.graphics.Color
import android.icu.text.RelativeDateTimeFormatter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView

class PokeDexActivity : AppCompatActivity() {
    private lateinit var pokemonImg: ImageView
    private lateinit var nextBtn: Button
    private lateinit var nameLbl: TextView
    private lateinit var pokemonLayout: LinearLayout
    private var pokemonBank = listOf(
        Pokemon("Articuno",R.drawable.articuno,true),
        Pokemon("Bayleef",R.drawable.bayleef,false),
        Pokemon("Beautifly",R.drawable.beautifly,false),
        Pokemon("Bonsly",R.drawable.bonsly,false),
        Pokemon("Charizard",R.drawable.charizard,false),
        Pokemon("Dewgong",R.drawable.dewgong,false),
        Pokemon("Espeon",R.drawable.espeon,false),
        Pokemon("Furret",R.drawable.furret,false),
        Pokemon("Houndoom",R.drawable.houndoom,false),
        Pokemon("Ivysour",R.drawable.ivysour,false),
        Pokemon("Lapras",R.drawable.lapras,false),
        Pokemon("Leafeon",R.drawable.leafeon,false),
        Pokemon("Lucario",R.drawable.lucario,false),
        Pokemon("Lugia",R.drawable.lugia,false),
        Pokemon("Marowak",R.drawable.marowak,false),
        Pokemon("Mewtwo",R.drawable.mewtwo,true),
        Pokemon("Munchlax",R.drawable.munchlax,false),
        Pokemon("Nidorina",R.drawable.nidorina,false),
        Pokemon("Ninetales",R.drawable.ninetales,false),
        Pokemon("Pidgeotto",R.drawable.pidgeotto,false),
        Pokemon("Snivy",R.drawable.snivy,false),
        Pokemon("Suicune",R.drawable.suicune,false),
        Pokemon("Togetic",R.drawable.togetic,false)
    )

    var currentIndex = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_poke_dex)
        nextBtn = findViewById(R.id.nextBtn)
        nameLbl = findViewById(R.id.nameLbl)
        pokemonImg = findViewById(R.id.pokemonImg)
        pokemonLayout = findViewById(R.id.pokemonLayout)

        nextBtn.setOnClickListener{
            currentIndex = (currentIndex + 1) % pokemonBank.size
            updatePokemon()
        }




    }

    private fun updatePokemon() {
        var name = pokemonBank[currentIndex].name
        nameLbl.setText(name)

        var image = pokemonBank[currentIndex].image
        pokemonImg.setImageResource(image)

        if(pokemonBank[currentIndex].isLegendary == true){
            pokemonLayout.setBackgroundColor(Color.RED)
        }else{
            pokemonLayout.setBackgroundColor(Color.WHITE)
        }
    }


}