package com.example.course_project_tot.Modele;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UserTest {

    @Test
    public void is_valid_test1(){
        User one = new User("abc", "1234567891012");
        assert one.isValid() == 1;
    }

    @Test
    public void is_valid_test2(){
        User empty = new User("", "1234567891012");
        assert empty.isValid() == 2;
    }

    @Test
    public void is_valid_test3() {
        User too_short = new User("abc@gmail.com", "123");
        assert too_short.isValid() == 3;
    }

    @Test
    public void is_valid_test4() {
        User wrong_email = new User("abc", "1234567891012");
        assert wrong_email.isValid() == -1;
    }
}