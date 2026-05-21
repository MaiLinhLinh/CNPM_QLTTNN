package qlttnn.model;

public class RegisteredSession {
    private int id;
    private double payRate;
    private Session session;
    private TeachingRegistration teachingRegistration;

    public RegisteredSession(int id, double payRate, Session session, TeachingRegistration teachingRegistration) {
        this.id = id;
        this.payRate = payRate;
        this.session = session;
        this.teachingRegistration = teachingRegistration;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPayRate() {
        return payRate;
    }

    public void setPayRate(double payRate) {
        this.payRate = payRate;
    }

    public TeachingRegistration getTeachingRegistration() {
        return teachingRegistration;
    }

    public void setTeachingRegistration(TeachingRegistration teachingRegistration) {
        this.teachingRegistration = teachingRegistration;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }
}
