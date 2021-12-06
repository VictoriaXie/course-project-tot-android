package com.example.course_project_tot.Modele;


public class PomodoroModel {
    private final int focusingTime;
    private final int restingTime;
    private final int totalTime;
    private boolean mTimerRunning;

    /**
     * Construct the PomodoroModel
     * @param focusingTime time in minutes that the user want to focus for a cycle, with default 25 minutes.
     * @param restingTime time in minutes that the user want to rest for a cycle, with default 5 minutes.
     * @param totalTime total time in minutes that the user assign for this goal.
     */

    public PomodoroModel(int focusingTime, int restingTime, int totalTime) {
        this.focusingTime = focusingTime;
        this.restingTime = restingTime;
        this.totalTime = totalTime;
    }

    public PomodoroModel(int totalTime){
        this.focusingTime = 25;
        this.restingTime = 5;
        this.totalTime = totalTime;
    }

    /**
     * @return the focusing time that the user sets
     */
    public int getFocusingTime(){return this.focusingTime;}

    /**
     * @return the resting time that the user sets
     */
    public int getRestingTime(){return this.restingTime;}

    /**
     * @return the total time that the user sets
     */
    public int getTotalTime(){return this.totalTime;}
    /**
     * Turn on the Pomodoro Timer.
     */
    public void turnOn(){
        mTimerRunning = true;
    }

    /**
     * Turn off the Pomodoro Timer.
     */

    public void turnOff(){
        mTimerRunning = false;
    }

    /**
     * Return the status of the Pomodoro Timer (Whether it's running or not).
     @return True if the timer is running.
     */
    public boolean getStatus(){
        return mTimerRunning;
    }


}