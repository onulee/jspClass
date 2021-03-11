package com.board.BCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.BDao.BDao;
import com.board.BDto.BDto;

public class BContentCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		BDao dao = new BDao();
		String page = request.getParameter("page");
		String bId = request.getParameter("bId");
		String category = request.getParameter("category");
		String search = request.getParameter("search");
		BDto dto = dao.contentView(bId);
		request.setAttribute("page", page); //넘어온 페이지
		request.setAttribute("dto", dto);
		request.setAttribute("category", category);
		request.setAttribute("search", search);

	}

}
