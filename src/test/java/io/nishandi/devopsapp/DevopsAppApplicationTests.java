package io.nishandi.devopsapp;

import io.nishandi.devopsapp.entity.Employee;
import io.nishandi.devopsapp.repository.EmployeeRepository;
import io.nishandi.devopsapp.service.impl.EmployeeServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import static io.nishandi.devopsapp.MockObjectBuilder.*;
import org.mockito.Mockito.*;

import java.util.UUID;

@SpringBootTest
class DevopsAppApplicationTests {

	@Mock
	private EmployeeRepository employeeRepository;

	@InjectMocks
	private EmployeeServiceImpl employeeService;

	@Test
	void contextLoads() {
	}

	@Test
	public void shoudReturnEmployeeDetails(){
		Employee mock = getMockEmployee();
		Mockito.when(employeeRepository.findById(UUID.fromString("8f060eb1-f3aa-4835-be58-78baee6bf13f"))).thenReturn(java.util.Optional.of(new Employee()));
	}

}
