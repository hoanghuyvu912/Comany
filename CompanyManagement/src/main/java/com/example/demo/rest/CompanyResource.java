package com.example.demo.rest;

import com.example.demo.entity.*;
import com.example.demo.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CompanyResource implements CompanyAPI {
    private final EmployeeService employeeService;
    private final DepartmentService departmentService;
    private final LocationService locationService;
    private final ProjectService projectService;
    private final RelativesService relativesService;
    private final AssignmentService assignmentService;

    //Employee
    @Override
    public ResponseEntity<List<Employee>> getAllEmployee() {
        return ResponseEntity.ok(employeeService.getAllEmployee());
    }

    @Override
    public ResponseEntity<List<Employee>> getEmployeeByLastNameAndFirstName(String lastName, String firstName) {
        return ResponseEntity.ok(employeeService.getEmployeeByLastNameAndFirstName(lastName, firstName));
    }

    @Override
    public ResponseEntity<List<Employee>> getEmployeeByLastNameOrFirstName(String lastName, String firstName) {
        return ResponseEntity.ok(employeeService.getEmployeeByLastNameOrFirstName(lastName, firstName));
    }

    @Override
    public ResponseEntity<List<Employee>> getEmployeeByFirstName(String firstName) {
        return ResponseEntity.ok(employeeService.getEmployeeByFirstName(firstName));
    }

    @Override
    public ResponseEntity<List<Employee>> getEmployeeBySalaryLessThan(Integer salary) {
        return ResponseEntity.ok(employeeService.getEmployeeBySalaryLessThan(salary));
    }

    @Override
    public ResponseEntity<List<Employee>> getEmployeeBySalaryGreaterThan(Integer salary) {
        return ResponseEntity.ok(employeeService.getEmployeeBySalaryGreaterThan(salary));
    }

    //Department
    @Override
    public ResponseEntity<List<Department>> getAllDepartment() {
        return ResponseEntity.ok(departmentService.getAllDepartment());
    }

    //Location
    @Override
    public ResponseEntity<List<Location>> getAllLocation() {
        return ResponseEntity.ok(locationService.getAllLocation());
    }

    @Override
    public ResponseEntity<List<Location>> getLocationByLocationLike(String location) {
        return ResponseEntity.ok(locationService.getLocationByLocationLike(location));
    }

    @Override
    public ResponseEntity<List<Location>> getLocationByLocationNotLike(String location) {
        return ResponseEntity.ok(locationService.getLocationByLocationNotLike(location));
    }

    @Override
    public ResponseEntity<List<Location>> getLocationByLocationStartingWith(String location) {
        return ResponseEntity.ok(locationService.getLocationByLocationStartingWith(location));
    }

    @Override
    public ResponseEntity<List<Location>> getLocationByLocationEndingWith(String location) {
        return ResponseEntity.ok(locationService.getLocationByLocationEndingWith(location));
    }

    @Override
    public ResponseEntity<List<Location>> getLocationByLocationContaining(String location) {
        return ResponseEntity.ok(locationService.getLocationByLocationContaining(location));
    }

    //Project
    @Override
    public ResponseEntity<List<Project>> getAllProject() {
        return ResponseEntity.ok(projectService.getAllProject());
    }

    @Override
    public ResponseEntity<List<Project>> getProjectByProjectNameNot(String name) {
        return ResponseEntity.ok(projectService.getProjectByProjectNameNot(name));
    }

    @Override
    public ResponseEntity<List<Project>> getProjectByAreaIsNull() {
        return ResponseEntity.ok(projectService.getProjectByAreaNull());
    }

    @Override
    public ResponseEntity<List<Project>> getProjectByAreaIgnoreCase(String area, Long deptId) {
        return ResponseEntity.ok(projectService.getProjectByAreaIgnoreCase(area, deptId));
    }

    @Override
    public ResponseEntity<List<Project>> getProjectByAreaNotNull() {
        return ResponseEntity.ok(projectService.getProjectByAreaNotNull());
    }

    @Override
    public ResponseEntity<List<Project>> getAllProjectOrderByName() {
        return ResponseEntity.ok(projectService.getAllOrderByProjectName());
    }

    //Relative
    @Override
    public ResponseEntity<List<Relatives>> getAllRelative() {
        return ResponseEntity.ok(relativesService.getAllRelatives());
    }

    @Override
    public ResponseEntity<List<Relatives>> getAllRelativesOrderByFullName() {
        return ResponseEntity.ok(relativesService.getAllRelativesByOrderByFullNameAsc());
    }

    @Override
    public ResponseEntity<List<Relatives>> getRelativesByFullNameStartingWith(String string) {
        return ResponseEntity.ok(relativesService.getRelativesByFullNameStartingWith(string));
    }

    @Override
    public ResponseEntity<List<Relatives>> getRelativesByFullNameEndingWith(String string) {
        return ResponseEntity.ok(relativesService.getRelativesByFullNameEndingWith(string));

    }

    @Override
    public ResponseEntity<List<Relatives>> getRelativesByPhoneNumberContaining(String string) {
        return ResponseEntity.ok(relativesService.getRelativesByPhoneNumberContaining(string));
    }

    @Override
    public ResponseEntity<List<Relatives>> getRelativesByRelationshipEquals(String string) {
        return ResponseEntity.ok(relativesService.getRelativesByRelationshipEquals(string));
    }

    //Assignment
    @Override
    public ResponseEntity<List<Assignment>> getAllAssignment() {
        return ResponseEntity.ok(assignmentService.getAllAssignment());
    }

    @Override
    public ResponseEntity<List<Assignment>> getAssignmentByNumberOfHourLessThan(Integer hours) {
        return ResponseEntity.ok(assignmentService.getAssignmentByNumberOfHourLessThan(hours));
    }

    @Override
    public ResponseEntity<List<Assignment>> getAssignmentByNumberOfHourLessThanEqual(Integer hours) {
        return ResponseEntity.ok(assignmentService.getAssignmentByNumberOfHourLessThanEqual(hours));
    }

    @Override
    public ResponseEntity<List<Assignment>> getAssignmentByNumberOfHourGreaterThan(Integer hours) {
        return ResponseEntity.ok(assignmentService.getAssignmentByNumberOfHourGreaterThan(hours));
    }

    @Override
    public ResponseEntity<List<Assignment>> getAssignmentByNumberOfHourGreaterThanEqual(Integer hours) {
        return ResponseEntity.ok(assignmentService.getAssignmentByNumberOfHourGreaterThanEqual(hours));
    }

    @Override
    public ResponseEntity<List<Assignment>> getAssignmentByNumberOfHourBetween(Integer hour1, Integer hour2) {
        return ResponseEntity.ok(assignmentService.getAssignmentByNumberOfHourBetween(hour1, hour2));
    }
}
