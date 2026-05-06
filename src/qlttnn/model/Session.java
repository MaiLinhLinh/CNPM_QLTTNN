package qlttnn.model;

import java.time.LocalDateTime;

public class Session {
    private String skill;
    private LocalDateTime date;
    private Shift shift;
    private ClassRoom classRoom;

    public Session(String skill, LocalDateTime date, Shift shift, ClassRoom classRoom) {
        this.skill = skill;
        this.date = date;
        this.shift = shift;
        this.classRoom = classRoom;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Shift getShift() {
        return shift;
    }

    public void setShift(Shift shift) {
        this.shift = shift;
    }

    public ClassRoom getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(ClassRoom classRoom) {
        this.classRoom = classRoom;
    }
}
