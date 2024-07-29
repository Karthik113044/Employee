package Employee.List.Employee.repository;

import Employee.List.Employee.entity.Employees;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employees, Long> {

    Optional<Employees> findByEmail(String email);
    Optional<Employees> findByMobile(String mobile);
}
