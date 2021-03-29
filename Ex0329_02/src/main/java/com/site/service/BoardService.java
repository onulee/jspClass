package com.site.service;

import java.util.HashMap;

import org.springframework.web.multipart.MultipartFile;

import com.site.dto.BoardDto;

public interface BoardService {

	HashMap<String, Object> boardList(String page,String category,String search);
	
	HashMap<String, Object> boardFileWrite(BoardDto boardDto,MultipartFile file);

}
