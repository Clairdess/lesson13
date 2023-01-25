package com.vkatit.service;

import com.vkatit.model.Employee;
import com.vkatit.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService implements CommonService<Employee> {

    private final EmployeeRepository repository;

    @Override
    public int save(Employee employee) {
        return repository.createEmployee(employee);
    }

    @Override
    public Employee findById(Long id) {
        return repository.getEmployeeById(id);
    }

    @Override
    public List<Employee> findAll() {
        return repository.getAllEmployees();
    }

    @Override
    public boolean delete(Employee employee) {
        return repository.deleteEmployee(employee);
    }
}
