package com.example.course_project_tot.Activity;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.course_project_tot.R;
import com.example.course_project_tot.Modele.PomodoroModel;

import java.util.Locale;

public class PomodoroActivity extends AppCompatActivity {

    private TextView mTextViewCountDown;
    private TextView statusView;
    private Button mButtonStartPauseSkip;

    private CountDownTimer mCountDownTimer;

    private final PomodoroModel pomodoro = new PomodoroModel(1,1,2);
    private int totalTimeLeftInMillis = pomodoro.getTotalTime() * 60000;
    private int focusingTimeInMillis = pomodoro.getFocusingTime() * 60000;
    private int restTimeInMillis = pomodoro.getRestingTime() * 60000;

    private int mTimeLeftInMillis = focusingTimeInMillis;


    /**
     * Setup the view and display it on an android app for the Pomodoro Timer.
     * Start the timer by clicking the start button.
     * Once the Timer starts counting down, the start button will be invisible and the pause button
     * will appear, and we can pause the Timer by clicking the Pause button.
     * Reset the Timer by clicking the reset button.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pomodoro);


        mTextViewCountDown = findViewById(R.id.textView_view_countdown);
        statusView = findViewById(R.id.textView_status);

        mButtonStartPauseSkip = findViewById(R.id.button_start_pause);
        Button mButtonBack = findViewById(R.id.button_back);

        mButtonStartPauseSkip.setOnClickListener(view -> {
            if (pomodoro.getStatus()) {
                pauseTimer();
            } else {
                startTimer();
            }
        });

        updateCountDownText(mTimeLeftInMillis);

        mButtonBack.setOnClickListener(view -> BackToCalendar());
    }

    /**
     * Back to calendar from Pomodoro Timer.
     */
    private void BackToCalendar(){
        Intent intent = new Intent(this, CalendarActivity.class);
        startActivity(intent);
    }

    /**
     * Start the Pomodoro Timer.
     */
    private void startTimer() {
        mCountDownTimer = new CountDownTimer(mTimeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mTimeLeftInMillis = (int) millisUntilFinished;
                updateCountDownText(mTimeLeftInMillis);
            }

            @Override
            public void onFinish() {
                pomodoro.turnOff();
                if (totalTimeLeftInMillis > focusingTimeInMillis){
                totalTimeLeftInMillis -= focusingTimeInMillis;
                mTimeLeftInMillis = focusingTimeInMillis;
                restTimer();
                }
                else if (totalTimeLeftInMillis < focusingTimeInMillis){
                    mTimeLeftInMillis = totalTimeLeftInMillis;
                    restTimer();
                } else{
                    mButtonStartPauseSkip.setText("Start");
                    mButtonStartPauseSkip.setVisibility(View.INVISIBLE);
                    statusView.setVisibility(View.INVISIBLE);
                    mTextViewCountDown.setTextSize(30);
                    mTextViewCountDown.setText("Congratulations! Please press back to the calendar");
                }

            }
        }.start();

        pomodoro.turnOn();
        statusView.setText("focusing");
        mButtonStartPauseSkip.setText("pause");

    }

    private void restTimer(){
        CountDownTimer restTimer = new CountDownTimer(restTimeInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                updateCountDownText((int) millisUntilFinished);
            }

            @Override
            public void onFinish() {
                startTimer();

            }
        }.start();
        statusView.setText("resting");
        mButtonStartPauseSkip.setText("skip");

    }

    /**
     * Pause the Pomodoro Timer.
     */
    private void pauseTimer() {
        mCountDownTimer.cancel();
        pomodoro.turnOff();
        mButtonStartPauseSkip.setText("Start");

    }


    /**
     * Update the time displayed in the Pomodoro Timer.
     */
    private void updateCountDownText(int mTimeLeftInMillis) {
        int minutes = (mTimeLeftInMillis / 1000) / 60;
        int seconds = (mTimeLeftInMillis / 1000) % 60;

        String timeLeftFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);

        mTextViewCountDown.setText(timeLeftFormatted);

    }

}

