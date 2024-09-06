package com.example.day23SpringBoot.repository;

import com.example.day23SpringBoot.model.EmployeeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeModel , Long> {

}
