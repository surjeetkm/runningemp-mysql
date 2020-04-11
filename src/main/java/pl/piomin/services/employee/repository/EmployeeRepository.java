package pl.piomin.services.employee.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.piomin.services.employee.model.Employee;
@Repository
@Transactional
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {}
