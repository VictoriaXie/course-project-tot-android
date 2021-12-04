package com.example.course_project_tot;

import com.example.course_project_tot.Ucontroller.LoginController;

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
        if (LoginController.activeUser.goals.containsKey(date)) {
            LoginController.activeUser.goals.get(date).add(goal);
        } else {
            List<Goal> goals = new ArrayList<>();
            goals.add(goal);
            LoginController.activeUser.goals.put(date, goals);
        }
    }

    public interface View {
        void updateDate(LocalDate date);
    }
}

