package com.site.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.site.dto.BoardDto;

@Mapper
public interface BoardMapper {

	//list 리스트 가져오기
	List<BoardDto> selectBoardListAll(int startrow, int endrow);
	List<BoardDto> selectBoardListTitle(int startrow, int endrow, String search);

	//list 개수 가져오기
	int listCount();
	int listCountTitle(String search);
	List<BoardDto> selectBoardListContent(int startrow, int endrow, String search);
	int listCountContent(String search);
	List<BoardDto> selectBoardListSearchAll(int startrow, int endrow, String search);
	int listCountSearchAll(String search);
	
	//content_view
	BoardDto selectBoardContent_view(String bid);
	void selectUpHit(String bid);
	BoardDto selectBoard_pre(String bid);
	BoardDto selectBoard_next(String bid);
	BoardDto selectBoard_preTitle(String bid, String search);
	BoardDto selectBoard_nextTitle(String bid, String search);
	BoardDto selectBoard_preContent(String bid, String search);
	BoardDto selectBoard_nextContent(String bid, String search);
	BoardDto selectBoard_preAll(String bid, String search);
	BoardDto selectBoard_nextAll(String bid, String search);
	
	//write
	void insertBoardWrite(BoardDto boardDto);
	
	//update
	void updateBoardWrite(BoardDto boardDto);
	
	//reply
	void insertBoardReply(BoardDto boardDto);
	void insertBoardReplyPlus(BoardDto boardDto);
	void deleteBoardDelete(String bid);
	

}
