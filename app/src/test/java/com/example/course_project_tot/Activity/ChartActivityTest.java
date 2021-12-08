package com.example.course_project_tot.Activity;

import junit.framework.TestCase;

import com.google.gson.Gson;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class ChartActivityTest extends TestCase {
    List<DataPoint> items;
    @Before
    public void main(String[] args) throws IOException {

        String fileName = "src/main/resources/items.json";

        try (FileOutputStream fos = new FileOutputStream(fileName);
             OutputStreamWriter isr = new OutputStreamWriter(fos,
                     StandardCharsets.UTF_8)) {

            Gson gson = new Gson();

            DataPoint item1 = new DataPoint(0102, 4);
            DataPoint item2 = new DataPoint(0103, 5);
            DataPoint item3 = new DataPoint(0104, 1);

            this.items.add(item1);
            this.items.add(item2);
            this.items.add(item3);

            gson.toJson(items, isr);
        }
    }

    @Test
    void getChartActivity() {
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>();
        for (DataPoint d : FromJSon.returnFromJson()) {
            series.appendData(d, true, 30);
        }
        assertEquals(this.items, series);
    }
}
