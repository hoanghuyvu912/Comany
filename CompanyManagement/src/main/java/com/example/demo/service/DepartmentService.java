package com.example.demo.service;

import com.example.demo.entity.Department;
import com.example.demo.respository.DepartmentRepository;
import com.example.demo.service.dto.DepartmentDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DepartmentService {
    private final DepartmentRepository departmentRepository;

    public List<Department> getAllDepartment() {
        return departmentRepository.findAll();
    }

    public Optional<Department> getDepartmentById(Long deptId) {
        return departmentRepository.findById(deptId);
    }

    public List<Department> getDepartmentByDate(LocalDate localDate) {
        return departmentRepository.findByStartDate(localDate);
    }

    public List<Department> getDepartmentByDateAfter(LocalDate localDate) {
        return departmentRepository.findByStartDateAfter(localDate);
    }

    public List<Department> getDepartmentByDateBefore(LocalDate localDate) {
        return departmentRepository.findByStartDateBefore(localDate);
    }

    public List<Department> getDepartmentByStartDateBetween(LocalDate beginDate, LocalDate endDate) {
        return departmentRepository.findByStartDateBetween(beginDate, endDate);
    }

    public List<Department> getDepartmentByNameIgnoreCase(String s) {
        return departmentRepository.findByNameIgnoreCase(s);
    }

    public Department createDepartment(DepartmentDTO departmentDTO) {
        Department department = new Department();
        department.setName(departmentDTO.getName());
        department.setStartDate(departmentDTO.getStartDate());
        return departmentRepository.save(department);
    }

    public Department updateDepartment(DepartmentDTO departmentDTO, Long deptId) {
        Optional<Department> department = departmentRepository.findById(deptId);
        Department updatedDepartment = department.get();
        updatedDepartment.setName(departmentDTO.getName());
        updatedDepartment.setStartDate(departmentDTO.getStartDate());
        return departmentRepository.save(updatedDepartment);
    }

    public void deleteDepartment(Long deptId) {
        departmentRepository.deleteById(deptId);
    }
}
