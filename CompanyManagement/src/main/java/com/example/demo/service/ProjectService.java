package com.example.demo.service;

import com.example.demo.entity.Department;
import com.example.demo.entity.Project;
import com.example.demo.respository.DepartmentRepository;
import com.example.demo.respository.ProjectRepository;
import com.example.demo.service.dto.ProjectDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProjectService {
    private final ProjectRepository projectRepository;
    private final DepartmentRepository departmentRepository;

    public List<Project> getAllProject() {
        return projectRepository.findAll();
    }

    public Optional<Project> getProjectById(Long projectId, Long deptId) {
        Optional<Department> department = departmentRepository.findById(deptId);
        Optional<Project> optionalProject = null;
        if (department.isPresent()) {
            optionalProject = projectRepository.findById(projectId);
        }
        return optionalProject;
    }

    public List<Project> getAllOrderByProjectName() {
        return projectRepository.findAllProjectByOrderByProjectName();
    }

    public List<Project> getProjectByAreaIgnoreCase(String area, Long deptId) {
        Optional<Department> department = departmentRepository.findById(deptId);
        List<Project> list = null;
        if (department.isPresent()) {
            list = projectRepository.findByAreaIgnoreCase(area);
        }
        return list;
    }

    public Project createProject(ProjectDTO projectDTO, Long deptId) {
        Optional<Department> department = departmentRepository.findById(deptId);
        Project project = new Project();
        project.setArea(projectDTO.getArea());
        project.setProjectName(projectDTO.getProjectName());
        if (department.isPresent()) {
            project.setDepartment(department.get());
        }
        return projectRepository.save(project);
    }

    public List<Project> getProjectByProjectNameNot(String s) {
        return projectRepository.findByProjectNameNot(s);
    }

    public List<Project> getProjectByAreaNull() {
        return projectRepository.findByAreaIsNull();
    }

    public List<Project> getProjectByAreaNotNull() {
        return projectRepository.findByAreaNotNull();
    }

    public Project updateProject(ProjectDTO projectDTO, Long projectId) {
        Optional<Project> project = projectRepository.findById(projectId);
        Project updatedProject = project.get();
        updatedProject.setArea(projectDTO.getArea());
        updatedProject.setProjectName(projectDTO.getProjectName());
        return projectRepository.save(updatedProject);
    }

    public void deleteProject(Long projectId) {
        projectRepository.deleteById(projectId);
    }
}
