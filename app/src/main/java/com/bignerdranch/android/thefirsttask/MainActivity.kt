package com.bignerdranch.android.thefirsttask

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private val LASTMAXTIME: String = "lastmaxtime" // Констаны для восстановления состояния.
    private val LASTTIMERTICK = "lasttimertick"
    private val TIMERON = "timeron"

    private val mNumbersConverter: NumbersConverter = NumbersConverter()
    private lateinit var mButton: Button
    private lateinit var mTextView: TextView
    private lateinit var mMainTimer: MainTimer
    private var mTimerIsOn: Int = 0
    private var mLastTimerTick: Long = 0
    private var mCurrentMaxTime: Long = 1000000
    private var mCurrentStep: Long = 1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(savedInstanceState != null){
            mTimerIsOn = savedInstanceState.getInt(TIMERON)
            mLastTimerTick = savedInstanceState.getLong(LASTTIMERTICK)
            mCurrentMaxTime = savedInstanceState.getLong(LASTMAXTIME) - mLastTimerTick
            mLastTimerTick = 0
        }

        mButton = findViewById(R.id.Button) as Button
        mTextView = findViewById(R.id.TextView) as TextView
        mMainTimer = MainTimer(mCurrentMaxTime, mCurrentStep, {ontick()}, {onfinish()})

        if(mTimerIsOn == 1 ){
            mMainTimer.start()
            mButton.setText(R.string.stop_button)
        }

        mButton.setOnClickListener(){
            if(mTimerIsOn == 0){
                mMainTimer.start()
                mButton.setText(R.string.stop_button)
                mTimerIsOn = 1}
            else{
                mMainTimer.onFinish()
                mMainTimer.cancel()
                mButton.setText(R.string.start_button)
                mTimerIsOn = 0 }
        }



    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putLong(LASTTIMERTICK, mMainTimer.tick)
        outState?.putLong(LASTMAXTIME, mCurrentMaxTime)
        outState?.putInt(TIMERON,mTimerIsOn)
    }

    private fun ontick():Int{
        mTextView.setText(mNumbersConverter.convert(((1000000 - mCurrentMaxTime + mMainTimer.tick)/1000).toInt()))
        return 0
    }

    private fun onfinish(): Int{
        mTextView.setText(R.string.stop_timer)
        mMainTimer.cancel()
        mCurrentMaxTime = 1000000
        mLastTimerTick = 0
        return 0
    }
}
