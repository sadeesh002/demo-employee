package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Employee;

@Repository("ed")
public interface EmployeeDao extends JpaRepository<Employee, Integer>{
	
	Optional<Employee> findByEmployeeName(String ename);
	
	List<Employee> findAllByEmployeeSalary(int salary);
	
	Optional<Employee> findByEmployeeNameAndEmployeeSalary(String ename,int salary);
	
	
	@Query("select obj from Employee obj where obj.employeeSalary between :stR and :endR")
	List<Employee> getBySalaryInRange(@Param("stR")int stRange,@Param("endR")int endRange);
	
	
	@Transactional
	void deleteByEmployeeName(String ename);
	
	boolean existsByEmployeeName(String ename);
}
