package qlttnn.model;

import qlttnn.dao.CourseClassDAO;

import java.time.LocalDate;
import java.util.ArrayList;

public class CourseClass {
    private int id;
    private String className;
    private int maxStudents;
    private LocalDate startDate;
    private ArrayList<Session> sessions;
    private Level level;
    private Branch branch;
    private String day;
    private String shiftDay;

    public CourseClass(int id, String className, int maxStudents, LocalDate startDate, Level level, Branch branch) {
        this.id = id;
        this.className = className;
        this.maxStudents = maxStudents;
        this.startDate = startDate;
        this.level = level;
        this.branch = branch;
    }

    public CourseClass(int id, String className, int maxStudents, LocalDate startDate, Level level, Branch branch, ArrayList<Session> sessions) {
        this.id = id;
        this.className = className;
        this.maxStudents = maxStudents;
        this.startDate = startDate;
        this.level = level;
        this.branch = branch;
        this.sessions = sessions;

    }


    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getShiftDay() {
        return shiftDay;
    }

    public void setShiftDay(String shiftDay) {
        this.shiftDay = shiftDay;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }


    public int getMaxStudents() {
        return maxStudents;
    }

    public void setMaxStudents(int maxStudents) {
        this.maxStudents = maxStudents;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public ArrayList<Session> getSessions() {
        return sessions;
    }

    public void setSessions(ArrayList<Session> sessions) {
        this.sessions = sessions;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }
}
