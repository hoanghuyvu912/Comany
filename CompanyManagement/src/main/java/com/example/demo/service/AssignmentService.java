package com.example.demo.service;

import com.example.demo.entity.Assignment;
import com.example.demo.entity.Employee;
import com.example.demo.entity.Project;
import com.example.demo.respository.AssignmentRepository;
import com.example.demo.respository.DepartmentRepository;
import com.example.demo.respository.EmployeeRepository;
import com.example.demo.respository.ProjectRepository;
import com.example.demo.service.dto.AssignmentDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AssignmentService {
    private final AssignmentRepository assignmentRepository;
    private final ProjectRepository projectRepository;
    private final EmployeeRepository employeeRepository;

    public List<Assignment> getAllAssignment() {
        return assignmentRepository.findAll();
    }

    public Optional<Assignment> getAssignmentById(Long assignmentId, Long projectId, Long employeeId) {
        Optional<Project> project = projectRepository.findById(projectId);
        Optional<Employee> employee = employeeRepository.findById(employeeId);
        Optional<Assignment> assignment = null;
        if (project.isPresent() && employee.isPresent()) {
            assignment = assignmentRepository.findById(assignmentId);
        }
        return assignment;
    }

    public List<Assignment> getAssignmentByNumberOfHourLessThan(Integer h) {
        return assignmentRepository.findByNumberOfHourLessThan(h);
    }

    public List<Assignment> getAssignmentByNumberOfHourLessThanEqual(Integer h) {
        return assignmentRepository.findByNumberOfHourLessThanEqual(h);
    }

    public List<Assignment> getAssignmentByNumberOfHourGreaterThan(Integer h) {
        return assignmentRepository.findByNumberOfHourGreaterThan(h);
    }

    public List<Assignment> getAssignmentByNumberOfHourGreaterThanEqual(Integer h) {
        return assignmentRepository.findByNumberOfHourGreaterThanEqual(h);
    }

    public List<Assignment> getAssignmentByNumberOfHourBetween(Integer h1, Integer h2) {
        return assignmentRepository.findByNumberOfHourBetween(h1, h2);
    }

    public Assignment createAssignment(AssignmentDTO assignmentDTO, Long deptId, Long employeeId) {
        Optional<Project> project = projectRepository.findById(deptId);
        Optional<Employee> employee = employeeRepository.findById(employeeId);

        Assignment assignment = new Assignment();
        assignment.setNumberOfHour(assignmentDTO.getNumberOfHour());
        if (project.isPresent()) {
            assignment.setProject(project.get());
        }
        if (employee.isPresent()) {
            assignment.setEmployee(employee.get());
        }
        return assignmentRepository.save(assignment);
    }

    public Assignment updateAssignment(AssignmentDTO assignmentDTO, Long assignmentId) {
        Optional<Assignment> assignment = assignmentRepository.findById(assignmentId);
        Assignment updatedAssignment = new Assignment();
        updatedAssignment.setNumberOfHour(assignmentDTO.getNumberOfHour());
        return assignmentRepository.save(updatedAssignment);
    }

    public void deleteAssignment(Long assignmentId) {
        assignmentRepository.deleteById(assignmentId);
    }
}
