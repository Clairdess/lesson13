package com.vkatit.repository;

import com.vkatit.model.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class EmployeeRepository {

    private final NamedParameterJdbcTemplate template;

    private final String SQL_FIND_EMPLOYEE = "SELECT * FROM hr.employees WHERE EMPLOYEE_ID =  :employee_id";
    private final String SQL_DELETE_EMPLOYEE = "delete from employees where employee_id = :employee_id";
    private final String SQL_GET_ALL = "SELECT * FROM hr.employees";
    private final String SQL_INSERT_EMPLOYEE = "INSERT INTO hr.employees(employee_id, first_name, last_name, " +
            "email, phone_number,hire_date, job_id, salary, commission_pct, manager_id, department_id) " +
            "values(:employee_id, :first_name, :last_name, :email, :phone_number, :hire_date, :job_id," +
            ":salary, :commission_pct, :manager_id, :department_id)";

    public Employee getEmployeeById(Long id) {
        Map<String, Object> argMap = new HashMap<>();
        argMap.put("employee_id", id);
        return template.queryForObject(SQL_FIND_EMPLOYEE, argMap, new EmployeeMapper());
    }

    public List<Employee> getAllEmployees() {
        return template.query(SQL_GET_ALL, new EmployeeMapper());
    }

    public boolean deleteEmployee(Employee employee) {
        Map<String, Object> argMap = new HashMap<>();
        argMap.put("employee_id", employee.getEmployeeId());
        return template.update(SQL_DELETE_EMPLOYEE, argMap) > 0;
    }

    public int createEmployee(Employee employee) {
        Map<String, Object> argMap = new HashMap<>();
        argMap.put("employee_id", employee.getEmployeeId());
        argMap.put("first_name", employee.getFirstName());
        argMap.put("last_name", employee.getLastName());
        argMap.put("email", employee.getEmail());
        argMap.put("phone_number", employee.getPhoneNumber());
        argMap.put("hire_date", employee.getHireDate());
        argMap.put("job_id", employee.getJobId());
        argMap.put("salary", employee.getSalary());
        argMap.put("commission_pct", employee.getCommissionPCT());
        argMap.put("manager_id", employee.getManagerId());
        argMap.put("department_id", employee.getDepartmentId());
        return template.update(SQL_INSERT_EMPLOYEE, argMap);
    }
}
