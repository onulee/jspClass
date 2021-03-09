package com.board.FController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.BCommand.BCommand;
import com.board.BCommand.BContentCommand;
import com.board.BCommand.BDeleteCommand;
import com.board.BCommand.BListCommand;
import com.board.BCommand.BModifyCommand;
import com.board.BCommand.BModifyViewCommand;
import com.board.BCommand.BReplyCommand;
import com.board.BCommand.BReplyViewCommand;
import com.board.BCommand.BWriteCommand;


@WebServlet("*.do")
public class FController extends HttpServlet {
	
	protected void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("actionDo");
		request.setCharacterEncoding("utf-8");
		
		boolean pageRedirect=false;
		String viewPage="";
		
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String com = uri.substring(conPath.length());
		BCommand command;
		
		//페이지링크 연결
		if(com.equals("/list.do")) {
			command = new BListCommand();
			command.execute(request, response);
			viewPage = "list.jsp";
		}else if(com.equals("/write_view.do")) {
			viewPage = "write_view.jsp";
		}else if(com.equals("/write.do")) {
			command = new BWriteCommand();
			command.execute(request, response);
			pageRedirect=true;
			viewPage = "list.do";
		}else if(com.equals("/content_view.do")) {
			command = new BContentCommand();
			command.execute(request, response);
			viewPage = "content_view.jsp";
		}else if(com.equals("/delete.do")) {
			command = new BDeleteCommand();
			command.execute(request, response);
			pageRedirect=true;
			viewPage = "list.do";
		}else if(com.equals("/modify_view.do")) {
			command = new BModifyViewCommand();
			command.execute(request, response);
			viewPage = "modify_view.jsp";
		}else if(com.equals("/modify.do")) {
			command = new BModifyCommand();
			command.execute(request, response);
			viewPage = "list.do";
		}else if(com.equals("/reply_view.do")) {
			command = new BReplyViewCommand();
			command.execute(request, response);
			viewPage = "reply_view.jsp";
		}else if(com.equals("/reply.do")) {
			command = new BReplyCommand();
			command.execute(request, response);
			viewPage = "list.do";
		}
		
		//forward진행
		if(pageRedirect==true) {
			response.sendRedirect(viewPage);
		}else {
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response);
		}
 	}
	
	//get
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet");
		actionDo(request,response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost");
		actionDo(request,response);
		
	}

}
