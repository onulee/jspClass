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
	public int listCount() {
		int count=0; //초기화
		try {
			conn=ds.getConnection();
			
			String query ="select count(*) from notice_board";
			pstmt = conn.prepareStatement(query);
			//pstmt.setString(1, user_id);
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
	public ArrayList<BoardDto> list(int page,int limit){
		list=new ArrayList<BoardDto>();//초기화
		int startrow = (page-1)*limit+1; // 시작 게시글번호 1,11,21...
		int endrow = startrow+limit-1; // 마지막 게시글번호 10,20,30...
		try {
			conn=ds.getConnection();
			String query = "select * from "
					+ "(select rownum rnum,a.*  from "
					+ "(select * from notice_board order by bGroup desc, bStep asc) a)"
					+ "where rnum>=? and rnum<=?";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, startrow);
			pstmt.setInt(2, endrow);
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
				list.add(new BoardDto(bId, bHit, bGroup, bStep, bIndent, bName, bTitle, bContent, fileName, bDate));
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
