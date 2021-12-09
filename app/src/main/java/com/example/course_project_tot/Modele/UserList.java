package com.example.course_project_tot.Modele;

import com.google.gson.*;
import com.google.gson.annotations.Expose;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class UserList {
    private static UserList instance;

    private static File file;

    @Expose private static Map<String, User> users;
    private static User currentUser;


    private UserList() {
        users = new HashMap<>();
    }

    public static UserList getInstance() {
        if (instance == null) {
            instance = new UserList();
        }
        return instance;
    }

    public static void readFromFile() {
        if (file.exists()) { // Reads users from file if it exists
            try {
                Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
                        .create();
                JsonReader reader = new JsonReader(new FileReader(file));
                Type type = new TypeToken<Map<String, User>>() {}.getType(); // Makes sure json is deserialized as a map with User and not generic objects
                users = gson.fromJson(reader, type);
            } catch (IOException e) {
                // Should never happen, we already checked the file exists
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * Add user to this user list.
     *
     * @param user the user to add
     */
    public void add(User user) {
        users.put(user.getEmail(), user);
    }

    /**
     * Return the User associated with username.
     *
     * @param  email email of the user to get.
     */
    public User getUser(String email) {
        return users.get(email);
    }

    public boolean contains(String email) {
        return users.containsKey(email);
    }

    public void setCurrentUser(User user) {
        currentUser = user;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setFile(File file) {
        UserList.file = file;
    }

    public void writeToFile() {
        try {
            Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
                    .create();
            JsonWriter writer = new JsonWriter(new FileWriter(file));

            gson.toJson(users, Map.class, writer);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            // Should also never happen, file path should always be valid
            throw new RuntimeException(e);
        }
    }
}

class LocalDateAdapter extends TypeAdapter<LocalDate> {
    @Override
    public void write( final JsonWriter jsonWriter, final LocalDate localDate ) throws IOException {
        jsonWriter.value(localDate.toString());
    }

    @Override
    public LocalDate read( final JsonReader jsonReader ) throws IOException {
        return LocalDate.parse(jsonReader.nextString());
    }
}