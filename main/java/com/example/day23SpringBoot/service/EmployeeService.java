package com.example.day23SpringBoot.service;

import com.example.day23SpringBoot.Exception.ResourceNotFoundException;
import com.example.day23SpringBoot.model.EmployeeModel;
import com.example.day23SpringBoot.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    public EmployeeRepository repository;

    public EmployeeModel createEmployee(EmployeeModel employeeModel){
         return repository.save(employeeModel);
    }

    public List<EmployeeModel> getAllEmployees(){
        return repository.findAll();
    }

    public EmployeeModel updateEmployee(Long id , EmployeeModel model){
  EmployeeModel employeeModel = repository.findById(id)
          .orElseThrow(()->new ResourceNotFoundException("Employee not found"));

  employeeModel.setFirstName(model.getFirstName());
  employeeModel.setLastName(model.getLastName());
  employeeModel.setEmail(model.getEmail());
  employeeModel.setDepartment(model.getDepartment());
  employeeModel.setSalary(model.getSalary());

  return repository.save(employeeModel);

    }

    public void deleteEmployee(Long id , EmployeeModel model){
        EmployeeModel employeeModel = repository.findById(id).orElseThrow(() -> new
                ResourceNotFoundException("Employee not found"));

        repository.delete(employeeModel);
    }

    public Optional<EmployeeModel> getEmployeeById(Long id){
     return repository.findById(id);
    }
}
