package qlttnn.model;

public class RegisteredSession {
    private int id;
    private String status;
    private Session session;

    public RegisteredSession(int id, String status, Session session) {
        this.id = id;
        this.status = status;
        this.session = session;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }
}
