package com.javalec.ex;

import java.sql.Timestamp;

public class MemberDto {
	
	private int employee_id;
	private String emp_name;
	private String phone_number;
	private Timestamp hire_date;
	private double salary;
	public MemberDto(int employee_id, String emp_name, String phone_number, Timestamp hire_date,double salary) {
		this.employee_id = employee_id;
		this.emp_name = emp_name;
		this.phone_number = phone_number;
		this.hire_date = hire_date;
		this.salary = salary;
	}
	
	public int getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public Timestamp getHire_date() {
		return hire_date;
	}
	public void setHire_date(Timestamp hire_date) {
		this.hire_date = hire_date;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}

}
