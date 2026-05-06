package qlttnn.model;

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

    public CourseClass(String className, int maxStudents, LocalDate startDate, Level level, Branch branch) {
        this.className = className;
        this.maxStudents = maxStudents;
        this.startDate = startDate;
        this.level = level;
        this.branch = branch;
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
