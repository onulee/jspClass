package com.site.service;

import java.util.ArrayList;

import com.site.dto.BoardDto;
import com.site.dto.MemberDto;

public interface BoardService {

	ArrayList<BoardDto> boardList();
	
	BoardDto boardContentView(int bId);
	
	MemberDto loginCheck(MemberDto dto);
}
