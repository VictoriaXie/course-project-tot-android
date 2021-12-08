package com.example.course_project_tot.View;

import android.widget.EditText;

import com.example.course_project_tot.Goal;
import com.example.course_project_tot.Modele.User;
import com.example.course_project_tot.Modele.UserList;

import java.time.LocalDate;

public class CreateGoalPresenter {
    private View view;

    public CreateGoalPresenter(View view) {
        this.view = view;
    }

    public void updateDate(LocalDate date) {
        view.updateDate(date);
    }

    public void addGoal(LocalDate date, EditText nameText, EditText descriptionText, EditText numHoursText) {
        String name = nameText.getText().toString();
        String description = descriptionText.getText().toString();
        String numHours = numHoursText.getText().toString();
        int hours = 1;
        if (name.isEmpty()) {
            view.setNameError("Name cannot be empty");
        }
        if (!numHours.isEmpty()) {
            hours = Integer.parseInt(numHours);
        }
        Goal goal = new Goal.Builder(name)
                .description(description)
                .timeRequired(hours)
                .date(date)
                .build();

        User currentUser = UserList.getInstance().getCurrentUser();
        currentUser.addGoal(goal);
        UserList.getInstance().writeToFile();
    }

    public interface View {
        void updateDate(LocalDate date);
        void setNameError(String error);
    }
}

