package com.example.course_project_tot.Activity;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.course_project_tot.Controller.ILoginController;
import com.example.course_project_tot.Controller.LoginController;
import com.example.course_project_tot.R;
import com.example.course_project_tot.View.ILoginView;

public class UserloginActivity extends AppCompatActivity  implements ILoginView {
    EditText email,password;
    Button loginb;
    ILoginController loginPresenter;

    /**
     * Setup the view and display on android app for User login part.
     *
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email = (EditText) findViewById(R.id.email);
        password = (EditText)findViewById(R.id.password);
        loginb = (Button) findViewById(R.id.loginb);
        loginPresenter = new LoginController(this);
        loginb.setOnClickListener(new View.OnClickListener() {
            /**
             * On click listener for "login" button and then it will check whether the username and
             * password are valid or not.
             * @param v Object that triggered the event.
             */
            @Override
            public void onClick(View v) {
                loginPresenter.OnLogin(email.getText().toString().trim(),password.getText().toString().trim());
            }
        });
    }

    /**
     * Display a success message and moves to the create goal activity.
     * @param message
     */
    @Override
    public void OnLoginSuccess(String message) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, CalendarActivity.class);
        startActivity(intent);
    }
    @Override
    public void OnLoginError(String message) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }
}
