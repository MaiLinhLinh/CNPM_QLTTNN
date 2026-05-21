package qlttnn.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Student {
    private int id;
    private String fullName;
    private String idCard;
    private String phone;
    private LocalDate dateOfBirth;
    private String email;
    private String address;

    public Student(String fullName, String idCard, String phone, LocalDate dateOfBirth, String email, String address) {
        this.fullName = fullName;
        this.idCard = idCard;
        this.phone = phone;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.address = address;
    }

    public Student(int id, String fullName, String idCard, String phone, LocalDate dateOfBirth, String email, String address) {
        this.id = id;
        this.fullName = fullName;
        this.idCard = idCard;
        this.phone = phone;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
