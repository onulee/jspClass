package com.shop.FController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.Command.BContentViewCommand;
import com.shop.Command.BDeleteCommand;
import com.shop.Command.BListCommand;
import com.shop.Command.BModifyCommand;
import com.shop.Command.BModifyViewCommand;
import com.shop.Command.BReplyCommand;
import com.shop.Command.BReplyViewCommand;
import com.shop.Command.BWriteCommand;
import com.shop.Command.Command;
import com.shop.Command.LoginCommand;



@WebServlet("*.do")
public class FController extends HttpServlet {
	
	protected void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("actionDo");
		request.setCharacterEncoding("utf-8");
		
		String requestUri = request.getRequestURI(); // contextPath/login.do
		String contextPath = request.getContextPath();
		String com = requestUri.substring(contextPath.length());
		Command command=null;
		String viewPage=null;
		boolean pageRedirect=false;
		
		if(com.equals("/login.do")) {
			command = new LoginCommand();
			command.execute(request, response);
			viewPage="login_check.jsp";
		}else if(com.equals("/list.do")) {
			command = new BListCommand();
			command.execute(request, response);
			viewPage="list.jsp";
		}else if(com.equals("/write.do")) {
			command = new BWriteCommand();
			command.execute(request, response);
			viewPage="write_check.jsp";
			//pageRedirect=true;
		}else if(com.equals("/write_view.do")) {
			viewPage="write_view.jsp";
		}else if(com.equals("/content_view.do")) {
			command = new BContentViewCommand();
			command.execute(request, response);
			viewPage="content_view.jsp";
		}else if(com.equals("/delete.do")) {
			command = new BDeleteCommand();
			command.execute(request, response);
			viewPage="list.do";
		}else if(com.equals("/bReplyView.do")) {
			command = new BReplyViewCommand();
			command.execute(request, response);
			viewPage="reply_view.jsp";
		}else if(com.equals("/reply.do")) {
			command = new BReplyCommand();
			command.execute(request, response);
			viewPage="list.do?category="+request.getAttribute("category")+"&search="+request.getAttribute("search")+"&bId="+request.getAttribute("bId")+"&page="+request.getAttribute("page");
			pageRedirect=true;
		}else if(com.equals("/bModify_view.do")) {
			command = new BModifyViewCommand();
			command.execute(request, response);
			viewPage="modify_view.jsp";
		}else if(com.equals("/modify.do")) {
			command = new BModifyCommand();
			command.execute(request, response);
			viewPage="content_view.do?category="+request.getAttribute("category")+"&search="+request.getAttribute("search")+"&bId="+request.getAttribute("bId")+"&page="+request.getAttribute("page");
		}else if(com.equals("/search.do")) {
			command = new BListCommand();
			command.execute(request, response);
			viewPage="list.jsp";
		}
		
		
		//주소이동
		if(pageRedirect==true) {
			response.sendRedirect(viewPage);
		}else {
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response);
		}
		//주소이동하는 방법 2가지 - sendRedirect, forward-jsp
		
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet");
		actionDo(request,response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost");
		actionDo(request,response);
	}

}
