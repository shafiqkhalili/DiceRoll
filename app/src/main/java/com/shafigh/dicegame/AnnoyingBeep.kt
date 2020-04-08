package com.shafigh.dicegame

import java.util.*
import kotlin.system.exitProcess


class AnnoyingBeep {
    private var timer: Timer = Timer()

    init{
        timer.schedule(RemindTask(),
            0, //initial delay
            1 * 1000) //subsequent rate
    }
    internal inner class RemindTask:TimerTask() {
        var numWarningBeeps = 3
        override fun run() {
            if (numWarningBeeps > 0)
            {
                println("Beep!")
                numWarningBeeps--
            }
            else
            {
                println("Time's up!")
                //timer.cancel(); // Not necessary because
                // we call System.exit
                exitProcess(0) // Stops the AWT thread
                // (and everything else)
            }
        }
    }
}