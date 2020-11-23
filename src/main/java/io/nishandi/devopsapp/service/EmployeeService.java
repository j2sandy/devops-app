package io.nishandi.devopsapp.service;

import io.nishandi.devopsapp.dto.EmployeeDto;
import io.nishandi.devopsapp.entity.Employee;

import java.util.UUID;

public interface EmployeeService {
    Employee getEmployeeDetails(UUID employeeId);

    Employee saveEmployeeDetails(EmployeeDto dto);
}
