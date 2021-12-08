package com.example.course_project_tot.Activity;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.course_project_tot.Controller.ChartController;
import com.example.course_project_tot.R;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;


public class ChartActivity extends AppCompatActivity {
    private Button find;
    // creating a variable
    // for our graph view.
    GraphView graphView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);

        graphView = findViewById(R.id.idGraphView);


        graphView.setTitle("2021 Accomplishment Line Chart");


        graphView.setTitleColor(R.color.purple_200);


        graphView.setTitleTextSize(70);

        // on below line we are adding
        // data series to our graph view.
        ChartController series = new ChartController();
        graphView.addSeries(series.getSeries());

     }

}