package com.example.course_project_tot.Activity;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.course_project_tot.Controller.PomodoroController;
import com.example.course_project_tot.R;
import com.example.course_project_tot.Modele.PomodoroModel;

import java.util.Locale;

public class PomodoroActivity extends AppCompatActivity {
    private static final long START_TIME_IN_MILLIS = 1200;

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
        PomodoroController controller = new PomodoroController(findViewById(R.id.button_start_pause), findViewById(R.id.button_reset));


        mTextViewCountDown = findViewById(R.id.textView_view_countdown);

        mButtonStartPause = controller.getmButtonStartPause();
        mButtonReset = controller.getmButtonReset();
        Button mButtonBack = findViewById(R.id.button_back);

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

        mButtonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BackToCalendar();
            }
        });
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
                mTimeLeftInMillis = millisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                pomodoro.turnOff();
                mButtonStartPause.setText("Start");
                mButtonStartPause.setVisibility(View.INVISIBLE);
                mButtonReset.setVisibility(View.INVISIBLE);
                mTextViewCountDown.setTextSize(30);
                mTextViewCountDown.setText("Congratulations! Please press back to the calendar");
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

