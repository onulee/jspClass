package com.site.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.site.dto.BoardDto;
import com.site.dto.MemberDto;
import com.site.mapper.Board_Mapper;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	Board_Mapper board_Mapper;
	
	@Override
	public ArrayList<BoardDto> boardList() {
		//dao.selectBoardList()
		ArrayList<BoardDto> list=board_Mapper.selectBoardList();
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		map.put("page", 1);
		map.put("startpage", 1);
		map.put("endpage", 10);
		map.put("maxpage", 30);
		
		
		return list;
	}

	@Override
	public BoardDto boardContentView(int bId) {
		System.out.println("boardContentView : "+bId);
		BoardDto dto = board_Mapper.selectBoardContentView(bId);
		System.out.println("boardContentView : "+dto.getbId());
		
		return dto;
	}

	@Override
	public MemberDto loginCheck(MemberDto dto) {
		MemberDto memberDto = board_Mapper.selectloginCheck(dto);
		return memberDto;
	}

}
