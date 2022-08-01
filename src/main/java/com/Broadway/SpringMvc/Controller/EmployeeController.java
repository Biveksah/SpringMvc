package com.Broadway.SpringMvc.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Broadway.SpringMvc.Model.Employee;
import com.Broadway.SpringMvc.Repository.EmployeeRepository;
import com.Broadway.SpringMvc.Service.EmployeeService;

@Controller
public class EmployeeController {
	@Autowired
	private EmployeeService  service;

	@GetMapping("/employee")
	public String showEmployee() {
		return "EmployeeForm";
	}

	@PostMapping("/employee")
	public String saveEmployee(@ModelAttribute Employee emp,Model model) {
		
		service.addEmp(emp);

		return "EmployeeForm";
	}
	@GetMapping("/employeeList")
	public  String showAllEmployee(Model model) {
		model.addAttribute("emplist",service.getAllEmp());
		return"EmployeeList";
		
	}
	@GetMapping("/delete")
	public String deleteEmployee(@RequestParam Long id)
	{
		service.deleteEmp(id);
		return "redirect:employeeList";
		
	}
	@GetMapping("/edit")
	public String editEmployee(@RequestParam Long id,Model model)
	{
		model.addAttribute("epmEdit",service.getById(id));
		return"EditForm";
	}
	@PostMapping("/update")
	public String updateEmployee(@RequestParam Long id, Model model,Employee emp)
	{
		service.addEmp(emp);
		model.addAttribute("epmEdit",service.getById(id));
		return"redirect:/employee";
	}
}
