package com.site.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.site.dto.MemberDto;
import com.site.mapper.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	MemberMapper memberMapper;

	@Override
	public MemberDto loginCheck(MemberDto dto) {
		
		MemberDto memberDto = memberMapper.selectLoginCheck(dto);
		
		return memberDto;
	}
}
