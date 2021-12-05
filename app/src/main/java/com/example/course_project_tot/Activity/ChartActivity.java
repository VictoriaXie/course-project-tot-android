package com.example.course_project_tot.Activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.course_project_tot.DataMap;
import com.example.course_project_tot.FromJSon;
import com.example.course_project_tot.R;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;


public class ChartActivity extends AppCompatActivity {

    // creating a variable
    // for our graph view.
    GraphView graphView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        graphView = findViewById(R.id.idGraphView);
        for (DataMap d : FromJSon.returnFromJson()) {
            System.out.println(d);
        }
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[]{
                // on below line we are adding
                // each point on our x and y axis.
                new DataPoint(0, 1),
                new DataPoint(1, 3),
                new DataPoint(2, 4),
                new DataPoint(3, 9),
                new DataPoint(4, 6),
                new DataPoint(5, 3),
                new DataPoint(6, 6),
                new DataPoint(7, 1),
                new DataPoint(8, 2)
        });

        graphView.setTitle("My Graph View");


        graphView.setTitleColor(R.color.purple_200);


        graphView.setTitleTextSize(18);

        // on below line we are adding
        // data series to our graph view.
        graphView.addSeries(series);
    }
}