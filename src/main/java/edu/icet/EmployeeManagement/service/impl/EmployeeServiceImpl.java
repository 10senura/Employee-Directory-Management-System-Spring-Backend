package edu.icet.EmployeeManagement.service.impl;

import edu.icet.EmployeeManagement.dto.Employee;
import edu.icet.EmployeeManagement.entity.EmployeeEntity;
import edu.icet.EmployeeManagement.repository.EmployeeRepository;
import edu.icet.EmployeeManagement.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    final EmployeeRepository employeeRepository;
    final ModelMapper modelMapper;


    @Override
    public void saveEmployee(Employee employee) {
        employeeRepository.save(modelMapper.map(employee, EmployeeEntity.class));
    }

    @Override
    public List<Employee> getAll() {
        List<EmployeeEntity> employeeEntityList= employeeRepository.findAll();
        List<Employee> employeeList=new ArrayList<>();
        employeeEntityList.forEach(EmployeeEntity -> {
            Employee bevarages= modelMapper.map(EmployeeEntity,Employee.class);
            employeeList.add(bevarages);
        });
        return employeeList;
    }

    @Override
    public void deleteEmployee(Integer id) {
    employeeRepository.deleteById(id);
    }

    @Override
    public void updateEmployee(Employee employee) {
        employeeRepository.save(modelMapper.map(employee,EmployeeEntity.class));
    }

    @Override
    public List<Employee> searchByName(String name) {
        List<EmployeeEntity> employeeEntityList = employeeRepository.findByName(name);
        List<Employee> employeeList = new ArrayList<>();
        employeeEntityList.forEach(EmployeeEntity -> employeeList.add(modelMapper.map(EmployeeEntity, Employee.class)));
        return employeeList;
    }

    @Override
    public Employee searchById(Integer id) {
        return new ModelMapper().map(employeeRepository.findById(id).get(),Employee.class);
    }
}
