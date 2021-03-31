package com.site.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.site.dto.MemberDto;

@Mapper
public interface MemberMapper {

	MemberDto selectLoginCheck(MemberDto dto);

}
