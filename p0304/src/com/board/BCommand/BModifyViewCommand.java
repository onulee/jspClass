package com.board.BCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.BDao.BDao;
import com.board.BDto.BDto;

public class BModifyViewCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		BDao dao = new BDao();
		String bId = request.getParameter("bId");
		BDto dto = dao.modifyView(bId);
		request.setAttribute("dto", dto);

	}

}
