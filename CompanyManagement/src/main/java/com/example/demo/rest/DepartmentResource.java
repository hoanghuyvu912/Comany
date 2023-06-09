package com.example.demo.rest;

import com.example.demo.entity.Department;
import com.example.demo.service.DepartmentService;
import com.example.demo.service.dto.DepartmentDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.html.Option;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@RestController
@RequiredArgsConstructor
public class DepartmentResource implements DepartmentAPI {
    private final DepartmentService departmentService;

    @Override
    public ResponseEntity<Department> getDepartmentById(Long deptId) {
        Optional<Department> optionDepartment = departmentService.getDepartmentById(deptId);
        return ResponseEntity.ok(optionDepartment.get());
    }

    @Override
    public ResponseEntity<List<Department>> getDepartmentByStartDate(LocalDate startDate) {
        return ResponseEntity.ok(departmentService.getDepartmentByDate(startDate));
    }

    @Override
    public ResponseEntity<List<Department>> getDepartmentByStartDateAfter(LocalDate startDate) {
        return ResponseEntity.ok(departmentService.getDepartmentByDateAfter(startDate));
    }

    @Override
    public ResponseEntity<List<Department>> getDepartmentByStartDateBefore(LocalDate startDate) {
        return ResponseEntity.ok(departmentService.getDepartmentByDateBefore(startDate));
    }

    @Override
    public ResponseEntity<List<Department>> getDepartmentByStartDateBetween(LocalDate beginDate, LocalDate endDate) {
        return ResponseEntity.ok(departmentService.getDepartmentByStartDateBetween(beginDate, endDate));
    }

    @Override
    public ResponseEntity<List<Department>> getDepartmentByNameIgnoreCase(String name) {
        return ResponseEntity.ok(departmentService.getDepartmentByNameIgnoreCase(name));
    }

    @Override
    public ResponseEntity<Department> createDepartment(DepartmentDTO departmentDTO) {
        return ResponseEntity.ok(departmentService.createDepartment(departmentDTO));
    }

    @Override
    public ResponseEntity<Department> updateDepartment(DepartmentDTO departmentDTO, Long deptId) {
        Department department = departmentService.updateDepartment(departmentDTO, deptId);
        return ResponseEntity.ok().body(department);
    }

    @Override
    public ResponseEntity<Void> deleteDepartment(Long deptId) {
        departmentService.deleteDepartment(deptId);
        return ResponseEntity.noContent().build();
    }
}
