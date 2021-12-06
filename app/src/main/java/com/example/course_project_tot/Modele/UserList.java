package com.example.course_project_tot.Modele;

import com.google.gson.Gson;
import com.jjoe64.graphview.series.DataPoint;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserList implements Serializable {
    private final Map<String, User> users = new HashMap<>();

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
}
