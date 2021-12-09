package com.example.course_project_tot.Activity;

import junit.framework.TestCase;

import com.google.gson.Gson;
import com.jjoe64.graphview.series.DataPoint;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.junit.Before;

public class ChartActivityTest extends TestCase {
    List<DataPoint> items;
    @Before
    public void main() throws IOException {

        String fileName = "src/main/resources/items.json";

        try (FileOutputStream fos = new FileOutputStream(fileName);
             OutputStreamWriter isr = new OutputStreamWriter(fos,
                     StandardCharsets.UTF_8)) {

            Gson gson = new Gson();

            DataPoint item1 = new DataPoint(66, 4);
            DataPoint item2 = new DataPoint(67, 5);
            DataPoint item3 = new DataPoint(68, 1);

            this.items.add(item1);
            this.items.add(item2);
            this.items.add(item3);

            gson.toJson(items, isr);
        }
    }

}
