package com.shop.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.shop.Dao.BoardDao;
import com.shop.Dto.BoardDto;

public class BModifyCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		BoardDao dao = new BoardDao();
		int chk=0; //성공,실패 체크변수
		
		//파일업로드 변수선언
		String uploadPath = request.getSession().getServletContext().getRealPath("upload");
		int size = 10*1024*1024; //10M
		String page,bId,bTitle,bContent,fileName="";
		try {
			MultipartRequest multi = new MultipartRequest(request, uploadPath,size,"utf-8",new DefaultFileRenamePolicy());
			page = multi.getParameter("page");
			bId = multi.getParameter("bId");
			bTitle = multi.getParameter("bTitle");
			bContent = multi.getParameter("bContent");
			fileName = multi.getFilesystemName("fileName");
			
			chk = dao.bModify(bId,bTitle,bContent,fileName); //update,insert,delete
			request.setAttribute("chk", chk);
			request.setAttribute("bId", bId);
			request.setAttribute("page", page);
			request.setAttribute("category", multi.getParameter("category"));
			request.setAttribute("search", multi.getParameter("search"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		

	}

}
