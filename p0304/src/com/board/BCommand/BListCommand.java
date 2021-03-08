package com.board.BCommand;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.BDao.BDao;
import com.board.BDto.BDto;

public class BListCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		BDao dao = new BDao(); //dao사용을 위한 선언
		ArrayList<BDto> list = dao.boardList(); //dao에 있는 boardList메소드 호출
		request.setAttribute("list", list); //넘어온 데이터를 request에 저장

	}

}
