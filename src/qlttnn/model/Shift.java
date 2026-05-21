package qlttnn.model;

import java.time.LocalTime;
import java.util.Objects;

public class Shift {
    private int id;
    private String shiftName;
    private LocalTime startTime;
    private LocalTime endTime;

    public Shift(int id, String shiftName, LocalTime startTime, LocalTime endTime) {
        this.id = id;
        this.shiftName = shiftName;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Shift() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getShiftName() {
        return shiftName;
    }

    public void setShiftName(String shiftName) {
        this.shiftName = shiftName;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Shift shift)) return false;
        return id == shift.id && Objects.equals(shiftName, shift.shiftName) && Objects.equals(startTime, shift.startTime) && Objects.equals(endTime, shift.endTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, shiftName, startTime, endTime);
    }
}
