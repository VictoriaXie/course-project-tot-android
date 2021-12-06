package com.example.course_project_tot.View;

import java.io.File;

public interface ILoginView {
    void OnLoginSuccess(String message);
    void OnLoginError(String message);
    File getFilesDir();
}
