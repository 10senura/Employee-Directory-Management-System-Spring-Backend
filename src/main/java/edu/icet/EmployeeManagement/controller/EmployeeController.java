package edu.icet.EmployeeManagement.controller;


import edu.icet.EmployeeManagement.dto.Employee;
import edu.icet.EmployeeManagement.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
@CrossOrigin
public class EmployeeController {

 final EmployeeService employeeService;

    @PostMapping("/addEmployee")
    public  void addEmployee(@RequestBody Employee employee){employeeService.saveEmployee(employee);}

    @GetMapping("/allEmployee")
    public List<Employee> getAllEmployee(){
        return employeeService.getAll();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEmployee(@PathVariable Integer id){
        employeeService.deleteEmployee(id);
    }

    @PutMapping("/updateEmployee")
    public void updateEmployee(@RequestBody Employee employee){
        employeeService.updateEmployee(employee);
    }

    @GetMapping("/search-by-id/{id}")
    public Employee getEmployeeById(@PathVariable Integer id){
        return employeeService.searchById(id);
    }

    @GetMapping("/search-by-name/{name}")
    public List<Employee> getEmployeeByName(@PathVariable String name){
        return employeeService.searchByName(name);
    }


}
