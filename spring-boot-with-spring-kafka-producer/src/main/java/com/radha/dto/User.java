package com.radha.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class User {
    private String name;
    private String dept;
    private Long salary;
}
