package com.example.demo.service;

import com.example.demo.entity.Department;
import com.example.demo.entity.Employee;
import com.example.demo.respository.DepartmentRepository;
import com.example.demo.respository.EmployeeRepository;
import com.example.demo.service.dto.EmployeeDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;

    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployeeById(Long employeeId, Long deptId) {
        Optional<Department> department = departmentRepository.findById(deptId);
        Optional<Employee> optionalEmployee = null;
        if (department.isPresent()) {
            optionalEmployee = employeeRepository.findById(employeeId);
        }
        return optionalEmployee;
    }

    public List<Employee> getEmployeeByLastNameAndFirstName(String lastName, String firstName) {
        return employeeRepository.findByLastNameAndFirstName(lastName, firstName);
    }

    public List<Employee> getEmployeeByLastNameOrFirstName(String lastName, String firstName) {
        return employeeRepository.findByLastNameOrFirstName(lastName, firstName);
    }

    public List<Employee> getEmployeeByFirstName(String firstName) {
        return employeeRepository.findByFirstName(firstName);
    }

    public List<Employee> getEmployeeBySalaryLessThan(Integer salary) {
        return employeeRepository.findBySalaryLessThan(salary);
    }

    public List<Employee> getEmployeeBySalaryGreaterThan(Integer salary) {
        return employeeRepository.findBySalaryGreaterThan(salary);
    }

    public Employee createEmployee(EmployeeDTO employeeDTO, Long deptId) {
        Optional<Department> department = departmentRepository.findById(deptId);
        Employee employee = new Employee();
        employee.setDateOfBirth(employeeDTO.getDateOfBirth());
        employee.setFirstName(employeeDTO.getFirstName());
        employee.setLastName(employeeDTO.getLastName());
        employee.setMiddleName(employeeDTO.getMiddleName());
        employee.setGender(employeeDTO.getGender());
        employee.setSalary(employeeDTO.getSalary());
        if (department.isPresent()) {
            employee.setDepartment(department.get());
        }
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(EmployeeDTO employeeDTO, Long employeeId) {
        Optional<Employee> employee = employeeRepository.findById(employeeId);
        Employee updatedEmployee = employee.get();
        updatedEmployee.setDateOfBirth(employeeDTO.getDateOfBirth());
        updatedEmployee.setFirstName(employeeDTO.getFirstName());
        updatedEmployee.setLastName(employeeDTO.getLastName());
        updatedEmployee.setMiddleName(employeeDTO.getMiddleName());
        updatedEmployee.setGender(employeeDTO.getGender());
        updatedEmployee.setSalary(employeeDTO.getSalary());
        return employeeRepository.save(updatedEmployee);
    }

    public void deleteEmployee(Long employeeId) {
        employeeRepository.deleteById(employeeId);
    }
}
