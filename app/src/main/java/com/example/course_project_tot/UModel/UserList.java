package com.example.course_project_tot.UModel;

import java.io.Serializable;
import java.util.HashMap;
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
}

