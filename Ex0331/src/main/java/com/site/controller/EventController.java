package com.site.controller;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.SimpleFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.site.dto.CommentDto;
import com.site.service.EventService;

@Controller
public class EventController {
	
	@Autowired
	EventService eventService;
	Map<String,Object> map;

	@RequestMapping("/event/event")
	public String event() {
		return "event/event";
	}
	
	@RequestMapping("/event/event_view")
	public String event_view(Model model) {
		map = new HashMap<String, Object>();
		int bid=149;
		List<CommentDto> list = eventService.event_CommentList(bid);
		int count = eventService.event_CommentCount(bid);
		
		map.put("list",list);
		map.put("count",count);
		model.addAttribute("map",map);
		System.out.println("controller count : "+count );
		return "event/event_view";
	}
	
	@RequestMapping("/event/commentWrite_check")
	@ResponseBody
	public Map<String,Object> commentWrite_check(CommentDto commentDto) {
		map = new HashMap<String, Object>();
		System.out.println("controller : "+commentDto.getCommentContent());
		
		CommentDto dto = eventService.commentWrite_check(commentDto);
		
		//DB에서 데이터를 받아올것.
		map.put("dto", dto);
		
		return map;
	}
	
	@RequestMapping("/event/commentUpdate_check")
	@ResponseBody
	public Map<String,Object> commentUpdate_check(CommentDto commentDto) {
		map = new HashMap<String, Object>();
		System.out.println("controller : "+commentDto.getCommentContent());
		
		CommentDto dto = eventService.commentUpdate_check(commentDto);
		
		//DB에서 데이터를 받아올것.
		map.put("dto", dto);
		
		return map;
	}
	
	
}
