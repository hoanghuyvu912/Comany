package com.example.demo.respository;

import com.example.demo.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;


@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    List<Department> findByStartDate(LocalDate startDate);

    List<Department> findByStartDateAfter(LocalDate startDate);

    List<Department> findByStartDateBefore(LocalDate startDate);

    List<Department> findByStartDateBetween(LocalDate beginDate, LocalDate endDate);

    List<Department> findByNameIgnoreCase(String string);
}
