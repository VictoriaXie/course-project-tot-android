package com.example.course_project_tot.Activity;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.course_project_tot.R;
import com.example.course_project_tot.Modele.PomodoroModel;

import java.util.Locale;

public class PomodoroActivity extends AppCompatActivity {
    private static final long START_TIME_IN_MILLIS = 1200000;

    private TextView mTextViewCountDown;
    private Button mButtonStartPause;
    private Button mButtonReset;

    private CountDownTimer mCountDownTimer;
    private PomodoroModel pomodoro = new PomodoroModel(60);

    private long mTimeLeftInMillis = START_TIME_IN_MILLIS;


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

        mButtonStartPause = findViewById(R.id.button_start_pause);
        mButtonReset = findViewById(R.id.button_reset);

        mButtonStartPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (pomodoro.getStatus()) {
                    pauseTimer();
                } else {
                    startTimer();
                }
            }
        });

        mButtonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetTimer();
            }
        });
        updateCountDownText();
    }

    /**
     * Start the Pomodoro Timer.
     */
    private void startTimer() {
        mCountDownTimer = new CountDownTimer(mTimeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mTimeLeftInMillis = millisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                pomodoro.turnOff();
                mButtonStartPause.setText("Start");
                mButtonStartPause.setVisibility(View.INVISIBLE);
                mButtonReset.setVisibility(View.VISIBLE);
            }
        }.start();

        pomodoro.turnOn();
        mButtonStartPause.setText("pause");
        mButtonReset.setVisibility(View.INVISIBLE);

    }

    /**
     * Pause the Pomodoro Timer.
     */
    private void pauseTimer() {
        mCountDownTimer.cancel();
        pomodoro.turnOff();
        mButtonStartPause.setText("Start");
        mButtonReset.setVisibility(View.VISIBLE);

    }

    /**
     * Reset the Pomodoro Timer.
     */
    private void resetTimer() {
        mTimeLeftInMillis = START_TIME_IN_MILLIS;
        updateCountDownText();
        mButtonReset.setVisibility(View.INVISIBLE);
        mButtonStartPause.setVisibility(View.VISIBLE);

    }

    /**
     * Update the time displayed in the Pomodoro Timer.
     */
    private void updateCountDownText() {
        int minutes = (int) (mTimeLeftInMillis / 1000) / 60;
        int seconds = (int) (mTimeLeftInMillis / 1000) % 60;

        String timeLeftFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);

        mTextViewCountDown.setText(timeLeftFormatted);

    }
}

