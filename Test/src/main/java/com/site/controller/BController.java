package com.site.controller;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	@RequestMapping("/event")
	public String event() {
		return "event";
	}
	
	@RequestMapping("/event_view")
	public String event_view() {
		return "event_view";
	}
	
	//댓글달기 
	@RequestMapping("/event_reply")
	@ResponseBody
	public Map<String, Object> event_reply(@RequestParam("replynum") String replynum,
			@RequestParam("replyType") String replyType) {
		Map<String, Object> map = new HashMap<String, Object>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String date = sdf.format(System.currentTimeMillis());
		System.out.println("replynum :"+replynum);
		map.put("replynum", replynum);
		map.put("replyType", replyType);
		map.put("comNo", 1);
		map.put("date", date);
		map.put("name", "홍길동");
		
		return map;
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
