package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Exceptions.EmployeeIdNotFoundException;
import com.example.demo.Exceptions.NoEmployeeFoundException;
import com.example.demo.dao.EmployeeDao;
import com.example.demo.entities.Employee;

@Service("es")
public class EmployeeService{
	@Autowired
	EmployeeDao ed;

	public String insertEmployee(Employee emp) {
		Employee dbEmp= ed.save(emp);
		return "Added Successfully with Id :"+dbEmp.getEmployeeId() ;
	}

	public List<Employee> findAll() throws NoEmployeeFoundException {
		//return ed.findAll();
		List<Employee> list=ed.findAll();
		if(list.isEmpty()) {
			throw new NoEmployeeFoundException("No employee found");
			
		}
		return list;
	}

	public Employee findByEmployeeId(int id) throws EmployeeIdNotFoundException {
		// TODO Auto-generated method stub
		Optional<Employee> op= ed.findById(id);
		if(op.isPresent())
			return op.get();
		else
			throw new EmployeeIdNotFoundException("Employee Not Found for Id:"+id);
	}

	public Employee findByEmployeeName(String eName) throws EmployeeIdNotFoundException {
		// TODO Auto-generated method stub
		Optional<Employee> op= ed.findByEmployeeName(eName);
		if(op.isPresent())
			return op.get();
		else
			throw new EmployeeIdNotFoundException("Employee Not Found for name:"+eName);
			//return null;
	}

	public String updateEmployee(int id, Employee emp) throws EmployeeIdNotFoundException {
		// TODO Auto-generated method stub
			if(id==emp.getEmployeeId())
			{
				if(ed.existsById(id)) {
				Employee upEmp= ed.save(emp);
				return "Updated Successfully for id: "+upEmp.getEmployeeId();
				}
				throw new EmployeeIdNotFoundException("Employee Not Found for Id:"+id);
				
				}
			return "Id must be same in Path Variable and in the request body";
			
	}

	public String deleteById(int id) throws EmployeeIdNotFoundException {
		// TODO Auto-generated method stub
		if(ed.existsById(id))
		{
		ed.deleteById(id);
		return "Deleted Successfully for Id: "+id;
		}
		throw new EmployeeIdNotFoundException("Employee Not Found for Id:"+id);
	}

	public List<Employee> findEmployeesInRange(int sR, int eR) {
		// TODO Auto-generated method stub
		return ed.getBySalaryInRange(sR, eR) ;
	}

	public String deleteByName(String ename) throws EmployeeIdNotFoundException {
		// TODO Auto-generated method stub
		if(ed.existsByEmployeeName(ename))
		{
		ed.deleteByEmployeeName(ename);
		return "Deleted Successfully for name: "+ename;
		}
		throw new EmployeeIdNotFoundException("Employee Not Found for name:"+ename);
	}

}