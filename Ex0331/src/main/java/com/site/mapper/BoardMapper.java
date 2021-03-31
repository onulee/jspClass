package com.site.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.site.dto.BoardDto;

@Mapper
public interface BoardMapper {

	List<BoardDto> selectBoardListAll();
	

}
