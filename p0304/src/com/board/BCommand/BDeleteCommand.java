package com.board.BCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.board.BDao.BDao;
import com.board.BDto.BDto;

public class BDeleteCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		BDao dao = new BDao();
		String bId = request.getParameter("bId");
		dao.delete(bId);
	}

}
