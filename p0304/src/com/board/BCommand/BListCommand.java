package com.board.BCommand;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.board.BDao.BDao;
import com.board.BDto.BDto;

public class BListCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		BDao dao = new BDao(); //dao사용을 위한 선언
		int page=1;
		int limit=10; // 게시글 개수
		
		if(request.getParameter("page")!=null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		//총게시글 수 메소드
		int listCount = dao.listCount();
		ArrayList<BDto> list = dao.boardList(page,limit); //dao에 있는 boardList메소드 호출
		//list하단 페이지 넘버링
		int maxPage = (int)((double)listCount/limit+0.95); //121/10+0.95=13.05 -> 13페이지
		int startPage = (((int)((double)page/10+0.9))-1)*10+1; //1,11,21,31... 10개씩 묶음
		int endPage = maxPage;
		
		if(endPage>(startPage+10-1)) {    //1,2,...12
			endPage = startPage + 10 - 1; //10,20,30.... 10단위로 변경
		}
		
		request.setAttribute("page", page); //넘어온 페이지
		request.setAttribute("listCount", listCount); // 총 게시글수
		request.setAttribute("maxPage", maxPage); // 총 페이지
		request.setAttribute("startPage", startPage); // 시작되는 페이지 - 1,11,21..
		request.setAttribute("endPage", endPage); // 끝나는 페이지 - 10,20,30..
		request.setAttribute("list", list); //넘어온 데이터를 request에 저장

	}

}
