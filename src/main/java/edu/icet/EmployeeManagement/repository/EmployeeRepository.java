package edu.icet.EmployeeManagement.repository;

import edu.icet.EmployeeManagement.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Integer> {
    List<EmployeeEntity> findByName(String name);
}