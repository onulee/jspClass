package com.site.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.site.dto.MemberDto;

@Mapper
public interface MemberMapper {

	//로그인체크
	MemberDto selectLoginCheck(MemberDto memberDto);
	
	//전체회원 리스트
	ArrayList<MemberDto> selectMemberListAll();
	
	//전체회원 수
	int selectMemberListCount();
	
}
