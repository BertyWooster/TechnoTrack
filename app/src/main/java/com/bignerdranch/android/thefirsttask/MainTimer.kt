package com.bignerdranch.android.thefirsttask

import android.os.CountDownTimer


public class MainTimer(val maxtime: Long, step: Long, val ontick: ()->Int, val onfinish:()->Int): CountDownTimer(maxtime, step){
    var tick: Long = 0
    override fun onTick(p0: Long) {
        tick++
        if(tick % 1000 == 0.toLong()){
        ontick()}
    }

    override fun onFinish() {
      tick = 0
      onfinish()
    }

}