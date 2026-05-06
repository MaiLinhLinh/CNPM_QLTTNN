package qlttnn.model;

import java.util.ArrayList;

public class Branch {
    private int id;
    private String branchName;
    private String address;
    private ArrayList<ClassRoom> classRooms;

    public Branch(String branchName, String address) {
        this.branchName = branchName;
        this.address = address;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ArrayList<ClassRoom> getClassRoom() {
        return classRooms;
    }

    public void setClassRoom(ArrayList<ClassRoom> classRooms) {
        this.classRooms = classRooms;
    }
}
