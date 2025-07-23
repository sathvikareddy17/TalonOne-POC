package com.example.orderservice.dto;

public class UserResponseDTO {
    private Long id;
    private String name;
    private String email;
    private String phone;
    private Integer totalOrders;
    private Double totalSpent;

    // Getters and setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public Integer getTotalOrders() {
        return totalOrders;
    }
    public void setTotalOrders(Integer totalOrders) {
        this.totalOrders = totalOrders;
    }
    public Double getTotalSpent() {
        return totalSpent;
    }
    public void setTotalSpent(Double totalSpent) {
        this.totalSpent = totalSpent;
    }
}
