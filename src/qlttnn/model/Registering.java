package qlttnn.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Registering {
    private int id;
    private LocalDate registeringDate;
    private double saleOff;
    private double totalTuition;
    private double finalTuition;
    private ArrayList<RegisteredClass> registeredClasses;
    private Student student;
    private User user;

    public Registering() {
        this.registeredClasses = new ArrayList<>();
        this.totalTuition = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getRegisteringDate() {
        return registeringDate;
    }

    public void setRegisteringDate(LocalDate registeringDate) {
        this.registeringDate = registeringDate;
    }

    public double getSaleOff() {
        return saleOff;
    }

    public void setSaleOff(double saleOff) {
        this.saleOff = saleOff;
    }

    public double getTotalTuition() {
        return totalTuition;
    }

    public void setTotalTuition(double totalTuition) {
        this.totalTuition = totalTuition;
    }

    public ArrayList<RegisteredClass> getRegisteredClasses() {
        return registeredClasses;
    }

    public void setRegisteredClasses(RegisteredClass registeredClass) {
        this.registeredClasses.add(registeredClass);
        updateTuitionAndDiscount();
    }
    private void updateTuitionAndDiscount() {
        int count = this.registeredClasses.size();

        // 1. Xác định mức giảm giá (%)
        double discountPercent = 0;
        if (count == 2) {
            discountPercent = 0.1; // Giảm 10%
        } else if (count >= 3) {
            discountPercent = 0.3; // Giảm 30%
        }

        // 2. Tính tổng tiền gốc (chưa giảm)
        totalTuition = 0;
        for (RegisteredClass rc : registeredClasses) {
            totalTuition += rc.getTuition();
        }

        // Tính số tiền được giảm (saleOff)
        this.saleOff = totalTuition * discountPercent;

        // Tính tổng tiền cuối cùng sau khi giảm
        this.finalTuition = totalTuition - this.saleOff;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getFinalTuition() {
        return finalTuition;
    }

    public void setFinalTuition(double finalTuition) {
        this.finalTuition = finalTuition;
    }

}
