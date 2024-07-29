package Employee.List.Employee.service;

import Employee.List.Employee.entity.Employees;
import Employee.List.Employee.exception.EmployeeNotFoundException;
import Employee.List.Employee.payload.EmployeeDto;
import Employee.List.Employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;


    public Employees postEmployee(EmployeeDto employeeDto) {

        Optional<Employees> existingByEmail = employeeRepository.findByEmail(employeeDto.getEmail());
        if (existingByEmail.isPresent()) {
            throw new IllegalArgumentException("Email already exists");

        }

        Optional<Employees> existingByMobile = employeeRepository.findByMobile(employeeDto.getMobile());
        if (existingByMobile.isPresent()) {
            throw new IllegalArgumentException("Mobile number already exists");
        }

        Employees employee = new Employees();

        employee.setName(employeeDto.getName());
        employee.setGender(employeeDto.getGender());
        employee.setEmail(employeeDto.getEmail());
        employee.setMobile(employeeDto.getMobile());
        employee.setCourse(employeeDto.getCourse());
        employee.setDesignation(employeeDto.getDesignation());

       return employeeRepository.save(employee);

    }


    public void deleteEmployee(Long id) {
        Optional<Employees> existingById = employeeRepository.findById(id);
        if (existingById.isEmpty()) {
            throw new IllegalArgumentException("Employee with ID " + id + " does not exist");
        } else {
            employeeRepository.deleteById(id);
        }
    }
    public Employees updateEmployee(Long id, Employees updatedEmployee) {
        Optional<Employees> existingEmployee = employeeRepository.findById(id);
        if (!existingEmployee.isPresent()) {
            throw new EmployeeNotFoundException("Employee not found");
        }

        Employees employee = existingEmployee.get();
        employee.setName(updatedEmployee.getName());
        employee.setEmail(updatedEmployee.getEmail());
        employee.setMobile(updatedEmployee.getMobile());
        employee.setDesignation(updatedEmployee.getDesignation());
        employee.setGender(updatedEmployee.getGender());
        employee.setCourse(updatedEmployee.getCourse());

        return employeeRepository.save(employee);
    }

    public List<Employees> getAllEmployees() {
        return employeeRepository.findAll();
    }
}
