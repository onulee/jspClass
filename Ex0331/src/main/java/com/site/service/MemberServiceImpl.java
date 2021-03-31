package com.site.service;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.site.dto.MemberDto;
import com.site.mapper.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	MemberMapper memberMapper;

	@Override
	public Map loginCheck(MemberDto dto) {
		Map map = new HashMap<String, Object>();
		MemberDto memberDto = memberMapper.selectLoginCheck(dto);
		int loginCheck=-1;
		if(memberDto != null) {
			loginCheck = 1;  //dto에 데이터가 있으면 성공!
		}
		
		map.put("memberDto", memberDto);
		map.put("loginCheck", loginCheck);
		
		return map;
	}
}
