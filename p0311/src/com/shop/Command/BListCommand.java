package com.shop.Command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.Dao.BoardDao;
import com.shop.Dto.BoardDto;

public class BListCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		BoardDao dao = new BoardDao();
		int page=1;  //첫페이지 초기화
		int limit=10; //한페이지에 나오는 게시글수 : 10
		//[검색]
		String category = request.getParameter("category");
		String search = request.getParameter("search");
		
		//page데이터가 있으면 데이터값 적용
		if(request.getParameter("page")!=null && request.getParameter("page")!="") {
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		//게시글
		ArrayList<BoardDto> list = dao.list(page,limit,category,search);
		
		
		
		
		
		//전체리스트 개수메소드
		int listCount = dao.listCount(category,search);
		
		//최대페이지 수
		int maxpage = (int)((double)listCount/limit+0.95); //34/10+0.95=(int)4.35 -> 4페이지 
		//첫 페이지 번호 : 10페이지 10/10+0.9=(int)1.9 -> (1-1)*10+1 = 1
		int startpage = ((int)((double)page/10+0.9)-1) * 10 + 1;
		//마지막 페이지 번호 : 
		int endpage = maxpage;
		if(endpage>startpage+10-1) endpage = startpage+10-1;
		
		
		
		
		
		//전송
		request.setAttribute("listCount", listCount);
		request.setAttribute("maxpage", maxpage);
		request.setAttribute("startpage", startpage);
		request.setAttribute("endpage", endpage);
		request.setAttribute("page", page);
		request.setAttribute("list", list);
		request.setAttribute("category", category);
		request.setAttribute("search", search);

	}

}
