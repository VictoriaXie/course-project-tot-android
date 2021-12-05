package com.example.course_project_tot;
import com.google.gson.Gson;
import com.jjoe64.graphview.series.DataPoint;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;


class GsonWriteList {

    public static void main(String[] args) throws IOException {

        String fileName = "src/main/resources/items.json";

        try (FileOutputStream fos = new FileOutputStream(fileName);
             OutputStreamWriter isr = new OutputStreamWriter(fos,
                     StandardCharsets.UTF_8)) {

            Gson gson = new Gson();

            DataPoint item1 = new DataPoint(0102, 4);
            DataPoint item2 = new DataPoint(0103, 5);
            DataPoint item3 = new DataPoint(0104, 1);

            List<DataPoint> items = new ArrayList<>();
            items.add(item1);
            items.add(item2);
            items.add(item3);

            gson.toJson(items, isr);
        }
    }
}