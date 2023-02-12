package com.example.demo.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Exceptions.EmployeeIdNotFoundException;
import com.example.demo.Exceptions.NoEmployeeFoundException;
import com.example.demo.entities.Employee;
import com.example.demo.services.EmployeeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class EmployeeController {
	@Autowired
	EmployeeService es;
	@Operation(summary="Adding Employee in the REST API DB")
	@PostMapping(value="/employees")
	public ResponseEntity<String> addEmployee(@Valid @RequestBody Employee emp)
	{
		String msg=es.insertEmployee(emp);
		ResponseEntity<String> rEntity=new ResponseEntity<String>(msg,HttpStatus.CREATED);
		return rEntity;
	}
	@Operation(summary="fetching all the Employee from  REST API DB")
	@GetMapping(value="/employees")
	public List<Employee> fetchAllEmployees() throws NoEmployeeFoundException
	{
		return es.findAll();
	}
	@Operation(summary="fetching Employee on basis of Id from the REST API DB")
	@ApiResponses(value= {
		@ApiResponse(responseCode="200",description="OK",content=@Content(mediaType="application/json",schema=@Schema(oneOf = Employee.class))),
		@ApiResponse(responseCode="404",description="NOT_FOUND",content=@Content(mediaType="application/json",schema=@Schema(oneOf = EmployeeIdNotFoundException.class)))
	})
	@GetMapping("/employees/{id}")						//employees/105
	public ResponseEntity<Employee> findEmployeeById(@PathVariable("id") int id) throws EmployeeIdNotFoundException
	{
		Employee msg =es.findByEmployeeId(id);
		ResponseEntity<Employee> rEntity=new ResponseEntity<Employee>(msg,HttpStatus.FOUND);
		return rEntity;
	}
	@GetMapping("/employees/byName/{empName}")
	public ResponseEntity<Employee> findEmployeeByName(@PathVariable("empName") String eName) throws EmployeeIdNotFoundException
	{
		Employee msg =es.findByEmployeeName(eName);
		ResponseEntity<Employee> rEntity=new ResponseEntity<Employee>(msg,HttpStatus.FOUND);
		return rEntity;
	}
	@GetMapping("/employees/byEmployeeSalary/InRange/{sRange}/{eRange}")
	public List<Employee> findEmployeeBySalaryInRange(@PathVariable("sRange")int sR,@PathVariable("eRange")int eR) 
	{
		return es.findEmployeesInRange(sR,eR);
	}
	@PutMapping("/employees/{id}")					//employees/105
	public String modifyEmployee(@PathVariable("id") int id,@RequestBody Employee emp) throws EmployeeIdNotFoundException
	{
		return es.updateEmployee(id,emp);
	}
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<String> deleteEmployeeById(@PathVariable("id") int id) throws EmployeeIdNotFoundException
	{
		String msg =es.deleteById(id);
		ResponseEntity<String> rEntity=new ResponseEntity<String>(msg,HttpStatus.ACCEPTED);
		return rEntity;
	}
	@DeleteMapping("/employees/byName/{ename}")
	public String deleteEmployeeById(@PathVariable("ename") String ename) throws EmployeeIdNotFoundException
	{
		return es.deleteByName(ename);
	}
	
	
}