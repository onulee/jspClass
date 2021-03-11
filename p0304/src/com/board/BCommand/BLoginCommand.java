package com.board.BCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.board.BDao.BDao;
import com.board.BDto.BDto;
import com.board.BDto.LoginDto;

public class BLoginCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		 String login_id = request.getParameter("login_id");
		 String login_pw = request.getParameter("login_pw");
		 System.out.println(login_id);
		 BDao dao = new BDao();
		 LoginDto ldto = dao.bLogin(login_id,login_pw);
		 
		 HttpSession session = request.getSession();
		 if(ldto==null) {
			session.setAttribute("session_flag", "fail");
		 }else {
			 session.setAttribute("session_flag", "success");
			 session.setAttribute("session_id", ldto.getLogin_id());
			 session.setAttribute("session_nickName", ldto.getLogin_nickName());
			 
		 }
		 
		 

	}

}
