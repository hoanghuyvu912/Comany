package com.example.demo.service;

import com.example.demo.entity.Department;
import com.example.demo.entity.Employee;
import com.example.demo.entity.Location;
import com.example.demo.respository.DepartmentRepository;
import com.example.demo.respository.LocationRepository;
import com.example.demo.service.dto.LocationDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LocationService {
    private final DepartmentRepository departmentRepository;
    private final LocationRepository locationRepository;

    public List<Location> getAllLocation() {
        return locationRepository.findAll();
    }

    public Optional<Location> getLocationById(Long locationId, Long deptId) {
        Optional<Department> department = departmentRepository.findById(deptId);
        Optional<Location> optionalLocation = null;
        if (department.isPresent()) {
            optionalLocation = locationRepository.findById(locationId);
        }
        return optionalLocation;
    }

    public List<Location> getLocationByLocationLike(String s) {
        return locationRepository.findByLocationLike("%" + s + "%");
    }

    public List<Location> getLocationByLocationNotLike(String s) {
        return locationRepository.findByLocationNotLike("%" + s + "%");
    }

    public List<Location> getLocationByLocationStartingWith(String s) {
        return locationRepository.findByLocationStartingWith(s);
    }

    public List<Location> getLocationByLocationEndingWith(String s) {
        return locationRepository.findByLocationEndingWith(s);
    }

    public List<Location> getLocationByLocationContaining(String s) {
        return locationRepository.findByLocationContaining(s);
    }


    public Location createLocation(LocationDTO locationDTO, Long depIt) {
        Optional<Department> department = departmentRepository.findById(depIt);
        Location location = new Location();
        location.setLocation(locationDTO.getLocation());
        if (department.isPresent()) {
            location.setDepartment(department.get());
        }
        return locationRepository.save(location);
    }

    public void deleteLocation(Long locationId) {
        locationRepository.deleteById(locationId);
    }

    public Location updateLocation(LocationDTO locationDTO, Long locationId) {
        Optional<Location> location = locationRepository.findById(locationId);
        Location updatedLocation = location.get();
        updatedLocation.setLocation(locationDTO.getLocation());
        return locationRepository.save(updatedLocation);
    }
}
