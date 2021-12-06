package com.example.course_project_tot.Modele;


import android.os.Environment;
import com.google.gson.stream.JsonReader;
import com.google.gson.Gson;
import com.google.gson.stream.JsonWriter;

import java.io.*;

public class UserReadWriter implements ReadWriter {
    public static final String DEFAULT_FILE_NAME = "user.json";


    /**
     * Writes the users to file at filePath.
     *
     * @param filePath the file to write the records to
     * @param users stores the list of users to be serialized
     * @throws IOException
     */
    @Override
    public void saveToFile(File filePath, Object users) throws IOException {
        Gson gson = new Gson();
        JsonWriter writer = new JsonWriter(new FileWriter(filePath));
        gson.toJson(users, UserList.class, writer);
        writer.flush();
        writer.close();
    }


    /**
     * Read the users to file at filePath.
     *
     * @param filePath file where the user list is stored
     * @return UserList
     * @throws IOException
     */
    @Override
    public UserList readFromFile(File filePath) throws IOException {
        Gson gson = new Gson();
        JsonReader reader = new JsonReader(new FileReader(filePath));
        return gson.fromJson(reader, UserList.class);

    }
}