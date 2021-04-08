package com.site.service;

import java.util.List;

import com.site.dto.CommentDto;

public interface EventService {

	CommentDto commentWrite_check(CommentDto commentDto);

	List<CommentDto> event_CommentList(int bid);

	int event_CommentCount(int bid);

	CommentDto commentUpdate_check(CommentDto commentDto);

}
