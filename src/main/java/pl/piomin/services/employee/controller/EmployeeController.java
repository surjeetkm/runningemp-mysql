package pl.piomin.services.employee.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.piomin.services.employee.model.Employee;
import pl.piomin.services.employee.repository.EmployeeRepository;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@PostMapping("/add")
	public Employee add(@RequestBody Employee employee) {
		LOGGER.info("Employee add: {}", employee);
		
		return employeeRepository.save(employee);
		
	}
	
	@GetMapping("/{id}")
	public Employee findById(@PathVariable("id") Integer id) {
		System.out.println("Get by Id..............");
		LOGGER.info("Employee find: id={}", id);
		//employeeRepository.fi
		return employeeRepository.findById(id).get();
	}
	
	@GetMapping("/get")
	public List<Employee> findAll() {
		System.out.println("Get All employess..............");
		LOGGER.info("Employee find");
		Iterator<Employee> iter=employeeRepository.findAll().iterator();
		List<Employee> list=new ArrayList<Employee>();
		while(iter.hasNext()) {
			list.add(iter.next());
		}
		return list;
	}
	
	/*
	 * @GetMapping("/department/{departmentId}") public List<Employee>
	 * findByDepartment(@PathVariable("departmentId") Long departmentId) {
	 * LOGGER.info("Employee find: departmentId={}", departmentId); return
	 * repository.findByDepartment(departmentId); }
	 * 
	 * @GetMapping("/organization/{organizationId}") public List<Employee>
	 * findByOrganization(@PathVariable("organizationId") Long organizationId) {
	 * LOGGER.info("Employee find: organizationId={}", organizationId); return
	 * repository.findByOrganization(organizationId); }
	 */	
}
