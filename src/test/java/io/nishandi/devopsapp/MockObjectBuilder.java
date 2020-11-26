package io.nishandi.devopsapp;

import io.nishandi.devopsapp.entity.Employee;

import java.util.UUID;

public class MockObjectBuilder {

    public static Employee getMockEmployee(){
        Employee employee = new Employee();
        employee.setFirstName("test");
        employee.setLastName("test");
        employee.setId(UUID.fromString("8f060eb1-f3aa-4835-be58-78baee6bf13f"));
        return employee;
    }
}
