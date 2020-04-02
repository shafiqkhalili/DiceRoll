package com.shafigh.dicegame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random


class MainActivity : AppCompatActivity() {

    lateinit var diceValue : TextView
    lateinit var diceImage : ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonRoll = findViewById<Button>(R.id.buttonRoll)

        diceValue = findViewById(R.id.textViewDiceValue)

        diceImage = findViewById(R.id.imageDice)

        buttonRoll.setOnClickListener{ v ->
            rollDice()
        }

    }
    private fun rollDice(){

        val randomNr = Random.nextInt(1,6)
        diceValue.text = randomNr.toString()
        val imageName = "dice$diceValue"

        var drawableresource = when(randomNr){
            1 -> R.drawable.dice1
            2 -> R.drawable.dice2
            3 -> R.drawable.dice3
            4 -> R.drawable.dice4
            5 -> R.drawable.dice5
            else -> R.drawable.dice6
        }
        imageDice?.setImageResource(drawableresource)
    }
}
