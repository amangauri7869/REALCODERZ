package com.real.dao;

import java.util.List;

import org.apache.log4j.Logger;

import com.real.model.Company;
import com.real.model.Register;

public interface AdminDao {
	
	
	boolean update(Register r);
	boolean updateCompany(Company c);
	Register getEmployeeById(int id);
	Company getUsersByCompany(int id);
	boolean delete(int id);
	boolean deleteCompany(int companyid);
	List<Register> getAllUsers();
	List<Company> getAllCompany();

	
}
