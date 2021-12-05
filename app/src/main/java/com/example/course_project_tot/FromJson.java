package com.example.course_project_tot;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

class User {

    private final String firstName;
    private final String lastName;

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

public class FromJSon {
    public void main(String[] args) throws IOException {

        Gson gson = new GsonBuilder().create();

        String fileName = "src/main/resources/users.json";
        Path path = new File(fileName).toPath();

        try (Reader reader = Files.newBufferedReader(path,
                StandardCharsets.UTF_8)) {

            User[] users = gson.fromJson(reader, User[].class);

            Arrays.stream(users).forEach(e -> {
                System.out.println(e);
            });
        }
    }

}}
