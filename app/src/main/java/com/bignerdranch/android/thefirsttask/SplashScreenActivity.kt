package com.bignerdranch.android.thefirsttask

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.content.Intent
import android.os.CountDownTimer

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        object : CountDownTimer(2000, 2000) {
            override fun onTick(millisUntilFinished: Long) {}
            override fun onFinish() {
                startApp()
                finish()
            }
        }.start()

    }

fun startApp(){
    val intent = Intent(this, MainActivity::class.java)
    startActivity(intent)
}

}

