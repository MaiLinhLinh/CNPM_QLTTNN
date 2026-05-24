package qlttnn.model;

import qlttnn.dao.CourseClassDAO;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

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

    public void updateScheduleInfo() {
        this.day = getDaysOfWeekFromSessions();
        this.shiftDay = getShiftsFromSessions();
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

    /**
     * Lấy 3 ngày học liên tiếp (2-4-6 hoặc 3-5-7)
     */
    private String getDaysOfWeekFromSessions(){
        ArrayList<Integer> dayOfWeeks = new ArrayList<>();
        String [] daysName = {"", "CN", "2", "3", "4", "5", "6", "7"};
        try{
            ArrayList<Session> sessions = this.getSessions();
            if(sessions != null && !sessions.isEmpty()){
                for(Session session: sessions){
                    DayOfWeek day = session.getDate().getDayOfWeek();
                    int date = day.getValue() + 1;
                    if(date >= 2 && date <= 7){
                        if(!dayOfWeeks.contains(date)){
                            dayOfWeeks.add(date);
                        }
                    }
                    if(dayOfWeeks.size() >= 3){
                        Collections.sort(dayOfWeeks);
                        StringBuilder result = new StringBuilder();
                        for(int i = 0; i < 3; i++){
                            result.append(daysName[dayOfWeeks.get(i)]);
                            if(i != 2)
                                result.append("-");
                        }
                        return result.toString();
                    }
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return "N/A";
    }

    /**
     * Lấy 1 ca học (Sáng, Chiều hoặc Tối)
     */
    private String getShiftsFromSessions() {

        try {
            ArrayList<Session> sessions = this.getSessions();
            if (sessions != null && !sessions.isEmpty()) {
                String shiftName = sessions.get(0).getShift().getShiftName();
                return shiftName;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "N/A";
    }
}
