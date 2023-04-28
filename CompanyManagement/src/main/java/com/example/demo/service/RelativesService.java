package com.example.demo.service;

import com.example.demo.entity.Employee;
import com.example.demo.entity.Relatives;
import com.example.demo.respository.EmployeeRepository;
import com.example.demo.respository.RelativesRepository;
import com.example.demo.service.dto.RelativesDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RelativesService {
    private final RelativesRepository relativesRepository;
    private final EmployeeRepository employeeRepository;

    public List<Relatives> getAllRelatives() {
        return relativesRepository.findAll();
    }

    public Optional<Relatives> getRelativesByID(Long relativesId, Long employeeId) {
        Optional<Employee> employee = employeeRepository.findById(employeeId);
        Optional<Relatives> optionalRelatives = null;
        if (employee.isPresent()) {
            optionalRelatives = relativesRepository.findById(relativesId);
        }
        return optionalRelatives;
    }

    public List<Relatives> getAllRelativesByOrderByFullNameAsc() {
        return relativesRepository.findAllByOrderByFullNameAsc();
    }

    public List<Relatives> getRelativesByFullNameStartingWith(String s) {
        return relativesRepository.findByFullNameStartingWith(s);
    }

    public List<Relatives> getRelativesByFullNameEndingWith(String s) {
        return relativesRepository.findByFullNameEndingWith(s);
    }

    public List<Relatives> getRelativesByPhoneNumberContaining(String s) {
        return relativesRepository.findByPhoneNumberContaining(s);
    }

    public List<Relatives> getRelativesByRelationshipEquals(String s) {
        return relativesRepository.findByRelationshipEquals(s);
    }


    public Relatives createRelatives(RelativesDTO relativesDTO, Long employeeId) {
        Optional<Employee> employee = employeeRepository.findById(employeeId);
        Relatives relatives = new Relatives();
        relatives.setFullName(relativesDTO.getFullName());
        relatives.setGender(relativesDTO.getGender());
        relatives.setPhoneNumber(relativesDTO.getPhoneNumber());
        relatives.setRelationship(relativesDTO.getRelationship());
        if (employee.isPresent()) {
            relatives.setEmployee(employee.get());
        }
        return relativesRepository.save(relatives);
    }

    public Relatives updateRelatives(RelativesDTO relativesDTO, Long relativesId) {
        Optional<Relatives> relatives = relativesRepository.findById(relativesId);
        Relatives updatedRelatives = relatives.get();
        updatedRelatives.setGender(relativesDTO.getGender());
        updatedRelatives.setRelationship(relativesDTO.getRelationship());
        updatedRelatives.setFullName(relativesDTO.getFullName());
        updatedRelatives.setPhoneNumber(relativesDTO.getPhoneNumber());
        return relativesRepository.save(updatedRelatives);
    }

    public void deleteRelatives(Long relativesId) {
        relativesRepository.deleteById(relativesId);
    }
}
