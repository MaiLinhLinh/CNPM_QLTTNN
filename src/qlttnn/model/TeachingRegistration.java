package qlttnn.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class TeachingRegistration {
    private int id;
    private int totalSessions;
    private User teacher;
    private ArrayList<RegisteredSession> registeredSessions;
    private LocalDate registeringDate;

    public TeachingRegistration(int id, LocalDate registeringDate, int totalSessions, User teacher, ArrayList<RegisteredSession> registeredSessions) {
        this.id = id;
        this.totalSessions = totalSessions;
        this.teacher = teacher;
        this.registeredSessions = registeredSessions;
        this.registeringDate = registeringDate;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTotalSessions() {
        return totalSessions;
    }

    public void setTotalSessions(int totalSessions) {
        this.totalSessions = totalSessions;
    }

    public User getTeacher() {
        return teacher;
    }

    public void setTeacher(User teacher) {
        this.teacher = teacher;
    }

    public ArrayList<RegisteredSession> getRegisteredSessions() {
        return registeredSessions;
    }

    public void setRegisteredSessions(ArrayList<RegisteredSession> registeredSessions) {
        this.registeredSessions = registeredSessions;
    }
}
