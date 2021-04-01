package com.site.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.site.dto.BoardDto;
import com.site.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	BoardService boardService;
	Map<String,Object> map;
	
	@RequestMapping("/index")
	public String index() {
		return "/index";
	}
	@RequestMapping("/board/content_view")
	public String content_view(@RequestParam @Nullable String page,
			@RequestParam @Nullable String category,
			@RequestParam @Nullable String search,
			@RequestParam @Nullable String bid, Model model) {
		map = boardService.boardContent_view(bid,page,category,search);
		model.addAttribute("map",map);
		return "board/content_view";
	}
	@RequestMapping("/board/write_view")
	public String write_view() {
		return "board/write_view";
	}
	
	@RequestMapping("/board/write")
	public String write(BoardDto boardDto,@RequestPart MultipartFile file) {
     	  boardService.boardWrite(boardDto,file);
		return "redirect:/board/list";
	}
	
	@RequestMapping("/board/list")
	public String list(@RequestParam @Nullable String page,
			@RequestParam @Nullable String category,
			@RequestParam @Nullable String search,Model model) {
		System.out.println("page : "+page);
		map = boardService.boardListAll(page,category,search);
		model.addAttribute("map",map);
		return "board/list";
	}
	
	
}
