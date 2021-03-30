package com.site.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BoardController {

	@RequestMapping("/text")
	public String text() {
		return "text";
	}
	@RequestMapping("/ajax01")
	public String ajax01() {
		return "ajax01";
	}
	
	@RequestMapping("/ajax_ok")
	@ResponseBody
	public Map ajax_ok(String rname,String rcontent) {
		Map map = new HashMap<String, Object>(); 
		System.out.println("이름:"+rname+", 내용:"+rcontent);
		map.put("rname",rname);
		map.put("rcontent",rcontent);
		return map;
	}
	
}
