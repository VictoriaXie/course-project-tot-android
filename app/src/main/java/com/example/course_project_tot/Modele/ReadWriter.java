package com.example.course_project_tot.Modele;

import java.io.File;
import java.io.IOException;

public interface ReadWriter {
    /**
     * @param filepath location of ser file
     * @param o object to be serialized
     */
    void saveToFile(File filepath, Object o) throws IOException;

    /**
     * @param filepath location of ser file
     */
    UserList readFromFile(File filepath) throws IOException, ClassNotFoundException;
}