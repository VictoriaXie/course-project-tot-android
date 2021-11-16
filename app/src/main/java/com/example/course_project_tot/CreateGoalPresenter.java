package com.example.course_project_tot;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CreateGoalPresenter {
    private View view;

    public CreateGoalPresenter(View view) {
        this.view = view;
    }

    public void updateDate(LocalDate date) {
        view.updateDate(date);
    }

    public void addGoal(LocalDate date, Goal goal) {
        if (CalendarActivity.goals.containsKey(date)) {
            CalendarActivity.goals.get(date).add(goal);
        } else {
            List<Goal> goals = new ArrayList<>();
            goals.add(goal);
            CalendarActivity.goals.put(date, goals);
        }
    }

    public interface View {
        void updateDate(LocalDate date);
    }
}

