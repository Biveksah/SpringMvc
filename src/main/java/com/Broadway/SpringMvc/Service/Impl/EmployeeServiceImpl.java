package com.Broadway.SpringMvc.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Broadway.SpringMvc.Model.Employee;
import com.Broadway.SpringMvc.Repository.EmployeeRepository;
import com.Broadway.SpringMvc.Service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepository empRepo;

	@Override
	public void addEmp(Employee emp) {
		empRepo.save(emp);

	}

	@Override
	public void deleteEmp(Long id) {
		empRepo.deleteById(id);

	}

	@Override
	public void update(Employee emp) {
		empRepo.save(emp);

	}

	@Override
	public Employee getById(Long id) {
		
		return empRepo.getById(id);
	}

	@Override
	public List<Employee> getAllEmp() {
		return empRepo.findAll();
	}

}
