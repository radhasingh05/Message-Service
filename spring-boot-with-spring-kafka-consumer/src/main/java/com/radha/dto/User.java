package com.radha.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class User {
    private String name;
    private String dept;
    private Long salary;
}
