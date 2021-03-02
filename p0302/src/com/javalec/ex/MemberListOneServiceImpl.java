package com.javalec.ex;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberListOneServiceImpl implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		MemberDao dao = new MemberDao();
		MemberDto dto = dao.MemberListOne(request.getParameter("name"));
		System.out.println(request.getParameter("name"));
		System.out.println("service : "+dto.getEmp_name());
		request.setAttribute("dto", dto);
		

	}

}
