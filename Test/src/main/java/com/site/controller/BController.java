package com.site.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.site.service.BoardService;

@Controller
public class BController {

	@Autowired
	BoardService boardService;
	
	@RequestMapping("/ajax")
	public String ajax() {
		return "ajax";
	}
	@RequestMapping("/index")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/testAjax")
	@ResponseBody
	public String testAjax(String date,String location) throws Exception {
		
		DataDto d = new DataDto();
		return d.data_tour(date,location);
		
//		Map map = new HashMap<String, Object>();
//		System.out.println("controller : "+id+","+pw);
//		map = boardService.testCheck(id,pw);
//		map.put("id", id);
//		map.put("pw", pw);
		
	}
	
}
