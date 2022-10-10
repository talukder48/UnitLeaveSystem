package com.panacea.repository.hrm;

import org.springframework.data.jpa.repository.JpaRepository;

import com.panacea.model.hrm.Employee;

public interface EmployeeRepo extends JpaRepository <Employee,String>{

}
