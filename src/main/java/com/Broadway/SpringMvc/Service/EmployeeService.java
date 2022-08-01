package com.Broadway.SpringMvc.Service;

import java.util.List;

import com.Broadway.SpringMvc.Model.Employee;

public interface EmployeeService {

	void addEmp(Employee emp);

	void deleteEmp(Long id);

	void update(Employee emp);

	Employee getById(Long id);

	List<Employee> getAllEmp();
}
