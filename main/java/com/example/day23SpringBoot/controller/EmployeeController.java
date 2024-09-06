package com.example.day23SpringBoot.controller;

import com.example.day23SpringBoot.model.EmployeeModel;
import com.example.day23SpringBoot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Employee")
public class EmployeeController {

    @Autowired
    public EmployeeService service;

    @PostMapping("/addEmployee")
    public EmployeeModel createEmployee(@RequestBody EmployeeModel employeeModel){
        return service.createEmployee(employeeModel);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeModel> getEmployeeById(@PathVariable Long id){
        Optional<EmployeeModel> employeeModel = service.getEmployeeById(id);
        return employeeModel.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }

    @GetMapping("/AllEmployee")
    public List<EmployeeModel> getAllEmployees() {
        return service.getAllEmployees();
    }
}
