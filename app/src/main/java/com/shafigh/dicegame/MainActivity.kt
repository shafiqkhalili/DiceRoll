package com.shafigh.dicegame

import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.*
import kotlin.random.Random


class MainActivity : AppCompatActivity() {

    lateinit var diceValue: TextView
    lateinit var diceImage: ImageView
    lateinit var rollButton: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rollButton = findViewById(R.id.roll_button)
        rollButton.text = "Lets Rolll"

        val timer = MyCounter(1000, 75)
        rollButton.setOnClickListener {
            timer.start()
        }
    }

    inner class MyCounter(millisInFuture: Long, countDownInterval: Long) : CountDownTimer(millisInFuture, countDownInterval) {

        override fun onFinish() {
            println("Timer Completed.")
            //this.cancel()
        }

        override fun onTick(millisUntilFinished: Long) {

            println("Timer  : " + millisUntilFinished / 1000)
            rollDice()
        }
    }


    private fun rollDice() {

        diceValue = findViewById(R.id.result_text)

        val randomNr = Random.nextInt(1, 6)

        diceImage = findViewById(R.id.dice_image)


        var drawableresource = when (randomNr) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            6 -> R.drawable.dice_6
            else -> R.drawable.empty_dice
        }
        diceImage?.setImageResource(drawableresource)
    }

}
