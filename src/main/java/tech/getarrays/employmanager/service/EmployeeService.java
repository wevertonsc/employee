package tech.getarrays.employmanager.service;


import org.springframework.stereotype.Service;
import tech.getarrays.employmanager.exception.UserNotFoundException;
import tech.getarrays.employmanager.model.Employee;
import tech.getarrays.employmanager.repo.EmployeeRepo;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {

    private final EmployeeRepo employeeRepo;

    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public Employee addEmployee(Employee employee){
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepo.save(employee);
    }

    public List<Employee> findAllEmployees() {
        return employeeRepo.findAll();
    }

    public Employee updateEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }

    public Employee findEmployeeById(Long id){
        return employeeRepo.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not founded!"));

    }

    public void deleteEmployee(Long id) {
        employeeRepo.deleteById(id);
    }


}