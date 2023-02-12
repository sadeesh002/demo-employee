package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name ="Emp_Details")

@Getter
@Setter
//@Data


public class Employee {
	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	@Min(value=1,message="employeeId must have positive values")
	private int employeeId;
	@NotEmpty
	private String employeeName;
	@Min(value=2000)
	@Max(value=80000)
	private int employeeSalary;
	
//	public int getEmployeeId() {
//		return employeeId;
//	}
//	public void setEmployeeId(int employeeId) {
//		this.employeeId = employeeId;
//	}
//	public String getEmployeeName() {
//		return employeeName;
//	}
//	public void setEmployeeName(String employeeName) {
//		this.employeeName = employeeName;
//	}
//	public int getEmployeeSalary() {
//		return employeeSalary;
//	}
//	public void setEmployeeSalary(int employeeSalary) {
//		this.employeeSalary = employeeSalary;
//	}
}
