package com.board.BCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.BDao.BDao;
import com.board.BDto.BDto;

public class BReplyViewCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		BDao dao = new BDao();
		String bId = request.getParameter("bId");
		BDto dto = dao.replyView(bId);
		request.setAttribute("dto", dto);

	}

}
