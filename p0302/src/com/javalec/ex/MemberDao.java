package com.javalec.ex;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDao {
	
	Context context;
	DataSource ds;
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	ArrayList<MemberDto> list = new ArrayList<MemberDto>();
	MemberDto dto;
	int employee_id;
	String emp_name,email,phone_number;
	Timestamp hire_date;
	double salary;
	String query;
	int chk;
	
	public MemberDao(){ //생성자
		try {
			context = new InitialContext();
			ds = (DataSource) context.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//입사일 검색
	
	
	//전체회원 리스트 - employees모든 사람들
	public ArrayList<MemberDto> MemberListAll(String check_search,String search_data) {
		list = new ArrayList<MemberDto>();
		
		switch (check_search) {
		case "1":
			query="select employee_id,emp_name,phone_number,hire_date,salary from employees where emp_name like ?";
			search_data = "%"+search_data+"%";  // '%r%'
			break;
		case "2":	
		    query="select * from employees where hire_date > ?";
			break;

		default:
			query="select employee_id,emp_name,phone_number,hire_date,salary from employees";
			break;
		}
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(query);
			if(!(check_search.equals("0"))) {
				System.out.println(check_search);
			    pstmt.setString(1, search_data);
			}
			System.out.println(search_data);
			System.out.println(query);
			rs = pstmt.executeQuery();
			System.out.println("dao : "+query);
			while(rs.next()) {
				employee_id = rs.getInt("employee_id");
				emp_name = rs.getString("emp_name");
				phone_number = rs.getString("phone_number");
				hire_date = rs.getTimestamp("hire_date");
				salary = rs.getDouble("salary");
				list.add(new MemberDto(employee_id, emp_name, phone_number, hire_date, salary));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return list;
	}//MemberListAll
	
	public MemberDto MemberListOne(String emp_name) {
		dto=null;
		try {
			conn = ds.getConnection();
			String query="select employee_id,emp_name,phone_number,hire_date,salary from employees where emp_name=?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, emp_name);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				employee_id = rs.getInt("employee_id");
				emp_name = rs.getString("emp_name");
				phone_number = rs.getString("phone_number");
				hire_date = rs.getTimestamp("hire_date");
				salary = rs.getDouble("salary");
				dto = new MemberDto(employee_id, emp_name, phone_number, hire_date, salary);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return dto;
	} //MemberListOne
	
	
	
	
	
	
	

}
