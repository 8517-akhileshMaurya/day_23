package com.example.day23SpringBoot.controller;

import com.example.day23SpringBoot.Exception.ResourceNotFoundException;
import com.example.day23SpringBoot.model.EmployeeModel;
import com.example.day23SpringBoot.repository.EmployeeRepository;
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

    @Autowired
    public EmployeeRepository repository;

    @PostMapping("/addEmployee")
    public EmployeeModel createEmployee(@RequestBody EmployeeModel employeeModel){
        return service.createEmployee(employeeModel);
    }

    @PutMapping("/Emp/{id}")
    public ResponseEntity<EmployeeModel> updateEmployee(@PathVariable Long id, @RequestBody EmployeeModel employeeDetails) {
        EmployeeModel employee = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));


        employee.setFirstName(employeeDetails.getFirstName());
        employee.setLastName(employeeDetails.getLastName());
        employee.setEmail(employeeDetails.getEmail());
        employee.setDepartment(employeeDetails.getDepartment());
        employee.setSalary(employeeDetails.getSalary());


        EmployeeModel updatedEmployee = repository.save(employee);
        return ResponseEntity.ok(updatedEmployee);
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
