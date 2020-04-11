package pl.piomin.services.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import pl.piomin.services.employee.model.Employee;
import pl.piomin.services.employee.repository.EmployeeRepository;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@ComponentScan(basePackages = { "pl.piomin.services.employee.controller" })
@EnableJpaRepositories(basePackages = { "pl.piomin.services.employee.repository" })
public class EmployeeApplication implements CommandLineRunner {

	@Autowired
	EmployeeRepository employeeRepository;

	public static void main(String[] args) {
		SpringApplication.run(EmployeeApplication.class, args);
	}
	/*
	 * @Bean public Docket swaggerPersonApi10() { return new
	 * Docket(DocumentationType.SWAGGER_2) .select()
	 * .apis(RequestHandlerSelectors.basePackage(
	 * "pl.piomin.services.employee.controller")) .paths(PathSelectors.any())
	 * .build() .apiInfo(new ApiInfoBuilder().version("1.0").title("Employee API").
	 * description("Documentation Employee API v1.0").build()); }
	 */

	@Override
	public void run(String... args) throws Exception {

		Employee emp=new Employee("Rocky", "Surjeet", "Mohanty", "Bengalore", "Karnataka");
		employeeRepository.save(emp);
		for (Employee customer : employeeRepository.findAll()) {
			System.out.println("ID:" + customer.getId());
			System.out.println("CITY:" + customer.getCity());
			System.out.println("FName:" + customer.getFirstname());
			System.out.println("LNAME:" + customer.getLastname());
			System.out.println("USER:" + customer.getUsername());
			System.out.println("STATE:" + customer.getState());
		}
	}

}
