package com.example.demo.rest;

import com.example.demo.entity.*;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.websocket.server.PathParam;
import java.util.List;

@RequestMapping(value = "/api/company")
public interface CompanyAPI {
    //Employee
    @GetMapping(value = "/employees")
    ResponseEntity<List<Employee>> getAllEmployee();

    @GetMapping(value = "/employees/lastNameAndFirstName")
    ResponseEntity<List<Employee>> getEmployeeByLastNameAndFirstName(@Param("lastName") String lastName, @Param("firstName") String firstName);

    @GetMapping(value = "/employees/lastNameOrFirstName")
    ResponseEntity<List<Employee>> getEmployeeByLastNameOrFirstName(@Param("lastName") String lastName, @Param("firstName") String firstName);

    @GetMapping(value = "/employees/firstName")
    ResponseEntity<List<Employee>> getEmployeeByFirstName(@RequestParam("firstName") String firstName);


    @GetMapping(value = "/employees/salaryLessThan")
    ResponseEntity<List<Employee>> getEmployeeBySalaryLessThan(@RequestParam("salary") Integer salary);


    @GetMapping(value = "/employees/salaryGreaterThan")
    ResponseEntity<List<Employee>> getEmployeeBySalaryGreaterThan(@RequestParam("salary") Integer salary);

    //Department
    @GetMapping(value = "/departments")
    ResponseEntity<List<Department>> getAllDepartment();

    //Location
    @GetMapping(value = "/locations")
    ResponseEntity<List<Location>> getAllLocation();

    @GetMapping(value = "/locations/location_like")
    ResponseEntity<List<Location>> getLocationByLocationLike(@RequestParam("location") String location);

    @GetMapping(value = "/locations/location_not_like")
    ResponseEntity<List<Location>> getLocationByLocationNotLike(@RequestParam("location") String location);

    @GetMapping(value = "/locations/location_starting_with")
    ResponseEntity<List<Location>> getLocationByLocationStartingWith(@RequestParam("location") String location);

    @GetMapping(value = "/locations/location_ending_with")
    ResponseEntity<List<Location>> getLocationByLocationEndingWith(@RequestParam("location") String location);

    @GetMapping(value = "/locations/location_containing")
    ResponseEntity<List<Location>> getLocationByLocationContaining(@RequestParam("location") String location);

    //Project
    @GetMapping(value = "/projects")
    ResponseEntity<List<Project>> getAllProject();

    @GetMapping(value = "/projects/name_not")
    ResponseEntity<List<Project>> getProjectByProjectNameNot(@RequestParam("name") String name);

    @GetMapping(value = "/projects/area_null")
    ResponseEntity<List<Project>> getProjectByAreaIsNull();

    @GetMapping(value = "/projects/area_ignore_case/")
    ResponseEntity<List<Project>> getProjectByAreaIgnoreCase(@RequestParam("area") String area, @PathParam("deptId") Long deptId);

    @GetMapping(value = "/projects/area_not_null")
    ResponseEntity<List<Project>> getProjectByAreaNotNull();

    @GetMapping(value = "/projects/projects_order_by_name")
    ResponseEntity<List<Project>> getAllProjectOrderByName();

    //Relatives
    @GetMapping(value = "/relatives")
    ResponseEntity<List<Relatives>> getAllRelative();

    @GetMapping(value = "/relatives_order_by_full_name")
    ResponseEntity<List<Relatives>> getAllRelativesOrderByFullName();

    @GetMapping(value = "/relatives/start_with/{string}")
    ResponseEntity<List<Relatives>> getRelativesByFullNameStartingWith(@RequestParam String string);

    @GetMapping(value = "/relatives/ending_with/{string}")
    ResponseEntity<List<Relatives>> getRelativesByFullNameEndingWith(@RequestParam String string);

    @GetMapping(value = "/relatives/containing/{string}")
    ResponseEntity<List<Relatives>> getRelativesByPhoneNumberWith(@RequestParam String string);

    @GetMapping(value = "/relatives/relationship/{string}")
    ResponseEntity<List<Relatives>> getRelativesByRelationshipEquals(@RequestParam String string);

    //Assignment
    @GetMapping(value = "/assignments")
    ResponseEntity<List<Assignment>> getAllAssignment();

    @GetMapping(value = "/assignments/hour_less_than")
    ResponseEntity<List<Assignment>> getAssignmentByNumberOfHourLessThan(@RequestParam("hour") Integer hour);

    @GetMapping(value = "/assignments/hour_less_than_equal")
    ResponseEntity<List<Assignment>> getAssignmentByNumberOfHourLessThanEqual(@RequestParam("hour") Integer hour);

    @GetMapping(value = "/assignments/hour_greater_than")
    ResponseEntity<List<Assignment>> getAssignmentByNumberOfHourGreaterThan(@RequestParam("hour") Integer hour);

    @GetMapping(value = "/assignments/hour_greater_than_equal")
    ResponseEntity<List<Assignment>> getAssignmentByNumberOfHourGreaterThanEqual(@RequestParam("hour") Integer hour);

    @GetMapping(value = "/assignments/hour_between")
    ResponseEntity<List<Assignment>> getAssignmentByNumberOfHourBetween(@Param("hour") Integer hour1, @Param("hour") Integer hour2);
}
