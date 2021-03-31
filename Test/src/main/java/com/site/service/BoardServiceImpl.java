package com.site.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService {

	@Override
	public Map testCheck(String id, String pw) {
		Map map = new HashMap<String, Object>();
		int txtCheck=-1;
		String message="로그인 실패했습니다.";
		if(id.equals("aaa") && pw.equals("1111")) {
			txtCheck=1;
			message="로그인 성공했습니다.";
		}
		map.put("txtCheck",txtCheck);
		map.put("message",message);
		return map;
	}

	
}
