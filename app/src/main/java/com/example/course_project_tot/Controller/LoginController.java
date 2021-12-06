package com.example.course_project_tot.Controller;

import com.example.course_project_tot.Modele.User;
import com.example.course_project_tot.Modele.UserList;
import com.example.course_project_tot.Modele.UserReadWriter;
import com.example.course_project_tot.View.ILoginView;

import java.io.File;
import java.io.IOException;

public class LoginController implements ILoginController {
    ILoginView loginView;
    UserList userList;
    public static User activeUser;

    public LoginController(ILoginView loginView){
        this.loginView = loginView;
        File dir = new File(loginView.getFilesDir(), UserReadWriter.DEFAULT_FILE_NAME);
        UserReadWriter userReadWriter = new UserReadWriter();
        if (dir.isFile()) {
            try {
                // Reads list of users from file
                userList = userReadWriter.readFromFile(dir);
            } catch (IOException e) {
                // Should never happen, already checked if file exists
                throw new RuntimeException(e);
            }
        } else {
            userList = new UserList();
        }
    }

    @Override
    public void OnLogin(String email, String password) {
        if (userList.contains(email)) {
            User user = userList.getUser(email);
            if (user.getPassword().equals(password)) {
                loginView.OnLoginSuccess("Successfully logged in.");
                activeUser = user;
            } else {
                loginView.OnLoginError("Incorrect password.");
            }
        } else {
            User user = new User(email, password);
            int loginCode = user.isValid();
            if (loginCode == 0) {
                loginView.OnLoginError("Please enter Email");
            } else if (loginCode == 1) {
                loginView.OnLoginError("Please enter A valid Email");
            } else if (loginCode == 2) {
                loginView.OnLoginError("Please enter Password");
            } else if (loginCode == 3) {
                loginView.OnLoginError("Please enter Password greater the 12 char");
            } else {
                loginView.OnLoginSuccess("Registration Successful");
                activeUser = user;
                userList.add(user);
                try {
                    File dir = new File(loginView.getFilesDir(), UserReadWriter.DEFAULT_FILE_NAME);
                    UserReadWriter userReadWriter = new UserReadWriter();
                    userReadWriter.saveToFile(dir, userList);
                } catch (IOException e) {
                    // Should never happen
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
