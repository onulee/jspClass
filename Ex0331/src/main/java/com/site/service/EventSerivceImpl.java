package com.site.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.site.dto.CommentDto;
import com.site.mapper.EventMapper;

@Service
public class EventSerivceImpl implements EventService {

	@Autowired
	EventMapper eventMapper;
	ArrayList<CommentDto> list;
	
	@Override
	public CommentDto commentWrite_check(CommentDto commentDto) {
		
		// 댓글 insert
		eventMapper.insertCommentWrite(commentDto);
		// keyProperty="commentNo" -> commentDto.getCommentNo 로 읽을수 있음
		int commentNo = commentDto.getCommentNo();
		System.out.println("commentDto.getCommentNo() : " + commentDto.getCommentNo());
		
		// 저장된 insert -> select 해서 가져옴
		CommentDto dto = eventMapper.selectCommentWrite(commentNo);
		System.out.println("dto : " + dto.getCommentDate());
		return dto;
	}

	@Override
	public List<CommentDto> event_CommentList(int bid) {
		list = eventMapper.selectEvent_CommentList(bid);
		System.out.println("getCommentNo() impl : "+list.get(0).getCommentNo());
		return list;
	}

	@Override
	public int event_CommentCount(int bid) {
		int count = eventMapper.selectEvent_CommentCount(bid);
		System.out.println("impl : "+count);
		return count;
	}

	@Override
	public CommentDto commentUpdate_check(CommentDto commentDto) {
		// 댓글 insert
		eventMapper.updateCommentUpdate(commentDto);
		int commentNo = commentDto.getCommentNo();
		// 저장된 insert -> select 해서 가져옴
		CommentDto dto = eventMapper.selectCommentWrite(commentNo);
		System.out.println("dto : " + dto.getCommentDate());
		
		return dto;
		
	}

}
