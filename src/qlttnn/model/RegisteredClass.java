package qlttnn.model;

public class RegisteredClass {
    private int id;
    private double tuition;
    private double saleOff;
    private double finalTuition;
    private CourseClass courseClass;

    public RegisteredClass(int id, CourseClass courseClass, double tuition, double saleOff) {
        this.id = id;
        this.courseClass = courseClass;
        this.tuition = tuition;
        this.saleOff = saleOff;
        this.finalTuition = this.tuition - this.saleOff;
    }
    public double getFinalTuition(){
        return finalTuition;
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

    public double getSaleOff() {
        return saleOff;
    }

    public void setSaleOff(double saleOff) {
        this.saleOff = saleOff;
    }

    public CourseClass getCourseClass() {
        return courseClass;
    }

    public void setCourseClass(CourseClass courseClass) {
        this.courseClass = courseClass;
    }
}
