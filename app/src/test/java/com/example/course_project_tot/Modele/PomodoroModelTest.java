package com.example.course_project_tot.Modele;

import org.junit.Test;

public class PomodoroModelTest {

    @Test
    public void testGetFocusingTime(){
        PomodoroModel pom = new PomodoroModel(60);
        PomodoroModel pom2 = new PomodoroModel(40, 10, 60);
        assert pom.getFocusingTime() == 25;
        assert pom2.getFocusingTime() == 40;

    }

    @Test
    public void testGetRestingTime(){
        PomodoroModel pom = new PomodoroModel(60);
        PomodoroModel pom2 = new PomodoroModel(40, 10, 60);
        assert pom.getRestingTime() == 5;
        assert pom2.getRestingTime() == 10;
    }
}