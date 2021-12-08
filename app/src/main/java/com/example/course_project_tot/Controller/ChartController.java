package com.example.course_project_tot.Controller;

import android.graphics.Canvas;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.BaseSeries;
import com.jjoe64.graphview.series.DataPointInterface;

import java.time.LocalDate;


public abstract class ChartController {
    private BaseSeries<DataPoint> series;

    public ChartController() {

        this.series = new BaseSeries<DataPoint>() {
            @Override
            public void drawSelection(GraphView mGraphView, Canvas canvas, boolean b, DataPointInterface value) {

            }

            @Override
            public void draw(GraphView graphView, Canvas canvas, boolean isSecondScale) {

            }
        };
    }
    public BaseSeries<DataPoint> getSeries(LocalDate date){
        return this.series;

    }



}

