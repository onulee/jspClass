package com.site.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.site.dto.BoardDto;
import com.site.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	BoardService boardService;
	
	@RequestMapping("/board/index")
	public String index() {
		return "board/index";
	}
	
	@RequestMapping("/board/list")
	public String list(Model model) {
		List<BoardDto> list = boardService.boardListAll();
		model.addAttribute("list",list);
		return "board/list";
	}
	
	
}
