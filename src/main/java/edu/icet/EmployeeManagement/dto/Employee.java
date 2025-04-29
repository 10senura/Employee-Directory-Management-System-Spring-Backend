package edu.icet.EmployeeManagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Employee {
    private Long id;

    private String name;
    private String email;
    private String department;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
