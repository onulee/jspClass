package com.shop.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.shop.Dao.BoardDao;

public class BReplyCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		BoardDao dao = new BoardDao();
		
		int chk=0; //성공,실패 체크변수
		//파일업로드 관련변수
		String uploadPath = request.getSession().getServletContext().getRealPath("upload");
		int size = 10*1024*1024; //10M
		String bName,bTitle,bContent,fileName="";
		String page,bId,bGroup,bStep,bIndent="";
		try {
			MultipartRequest multi = new MultipartRequest(request, uploadPath,size,"utf-8",new DefaultFileRenamePolicy());
			bName = multi.getParameter("bName");
			bTitle = multi.getParameter("bTitle");
			bContent = multi.getParameter("bContent");
			fileName = multi.getFilesystemName("fileName");
			bId = multi.getParameter("bId");
			bGroup = multi.getParameter("bGroup");
			bStep = multi.getParameter("bStep");
			bIndent = multi.getParameter("bIndent");
			page = multi.getParameter("page");
			
			chk = dao.bReply(bId,bName,bTitle,bContent,bGroup,bStep,bIndent,fileName);
			
			request.setAttribute("flag", chk);
			request.setAttribute("category", multi.getParameter("category"));
			request.setAttribute("search", multi.getParameter("search"));
			request.setAttribute("page", multi.getParameter("page"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
