package com.vkatit.repository;

import com.vkatit.model.Employee;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeMapper implements RowMapper<Employee> {
    @Override
    public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Employee.builder()
                .employeeId(rs.getLong("employee_id"))
                .firstName(rs.getString("first_name"))
                .lastName(rs.getString("last_name"))
                .email(rs.getString("email"))
                .phoneNumber(rs.getString("phone_number"))
                .hireDate(rs.getString("hire_date"))
                .jobId(rs.getString("job_id"))
                .salary(rs.getFloat("salary"))
                .commissionPCT(rs.getFloat("commission_pct"))
                .managerId(rs.getLong("manager_id"))
                .departmentId(rs.getLong("department_id"))
                .build();
    }
}
