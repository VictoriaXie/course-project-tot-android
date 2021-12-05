package com.example.course_project_tot;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class FromJSon {
    public static DataMap[] returnFromJson() {

        Gson gson = new GsonBuilder().create();

        String fileName = "src/main/resources/users.json";
        Path path = new File(fileName).toPath();

        try (Reader reader = Files.newBufferedReader(path,
                StandardCharsets.UTF_8)) {

            return gson.fromJson(reader, DataMap[].class);

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
