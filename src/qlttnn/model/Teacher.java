package qlttnn.model;

import java.util.Date;

public class Teacher extends User{
    private int id;

    public Teacher(String username, String password) {
        super(username, password);
    }

    public Teacher(int id, String username, String password, String fullName, Date dateOfBirth, String phone, String address, String role, int id1) {
        super(id, username, password, fullName, dateOfBirth, phone, address, role);
        this.id = id1;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }
}
