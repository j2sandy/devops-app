package io.nishandi.devopsapp.service.impl;

import io.nishandi.devopsapp.dto.EmployeeDto;
import io.nishandi.devopsapp.entity.Employee;
import io.nishandi.devopsapp.repository.EmployeeRepository;
import io.nishandi.devopsapp.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private static final Logger log = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    @Autowired
    private EmployeeRepository repository;

    @Override
    public Employee getEmployeeDetails(UUID id) {
        log.info("get employee details for {}",id);
        return repository.findById(id).orElse(null);
    }

    @Override
    public Employee saveEmployeeDetails(EmployeeDto dto) {
        Employee employee = new Employee(dto.getFirstName(),dto.getLastName());
        log.info("employee object created {}",employee);
        return repository.save(employee);
    }
}
