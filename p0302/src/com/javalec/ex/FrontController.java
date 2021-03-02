package com.javalec.ex;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("*.do")
public class FrontController extends HttpServlet {
	
	String viewPage;
	Service command;
	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet");
		actionDo(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost");
		actionDo(request,response);
	}

	protected void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("actionDo");
		
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String com = uri.substring(conPath.length()); //fileName - /list.do
		
		if(com.equals("/list.do")) {
			command = new MemberListServiceImpl();
			command.execute(request, response); //request -> list
			viewPage = "list.jsp";
		}else if(com.equals("/listOne.do")){
			command = new MemberListOneServiceImpl();
			command.execute(request, response);
			viewPage = "list2.jsp";
		}else if(com.equals("/dateSearch.do")){
			command = new MemberListDateServiceImpl();
			command.execute(request, response);
			viewPage = "list.jsp";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
		
	}//actionDo
}
