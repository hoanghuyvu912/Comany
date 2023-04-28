package com.example.demo.rest;

import com.example.demo.entity.Department;
import com.example.demo.service.dto.DepartmentDTO;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RequestMapping(value = "/api/departments")
public interface DepartmentAPI {
    @GetMapping(value = "/{deptId}")
    ResponseEntity<Department> getDepartmentById(@PathVariable Long deptId);

    @GetMapping(value = "/reports")
    ResponseEntity<List<Department>> getDepartmentByStartDate(@RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate);

    @GetMapping(value = "/reports_after")
    ResponseEntity<List<Department>> getDepartmentByStartDateAfter(@RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate);

    @GetMapping(value = "/reports_before")
    ResponseEntity<List<Department>> getDepartmentByStartDateBefore(@RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate);

    @GetMapping(value = "/reports_between")
    ResponseEntity<List<Department>> getDepartmentByStartDateBetween(@Param("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate beginDate,
                                                                     @Param("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate);

    @GetMapping(value = "/string_pattern")
    ResponseEntity<List<Department>> getDepartmentByNameIgnoreCase(@RequestParam("name") String name);

    @PostMapping
    ResponseEntity<Department> createDepartment(@RequestBody DepartmentDTO departmentDTO);

    @PutMapping(value = "/{deptId}")
    ResponseEntity<Department> updateDepartment(@RequestBody DepartmentDTO departmentDTO, @PathVariable Long deptId);

    @DeleteMapping(value = "/{deptId}")
    ResponseEntity<Void> deleteDepartment(@PathVariable Long deptId);
}
