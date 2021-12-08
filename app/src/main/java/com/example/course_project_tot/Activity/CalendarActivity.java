package com.example.course_project_tot.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

import com.example.course_project_tot.View.CalendarPresenter;
import com.example.course_project_tot.R;

import java.time.LocalDate;

public class CalendarActivity extends AppCompatActivity implements CalendarPresenter.View {
    private CalendarPresenter presenter;

    private LocalDate curDate;

    private LinearLayout scrollLinearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        presenter = new CalendarPresenter(this);

        CalendarView calendarView = findViewById(R.id.calendarView);
        Button createGoalButton = findViewById(R.id.createGoalButton);
        scrollLinearLayout = findViewById(R.id.ll);
        curDate = LocalDate.now();

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView calendarView, int year, int month, int day) {
                curDate = LocalDate.of(year, month, day);
                presenter.updateGoalList(curDate);
            }
        });

    }

    @Override
    public void addGoalToList(String id, String name) {
        TextView textView = new TextView(this);
        textView.setText(name);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CalendarActivity.this, PomodoroActivity.class);
                intent.putExtra("goalId", id);
                startActivity(intent);
            }
        });
        scrollLinearLayout.addView(textView);
    }

    @Override
    public void clearGoalList(){
        scrollLinearLayout.removeAllViews();
    }

    /**
     * On click listener for "Create Goals" button. Moves to the create goal activity.
     * @param view Object that triggered the event.
     */
    public void goToCreateGoal(View view) {
        Intent intent = new Intent(this, CreateGoalActivity.class);
        intent.putExtra("date", curDate);
        startActivity(intent);
    }
    public void goToChart(View view) {
        Intent intent = new Intent(this, ChartActivity.class);
        startActivity(intent);
    }
}