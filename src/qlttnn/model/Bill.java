package qlttnn.model;

import java.time.LocalDateTime;

public class Bill {
    private int id;
    private LocalDateTime createdAt;
    private double payedAmount;
    private String paymentType;
    private User user;
    private Registering registering;

    public Bill(LocalDateTime createdAt, double payedAmount, String paymentType, Registering registering) {
        this.createdAt = createdAt;
        this.payedAmount = payedAmount;
        this.paymentType = paymentType;
        this.registering = registering;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public double getPayedAmount() {
        return payedAmount;
    }

    public void setPayedAmount(double payedAmount) {
        this.payedAmount = payedAmount;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Registering getRegistering() {
        return registering;
    }

    public void setRegistering(Registering registering) {
        this.registering = registering;
    }
}
