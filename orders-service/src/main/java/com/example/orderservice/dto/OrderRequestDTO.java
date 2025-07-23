package com.example.orderservice.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

public class OrderRequestDTO {
    @NotNull
    private Long userId;

    @NotEmpty
    private List<String> cartItems;

    @NotNull
    private BigDecimal totalAmount;

    // Getters and setters
    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public List<String> getCartItems() {
        return cartItems;
    }
    public void setCartItems(List<String> cartItems) {
        this.cartItems = cartItems;
    }
    public BigDecimal getTotalAmount() {
        return totalAmount;
    }
    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }
}
