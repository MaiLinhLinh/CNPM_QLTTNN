package qlttnn.model;

import java.util.ArrayList;
import java.util.Random;

public class Level {
    private int id;
    private String levelName;
    private double entryLevel;
    private double targetLevel;
    private double payRate;
    private int totalSessions;
    private double tuition;
    private ArrayList<CourseClass> courseClasses;
    private Program program;

    public Level(String levelName, double entryLevel, double targetLevel, double payRate, int totalSessions, double tuition, Program program) {
        this.levelName = levelName;
        this.entryLevel = entryLevel;
        this.targetLevel = targetLevel;
        this.payRate = payRate;
        this.totalSessions = totalSessions;
        this.tuition = tuition;
        this.program = program;
    }

    public Level(int id, String levelName, double entryLevel, double targetLevel, double payRate, int totalSessions, double tuition, Program program) {
        this.id = id;
        this.levelName = levelName;
        this.entryLevel = entryLevel;
        this.targetLevel = targetLevel;
        this.payRate = payRate;
        this.totalSessions = totalSessions;
        this.tuition = tuition;
        this.program = program;
    }

    public Level() {
    }

    public Level(int id, String levelName, Program program) {
        this.id = id;
        this.levelName = levelName;
        this.program = program;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public double getEntryLevel() {
        return entryLevel;
    }

    public void setEntryLevel(double entryLevel) {
        this.entryLevel = entryLevel;
    }

    public double getTargetLevel() {
        return targetLevel;
    }

    public void setTargetLevel(double targetLevel) {
        this.targetLevel = targetLevel;
    }

    public double getPayRate() {
        return payRate;
    }

    public void setPayRate(double payRate) {
        this.payRate = payRate;
    }

    public int getTotalSessions() {
        return totalSessions;
    }

    public void setTotalSessions(int totalSessions) {
        this.totalSessions = totalSessions;
    }

    public double getTuition() {
        return tuition;
    }

    public void setTuition(double tuition) {
        this.tuition = tuition;
    }

    public ArrayList<CourseClass> getCourseClasses() {
        return courseClasses;
    }

    public void setCourseClasses(ArrayList<CourseClass> courseClasses) {
        this.courseClasses = courseClasses;
    }

    public Program getProgram() {
        return program;
    }

    public void setProgram(Program program) {
        this.program = program;
    }
}
