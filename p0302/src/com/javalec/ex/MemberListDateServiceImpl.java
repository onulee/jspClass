package com.javalec.ex;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberListDateServiceImpl implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		MemberDao dao = new MemberDao();
		String check_search = request.getParameter("check_search");
		String search_data = request.getParameter("date");
		ArrayList<MemberDto> list = dao.MemberListAll(check_search,search_data);
		request.setAttribute("list", list);

	}

}
