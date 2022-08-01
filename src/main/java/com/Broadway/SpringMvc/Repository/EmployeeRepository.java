package com.Broadway.SpringMvc.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Broadway.SpringMvc.Model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
