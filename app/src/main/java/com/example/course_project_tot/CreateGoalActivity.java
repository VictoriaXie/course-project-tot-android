package com.example.course_project_tot;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.time.LocalDate;

public class CreateGoalActivity extends AppCompatActivity implements CreateGoalPresenter.View{
    private CreateGoalPresenter presenter;
    private LocalDate date;

    private TextView dateText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_goal);

        Intent intent = getIntent();
        date = (LocalDate) intent.getSerializableExtra("date");

        presenter = new CreateGoalPresenter(this);

        dateText = findViewById(R.id.editTextDate);
        updateDate(date);
    }


    /**
     * On click listener for "Create Goals" button. A goal is created with values from the text fields
     * and added to the list of goals.
     * @param view Object that triggered the event.
     */
    public void createGoal(View view) {
        // TODO: Add rest of fields
        EditText nameText = findViewById(R.id.editTextName);
        EditText descriptionText = findViewById(R.id.editTextDescription);

        String name = nameText.getText().toString();
        if (name.isEmpty()) {
            nameText.setError("Name is required");
        } else {
            Goal goal = new Goal.Builder(name).build();
            presenter.addGoal(date, goal);
            Intent intent = new Intent(this, CalendarActivity.class);
            startActivity(intent);
            finish();
        }
    }

    @Override
    public void updateDate(LocalDate date) {
        dateText.setText(date.toString());
    }
}
