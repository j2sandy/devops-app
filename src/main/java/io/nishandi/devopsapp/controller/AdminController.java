package io.nishandi.devopsapp.controller;

import io.nishandi.devopsapp.dto.EmployeeDto;
import io.nishandi.devopsapp.entity.Employee;
import io.nishandi.devopsapp.service.EmployeeService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(value = "${devops_app.base_url}")
public class AdminController {

    @Autowired
    private EmployeeService employeeService;

    @ApiOperation(value = "Find employee by ID", nickname = "getEmployeeDetails", notes = "Returns a single Employee", response = Employee.class, tags={ "employee", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successful operation", response = Employee.class),
            @ApiResponse(code = 400, message = "Invalid Employee ID supplied"),
            @ApiResponse(code = 404, message = "Employee not found") })
    @RequestMapping(value = "/employee/{employeeId}",
            produces = { "application/json" },
            method = RequestMethod.GET)
    ResponseEntity<Employee> getEmployeeDetails(@ApiParam(value = "ID of Employee to return",required=true) @PathVariable("employeeId") UUID employeeId){
        return ResponseEntity.ok(employeeService.getEmployeeDetails(employeeId));
    }

    @ApiOperation(value = "saves employee object", nickname = "saveEmployeeDetails")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successful operation")})
    @RequestMapping(value = "/employee",
            produces = { "application/json" },
            method = RequestMethod.POST)
    ResponseEntity<Employee> saveEmployeeDetails(@ApiParam(value = "Employee object to be saved",required=true) @RequestBody EmployeeDto dto){
        return ResponseEntity.ok(employeeService.saveEmployeeDetails(dto));
    }

}
