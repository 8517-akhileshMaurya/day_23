package com.example.day23SpringBoot.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.nio.file.LinkOption;
import java.util.Scanner;
import java.util.Stack;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Employee")
public class EmployeeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "First_name")
    @NotBlank(message = "FirstName is mandatory")
    private String firstName;

    @Column(name = "Last_name")
    @NotBlank(message = "LastName is mandatory")
    private String lastName;

    @Column(name = "Emp_email")
    @NotBlank(message = "Email is mandatory")
    private String email;

    @Column(name = "Emp_department")
    private String department;

    @Column(name = "Emp_salary")
    @Min(value = 1, message = "Salary should not be less than 0")
    private int salary;
}
