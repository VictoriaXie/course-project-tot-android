package com.example.course_project_tot.Controller;

import android.view.View;

import com.example.course_project_tot.Modele.User;
import com.example.course_project_tot.Modele.UserList;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import java.time.LocalDate;


public class ChartController {
    private LineGraphSeries<DataPoint> series;

    public ChartController() {
        this.series = new LineGraphSeries<>();
    }
    public LineGraphSeries<DataPoint> getSeries(){
        User user = UserList.getInstance().getCurrentUser();
        for(LocalDate date = LocalDate.of(2021, 01, 01);
            date.isBefore(LocalDate.of(2022, 01, 01));
            date = date.plusDays(1)){
            int a = date.getDayOfMonth();int b = date.getMonthValue();
            int value = 100*a + b;
            int time = 0;
            if(! user.getGoalsByDate(date).isEmpty()) {
                for(int i = 0; i < user.getGoalsByDate(date).size(); i++){
                    time += user.getGoalsByDate(date).get(i).getTimeRequired();
                }
            }

            DataPoint point = new DataPoint(value,time);
            this.series.appendData(point, false, 24);
        }

        return this.series;
    }



}

