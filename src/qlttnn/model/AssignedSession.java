package qlttnn.model;

import java.time.LocalDate;

public class AssignedSession extends RegisteredSession{
    private LocalDate timeApproval;

    public AssignedSession(int registeredSessionId, double payRate, Session session, TeachingRegistration teachingRegistration, LocalDate timeApproval) {
        super(registeredSessionId, payRate, session, teachingRegistration);
        this.timeApproval = timeApproval;
    }

    public LocalDate getTimeApproval() {
        return timeApproval;
    }

    public void setTimeApproval(LocalDate timeApproval) {
        this.timeApproval = timeApproval;
    }
}
