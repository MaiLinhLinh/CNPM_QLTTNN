package qlttnn.model;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Objects;

public class Session {
    private int id;
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

    public Session(int id, String skill, LocalDateTime date, Shift shift, ClassRoom classRoom) {
        this.id = id;
        this.skill = skill;
        this.date = date;
        this.shift = shift;
        this.classRoom = classRoom;
    }

    public Session() {
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Session session)) return false;
        return Objects.equals(date, session.date) && Objects.equals(shift, session.shift);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, shift);
    }

}
