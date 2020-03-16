package com.example.servingwebcontent;

import com.example.servingwebcontent.Employees;
import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called employeeRepository
// CRUD refers to Create, Read, Update, Delete

public interface EmployeeRepository extends CrudRepository<Employees, Integer> {

}