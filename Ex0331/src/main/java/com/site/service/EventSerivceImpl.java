package com.site.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.site.dto.CommentDto;
import com.site.mapper.EventMapper;

@Service
public class EventSerivceImpl implements EventService {

	@Autowired
	EventMapper eventMapper;
	
	@Override
	public CommentDto commentWrite_check(CommentDto commentDto) {
		
		// 댓글 insert
		eventMapper.insertCommentWrite(commentDto);
		// keyProperty="commentNo" -> commentDto.getCommentNo 로 읽을수 있음
		int commentNo = commentDto.getCommentNo();
		System.out.println("commentDto.getCommentNo() : " + commentDto.getCommentNo());
		
		// 저장된 insert -> select 해서 가져옴
		CommentDto dto = eventMapper.selectCommentWrite(commentNo);
		return dto;
	}

}
