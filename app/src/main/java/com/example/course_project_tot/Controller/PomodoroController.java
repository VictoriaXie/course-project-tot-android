package com.example.course_project_tot.Controller;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PomodoroController {
    private Button mButtonStartPause;
    private Button mButtonReset;

    public PomodoroController(Button mButtonStartPause, Button mButtonReset){
        this.mButtonStartPause = mButtonStartPause;
        this.mButtonReset = mButtonReset;
    }

    public void resetTimer(){
        mButtonReset.setVisibility(View.INVISIBLE);
        mButtonStartPause.setVisibility(View.VISIBLE);
    }
}

