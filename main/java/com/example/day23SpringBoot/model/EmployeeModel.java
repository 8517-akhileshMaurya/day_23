package com.example.day23SpringBoot.model;

import jakarta.persistence.*;
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
    private String firstName;

    @Column(name = "Last_name")
    private String lastName;

    @Column(name = "Emp_email")
    private String email;

    @Column(name = "Emp_department")
    private String department;

    @Column(name = "Emp_salary")
    private int salary;
}
