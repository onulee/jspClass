package com.site.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.site.dto.BoardDto;
import com.site.dto.MemberDto;
import com.site.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	BoardService boardService;
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	@RequestMapping("/content_view")
	public String content_view(HttpServletRequest request,Model model) {
		int bId = Integer.parseInt(request.getParameter("bId"));
		System.out.println("content_view : "+bId);
		BoardDto dto = boardService.boardContentView(bId);
		System.out.println("dto.getbId() : "+ dto.getbId());
		model.addAttribute("dto",dto);
		return "content_view";
	}
	
	@RequestMapping("/list")
	public String list(Model model) {
		ArrayList<BoardDto> list = boardService.boardList();
		model.addAttribute("list",list);
		return "list";
	}
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate();
		return "redirect:/";
	}
	@RequestMapping("/login_check2")
	public String login_check2() {
		return "login_check2";
	}
	
	@RequestMapping("/login_check")
	public String login_check(MemberDto dto,HttpServletRequest request) {
		HttpSession session = request.getSession();
		MemberDto memberdto = boardService.loginCheck(dto);
		
		if(memberdto==null) {
			System.out.println("실패");
			session.setAttribute("session_flag", "fail");
		}else {
			System.out.println("성공");
			session.setAttribute("session_flag", "success");
			session.setAttribute("session_id", memberdto.getId());
			session.setAttribute("session_name", memberdto.getName());
		}
		return "redirect:/login_check2"; 
	}
}
