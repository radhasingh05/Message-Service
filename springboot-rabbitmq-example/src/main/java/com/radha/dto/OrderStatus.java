package com.radha.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class OrderStatus {
    private Order order;
    private String status; // in-progress , completed
    private String message;
}
