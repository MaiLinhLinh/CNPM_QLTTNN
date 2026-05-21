package qlttnn.model;

public class ClassRoom {
    private int id;
    private int capacity;
    private String roomName;
    private Branch branch;

    public ClassRoom(int capacity, String roomName) {
        this.capacity = capacity;
        this.roomName = roomName;
    }

    public ClassRoom(int id, int capacity, String roomName, Branch branch) {
        this.id = id;
        this.capacity = capacity;
        this.roomName = roomName;
        this.branch = branch;
    }

    public ClassRoom() {
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }
}
