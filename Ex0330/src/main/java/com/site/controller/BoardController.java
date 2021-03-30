package com.site.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.site.dto.MemberDto;
import com.site.service.MemberService;

@Controller
public class BoardController {

	@Autowired
	MemberService memberService;
	Map map = new HashMap<String, Object>();
	
	@RequestMapping("/form")
	public String form() {
		return "form";
	}
	@RequestMapping("/index")
	public String index() {
		return "index";
	}
	@RequestMapping("/list")
	public String list() {
		return "list";
	}
	@RequestMapping("/memberInfo")
	public String memberInfo(Model model) {
		
		map = memberService.memberListAll();
		model.addAttribute("map",map);
		return "memberInfo";
	}
	
	@RequestMapping("/formOk")
	public String formOk(MemberDto memberDto,Model model) {
		int result = memberService.loginCheck(memberDto);
		model.addAttribute("memberDto",memberDto); //입력한 id,pw
		model.addAttribute("result",result);       //확인결과 값
		
		return "formOk";
	}
	
	
	
	
	
}
