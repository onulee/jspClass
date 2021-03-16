package com.shop.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.shop.Dto.BoardDto;
import com.shop.Dto.MemberDto;

public class BoardDao {

	DataSource ds=null;
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	ArrayList<BoardDto> list = new ArrayList<BoardDto>();
	BoardDto dto = null;
	int bId,bHit,bGroup,bStep,bIndent;
	String bName,bTitle,bContent,fileName;
	Timestamp bDate;
	int chk=0;
	
	public BoardDao() { //생성자
		try {
			Context context = new InitialContext();
			ds = (DataSource)context.lookup("java:comp/env/jdbc/Oracle11g");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//수정내용 저장메소드
	public int bModify(String user_id,String bTitle,String bContent,String fileName) {
		
		try {
			conn=ds.getConnection();
			String query = "update notice_board set "
					+ "bTitle=?,bContent=?,fileName=? where bId=? ";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, bTitle);
			pstmt.setString(2, bContent);
			pstmt.setString(3, fileName);
			pstmt.setString(4, user_id);
			chk = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return chk;
	}//bModify
	
	// 수정뷰페이지 메소드
	public BoardDto bModifyView(String user_id) {
		dto=null;
		try {
			conn=ds.getConnection();
			String query = "select * from notice_board where bId=?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, user_id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				bId = rs.getInt("bId");
				bName = rs.getString("bName");
				bTitle = rs.getString("bTitle");
				bContent = rs.getString("bContent");
				bDate = rs.getTimestamp("bDate");
				bHit = rs.getInt("bHit");
				bGroup = rs.getInt("bGroup");
				bStep = rs.getInt("bStep");
				bIndent = rs.getInt("bIndent");
				fileName = rs.getString("fileName");
				dto = new BoardDto(bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent, fileName);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return dto;
	}//bModifyView
	
	
	//해당글 이하 1씩 증가 메소드
	public void replyPlus(String bGroup,String bStep) {
		try {
			conn = ds.getConnection();
			String query = "update notice_board set bStep=bStep+1 "
					+ "where bGroup=? and bStep>?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, bGroup);		
			pstmt.setString(2, bStep);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}//replyPlus
	
	//답글달기 저장 메소드
	public int bReply(String bId,String bName,String bTitle,String bContent,
			          String bGroup,String bStep,String bIndent,String fileName){
	
		//해당글 이하 답글 1씩 증가 메소드
		replyPlus(bGroup,bStep);
		
		try {
			
			conn = ds.getConnection();
			String query = "insert into notice_board values ( "
					+ "board_seq.nextval,?,?,?,sysdate,0,?,?,?,?)";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, bName);
			pstmt.setString(2, bTitle);
			pstmt.setString(3, bContent);
			pstmt.setString(4, bGroup); //부모와 그룹동일
			pstmt.setInt(5, Integer.parseInt(bStep)+1); //부모보다 1크게
			pstmt.setInt(6, Integer.parseInt(bIndent)+1); //들려쓰기 1증가
			pstmt.setString(7, fileName);
			
			chk = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return chk;
	}
	
	
	//답글달기 뷰페이지 메소드
	public BoardDto bReplyView(String user_id) {
		try {
			conn = ds.getConnection();
			String query = "select * from notice_board where bId=?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, user_id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				bId = rs.getInt("bId");
				bName = rs.getString("bName");
				bTitle = rs.getString("bTitle");
				bContent = rs.getString("bContent");
				bDate = rs.getTimestamp("bDate");
				bHit = rs.getInt("bHit");
				bGroup = rs.getInt("bGroup");
				bStep = rs.getInt("bStep");
				bIndent = rs.getInt("bIndent");
				fileName = rs.getString("fileName");
				dto = new BoardDto(bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent, fileName);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return dto;
	}//bReplyView
	
	
	//삭제메소드
	public int bDelete(String user_id) {
		try {
			conn = ds.getConnection();
			String query = "delete notice_board where bId=?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, user_id);
			chk = pstmt.executeUpdate(); //insert,delete,update
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return chk;
	}//bDelete
	
	
	//조회수 증가메소드
	public void upHit(String user_id) {
		
		try {
			conn = ds.getConnection();
			String query = "update notice_board set bHit=bHit+1 where bId=?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, user_id);
			pstmt.executeUpdate(); 
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return;
	}//upHit
	
	//content 뷰페이지 메소드호출
	public BoardDto bContentView(String user_id) {
		
		//조회수 증가
		upHit(user_id);
		
		dto = null;
		try {
			conn = ds.getConnection();
			String query = "select * from notice_board where bId=?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, user_id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				bId = rs.getInt("bId");
				bName = rs.getString("bName");
				bTitle = rs.getString("bTitle");
				bContent = rs.getString("bContent");
				bDate = rs.getTimestamp("bDate");
				bHit = rs.getInt("bHit");
				bGroup = rs.getInt("bGroup");
				bStep = rs.getInt("bStep");
				bIndent = rs.getInt("bIndent");
				fileName = rs.getString("fileName");
				dto = new BoardDto(bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent, fileName);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return dto;
	}//bContentView
	
	
	//글쓰기 메소드
	public int bWrite(String bName,String bTitle,String bContent,String fileName) {
		
		try {
			conn=ds.getConnection();
			String query = "insert into notice_board values("
					+ "board_seq.nextval,?,?,?,"
					+ "sysdate,0,board_seq.currval,0,0,?)";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, bName);
			pstmt.setString(2, bTitle);
			pstmt.setString(3, bContent);
			pstmt.setString(4, fileName);
			chk = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return chk;
	}//bWrite
	
	
	//전체게시글 count
	public int listCount(String category,String search) {
		int count=0; //초기화
		try {
			conn=ds.getConnection();
			String query = "";
			if(category==null || category.equals("")) {
				query ="select count(*) from notice_board";
				pstmt = conn.prepareStatement(query);
			}else if(category.equals("all")) {
				query ="select count(*) from notice_board where bTitle like ? or bContent like ?";
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, "%"+search+"%");
				pstmt.setString(2, "%"+search+"%");
			}else if(category.equals("title")) {
				query ="select count(*) from notice_board where bTitle like ?";
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, "%"+search+"%");
			}else if(category.equals("content")) {
				query ="select count(*) from notice_board where bContent like ?";
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, "%"+search+"%");
			}
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return count;
	}
	
	//전체게시글 list
	public ArrayList<BoardDto> list(int page,int limit,String category,String search){
		list=new ArrayList<BoardDto>();//초기화
		int startrow = (page-1)*limit+1; // 시작 게시글번호 1,11,21...
		int endrow = startrow+limit-1; // 마지막 게시글번호 10,20,30...
		try {
			conn=ds.getConnection();
			
			//category,search 없을 경우
			if(category==null || category.equals("")) {
				String query = "select * from "
						+ "(select rownum rnum,a.*  from "
						+ "(select * from notice_board order by bGroup desc, bStep asc) a)"
						+ "where rnum>=? and rnum<=?";
				pstmt = conn.prepareStatement(query);
				pstmt.setInt(1, startrow);
				pstmt.setInt(2, endrow);
			}else if(category.equals("all")) { //category=all경우
				String query = "select * from (select rownum rnum,a.* from"
						+ "(select * from notice_board where bTitle like ? or bContent like ?"
						+ "order by bGroup desc, bStep asc) a)"
						+ "where rnum>=? and rnum<=?";
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, "%"+search+"%");
				pstmt.setString(2, "%"+search+"%");
				pstmt.setInt(3, startrow);
				pstmt.setInt(4, endrow);
			}else if(category.equals("title")) {
				String query = "select * from (select rownum rnum,a.* from"
						+ "(select * from notice_board where bTitle like ?"
						+ "order by bGroup desc, bStep asc) a)"
						+ "where rnum>=? and rnum<=?";
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, "%"+search+"%");
				pstmt.setInt(2, startrow);
				pstmt.setInt(3, endrow);
			}else if(category.equals("content")) {
				String query = "select * from (select rownum rnum,a.* from"
						+ "(select * from notice_board where bContent like ?"
						+ "order by bGroup desc, bStep asc) a)"
						+ "where rnum>=? and rnum<=?";
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, "%"+search+"%");
				pstmt.setInt(2, startrow);
				pstmt.setInt(3, endrow);
			}
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				bId = rs.getInt("bId");
				bName = rs.getString("bName");
				bTitle = rs.getString("bTitle");
				bContent = rs.getString("bContent");
				bDate = rs.getTimestamp("bDate");
				bHit = rs.getInt("bHit");
				bGroup = rs.getInt("bGroup");
				bStep = rs.getInt("bStep");
				bIndent = rs.getInt("bIndent");
				fileName = rs.getString("fileName");
				
				list.add(new BoardDto(bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent, fileName));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return list;
	}//list
	
	
	
	
}
