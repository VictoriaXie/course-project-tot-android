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
    public LineGraphSeries<DataPoint> getSeries(LocalDate date){
        User user = UserList.getInstance().getCurrentUser();
        for(int day =0; day < 31; day++){

            int time = 0;
            if(! user.getGoalsByDate(date).isEmpty()) {
                for(int i = 0; i < user.getGoalsByDate(date).size(); i++){
                    time += user.getGoalsByDate(date).get(i).getTimeRequired();
                }
            }
            DataPoint point = new DataPoint(day,time);
            this.series.appendData(point, true, 30);
            date = date.plusDays(1);
        }

        return this.series;
    }



}

