package com.vkatit.controller;

import com.vkatit.exception.NotFoundException;
import com.vkatit.model.Employee;
import com.vkatit.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("employee")
public class EmployeeController implements CommonController<Employee> {

    private final EmployeeService service;

    @PostMapping
    @Override
    public ResponseEntity<Integer> create(@RequestBody Employee entity) {
        return ResponseEntity.ok(service.save(entity));
    }

    @GetMapping
    @Override
    public ResponseEntity<List<Employee>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("{id}")
    @Override
    public ResponseEntity<Employee> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @DeleteMapping
    @Override
    public ResponseEntity<String> delete(@RequestBody Employee employee) {
        if (service.delete(employee)) {
            return ResponseEntity.ok("Deleted");
        } else throw new NotFoundException();
    }
}
