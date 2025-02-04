package com.eden.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eden.entity.Employee;
import com.eden.service.EmployeeService;

@Controller
@RequestMapping("employee")
public class EmployeeCont {
	
	private static final Logger log=LoggerFactory.getLogger(EmployeeCont.class);
	
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping("search")
	public String searchEmp(String searchName, String dataBegin,String dateEnd,Model model) {
		
		log.debug("検索の名前:{} ,誕生日から:{},誕生日まで:{}",searchName,dataBegin,dateEnd );
		
		List<Employee> employee=employeeService.searchEmp(searchName,dataBegin,dateEnd);
		
		searchName=searchName.trim();
		dataBegin=dataBegin.trim();
		dateEnd=dateEnd.trim();
		
		model.addAttribute("employee", employee);
		
		return "emplist";
	}
	
	@RequestMapping("update")
	public String updateEmployee(Employee employee) {
		log.debug("名前:{},誕生日:{},月給:{}性別:{}",
		employee.getName(),employee.getBirthday(),employee.getSalary(),employee.isGender());
		
		employeeService.update(employee);
		return "redirect:/employee/list";
	}
	
	@RequestMapping("detail")
	public String detailEmployee(Integer id ,Model model) {
		log.debug("更新ID:{}",id);
		
		Employee employee =employeeService.idByEmployee(id);
		
		model.addAttribute("employee", employee);
		
		return "updateEmp";
		
	}
	
	@RequestMapping("delete")
	public String deleteEmployee(Integer id) {
		log.debug("削除したid:{}",id);
		
		employeeService.delete(id);
		
		return "redirect:/employee/list";
	}
	
	@GetMapping("list")
	public String listEmployee(Model model){
		
		List<Employee> employee=employeeService.list();
		
		model.addAttribute("employee", employee);
		
		return "emplist";
		
	}
	
	
	
	@PostMapping("add")
	public String addEmployee(Employee employee) {
		
		log.debug("名前:{},誕生日:{},月給:{}性別:{}",
				employee.getName(),employee.getBirthday(),employee.getSalary(),employee.isGender());
		
		employeeService.add(employee);
		return "redirect:/employee/list";
		
	}

}
