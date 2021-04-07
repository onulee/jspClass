package com.site.controller;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.SimpleFormatter;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.site.dto.CommentDto;

@Controller
public class EventController {

	@RequestMapping("/event/event")
	public String event() {
		return "event/event";
	}
	
	@RequestMapping("/event/event_view")
	public String event_view() {
		return "event/event_view";
	}
	
	@RequestMapping("/event/commentWrite_check")
	@ResponseBody
	public Map<String,Object> commentWrite_check(CommentDto commentDto) {
		Map map = new HashMap<String, Object>();
		System.out.println("commentDto : " + commentDto.getId());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd  hh:mm:ss");
		String commentDate = sdf.format(System.currentTimeMillis()); 
		
		//DB에서 데이터를 받아올것.
		map.put("commentNo", "1");
		map.put("id", commentDto.getId());
		map.put("commentContent", commentDto.getCommentContent());
		map.put("commentDate", commentDate);
		
		return map;
	}
	
	
}
