package qlttnn.model;

public class RegisteredClass {
    private int id;
    private double tuition;
    private CourseClass courseClass;


    public RegisteredClass(CourseClass courseClass, double tuition) {
        this.tuition = tuition;
        this.courseClass = courseClass;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getTuition() {
        return tuition;
    }

    public void setTuition(double tuition) {
        this.tuition = tuition;
    }


    public CourseClass getCourseClass() {
        return courseClass;
    }

    public void setCourseClass(CourseClass courseClass) {
        this.courseClass = courseClass;
    }
}
