package com.eden.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.eden.entity.Employee;
import com.eden.service.EmployeeService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@Value("${file.upload}")
	private String realpath;
	
	@RequestMapping("search")
	public String sarchEmp(String dateBegin,String dateEnd,String topSalary,String 
			lowSalary,String searchName,Model model) {
		
		dateBegin=dateBegin.trim();
		dateEnd=dateEnd.trim();
		topSalary=topSalary.trim();
		lowSalary=lowSalary.trim();
		searchName=searchName.trim();
		
		log.info("開始時間:{},完了時間:{},最高工资:{},最低工资:{},名前:{},",dateBegin,dateEnd,topSalary,lowSalary,searchName);
		
		List<Employee> employee=employeeService.searchEmp(dateBegin,dateEnd,topSalary,lowSalary,searchName);
		
		model.addAttribute("employeeList",employee);
		
		return "emplist";
	}
	
	@RequestMapping("delete")
	public String delete(Integer id) {
		log.info("削除の社員ID:{}",id);
		
		String photo = employeeService.findById(id).getPhoto();
		
		File file=new File(realpath,photo);
		if(file.exists())file.delete();
		
		employeeService.delete(id);
		
		return "redirect:/employee/lists";
	}
	
	@RequestMapping("update")
	public String update(Employee employee, MultipartFile img) throws IllegalStateException, IOException {
		log.info("更新した社員ID:{},名前:{},工资:{},誕生日:{}",
				employee.getId(),employee.getName(),employee.getSalary(),employee.getBirthday());
		boolean notempty=!img.isEmpty();
		log.info("写真更新するかとか:{}",notempty);
		
		if(notempty) {
			String oldphoto = employeeService.findById(employee.getId()).getPhoto();
		
			File file = new File(realpath,oldphoto);
			
			if(file.exists()) {
				file.delete();
			}
			
			String originalFilename = img.getOriginalFilename();
			//抽出メソッド
			String newFileName = uploadPhoto(img,originalFilename);
			
			employee.setPhoto(newFileName);
		}
		if (employee.getPhoto().isEmpty()) {
			employee.setPhoto(new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()));
		}
		employeeService.update(employee);
		
		return "redirect:/employee/lists";
	}
	
	
	@RequestMapping("detail")
	public String detail(Integer id,Model model) {
		
		Employee employee = employeeService.findById(id);
		
		log.info("更新ID:{}",id);
		
		model.addAttribute("employee",employee);
		
		return "updateEmp";	
	}
	
	@RequestMapping("save")
	public String save(Employee employee,MultipartFile img) throws IllegalStateException, IOException {
		log.info("名前:{},给料:{},誕生日:{}",employee.getName(),employee.getSalary(),employee.getBirthday());
		String originalFilename = img.getOriginalFilename();
		log.info("ファイルの名:{},ファイルのサイズ:{},アップロード:{}",originalFilename,img.getSize(),realpath);
			
		String newFileName = uploadPhoto(img,originalFilename);
				
		employee.setPhoto(newFileName);
		
		employeeService.save(employee);
		
		return "redirect:/employee/lists";
	}

	@RequestMapping("lists")
	public String lists(Model model) {
		log.info("全部社員を紹会する");
		
		List<Employee> employeeList= employeeService.lists();
		
		model.addAttribute("employeeList",employeeList);
		return "emplist";
	}
	
	@PostMapping("/employee/save")
	public String saveEmployee(@RequestParam("name") String name, 
	                           @RequestParam("img") MultipartFile img,
	                           @RequestParam("salary") String salary,
	                           @RequestParam("birthday") String birthday, 
	                           RedirectAttributes redirectAttributes) {

	    if (name.isEmpty() || img.isEmpty() || salary.isEmpty()) {
	        redirectAttributes.addFlashAttribute("errorMessage", "所有字段不能为空。");
	        return "redirect:/addEmp";
	    }

	    // 其他保存逻辑
	    return "redirect:/employee/lists";
	}

	
private String uploadPhoto(MultipartFile img,String originalFilename) throws IllegalStateException, IOException {
		
		String fileNamePrefix = originalFilename.substring(0,originalFilename.lastIndexOf("."));
		
		String fileTime=new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
		
		String fileNamesuffix = originalFilename.substring(originalFilename.lastIndexOf("."));
		
		String newFileName =fileNamePrefix+fileTime+fileNamesuffix;
		
		img.transferTo(new File(realpath,newFileName));
		
		return newFileName;
	}
}
