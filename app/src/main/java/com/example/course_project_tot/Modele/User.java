package com.example.course_project_tot.Modele;

import android.text.TextUtils;
import android.util.Patterns;

import com.example.course_project_tot.Goal;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User implements IUser, Serializable {
    private final String email;
    private final String password;
    public Map<String, Goal> goalsById;
    /**
     * Setup the user's email, password and their goals.
     *
     */
    public User(String email, String password) {
        this.email = email;
        this.password = password;
        this.goalsById = new HashMap<>();
    }

    @Override
    public String getEmail() {

        return email;
    }

    @Override
    public String getPassword() { return password;
    }

    public List<Goal> getGoalsByDate(LocalDate date) {
        List<Goal> goals = new ArrayList<>();
        for (Goal goal : goalsById.values()) {
            if (goal.getDate().equals(date)) {
                goals.add(goal);
            }
        }
        return goals;
    }

    public void addGoal(Goal goal) {
        goalsById.put(goal.getId(), goal);
    }

    @Override
    public int isValid() {
        // 0. Check for Email Empty
        // 1. Check for Email Match pattern
        // 2. Check for Password > 12
        if (TextUtils.isEmpty(getEmail()))
            return 0;
        else if (!Patterns.EMAIL_ADDRESS.matcher(getEmail()).matches())
            return 1;
        else if (TextUtils.isEmpty(getPassword()))
            return 2;
        else if (getPassword().length() <= 12)
            return 3;
        else
            return -1;
    }
}
