package com.example.course_project_tot.Modele;

import org.junit.Test;

public class PomodoroModelTest {

    @Test
    public void testTurnOn() {
        PomodoroModel pom = new PomodoroModel(60);
        pom.turnOn();
        assert pom.getStatus();
    }

    @Test
    public void testTurnOff() {
        PomodoroModel pom = new PomodoroModel(60);
        pom.turnOff();
        assert !pom.getStatus();
    }

    @Test
    public void testGetTotalTime(){
        PomodoroModel pom = new PomodoroModel(60);
        assert pom.getTotalTime() == 60;
    }

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