package com.example.course_project_tot;

import android.content.Context;
import com.example.course_project_tot.Controller.LoginController;

import java.time.LocalDate;
import java.util.List;

public class CalendarPresenter {
    private View view;

    public CalendarPresenter(View view){
        this.view = view;
    }

    public void updateGoalList(LocalDate date) {
        view.clearGoalList();
        if (LoginController.activeUser.goals.containsKey(date)) {
            List<Goal> goals = LoginController.activeUser.goals.get(date);
            for (Goal goal : goals) {
                view.addGoalToList(goal.getId(), goal.getName());
            }
        }
    }


    public interface View {
        void clearGoalList();
        void addGoalToList(String id, String name);
    }
}
