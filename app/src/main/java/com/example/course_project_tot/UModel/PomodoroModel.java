package com.example.course_project_tot.UModel;

import android.os.CountDownTimer;
import android.view.View;

import java.util.Locale;

public class PomodoroModel {
    private static final long START_TIME_IN_MILLIS = 1200000;

    private CountDownTimer mCountDownTimer;
    private boolean mTimerRunning;

    private long mTimeLeftInMillis = START_TIME_IN_MILLIS;

    /**
     * Turn on the Pomodoro Timer.
     */
    public void turnOn(){
        mTimerRunning = true;
    }

    /**
     * Turn off the Pomodoro Timer.
     */

    public void turnOff(){
        mTimerRunning = false;
    }

    /**
     * Return the status of the Pomodoro Timer (Whether it's running or not).
     @return True if the timer is running.
     */
    public boolean getStatus(){
        return mTimerRunning;
    }

}