package com.site.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.site.dto.MemberDto;
import com.site.mapper.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberMapper memberMapper;
	Map map = new HashMap<String, Object>();
	
	@Override
	public int loginCheck(MemberDto memberDto) {
		System.out.println("loginCheck : "+memberDto.getId());
		MemberDto dto = memberMapper.selectLoginCheck(memberDto);
		int result=0;
		if(dto!=null) {
			result=1;   // id와 패스워드가 일치합니다.
		}else {
			result=-1;  // id와 패스워드가 일치하지 않습니다.
		}
		System.out.println("result : "+result);
		return result;
	}

	@Override
	public Map memberListAll() {
		 ArrayList<MemberDto> list = memberMapper.selectMemberListAll();
		 int count = memberMapper.selectMemberListCount();
		 map.put("list",list);
		 map.put("count",count);
		 return map;
	}

}
