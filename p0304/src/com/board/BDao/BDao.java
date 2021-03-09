package com.board.BDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.board.BDto.BDto;

public class BDao {
	
	public BDao(){
		try {
			context = new InitialContext();
			ds = (DataSource) context.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	Context context;
	DataSource ds;
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	ArrayList<BDto> list = new ArrayList<BDto>();
	BDto dto;
	int bId,bHit,bGroup,bStep,bIndent;
	String bName,bTitle,bContent;
	Timestamp bDate;
	String query;
	int chk;
	int count;
	
	
	//총게시글 개수 메소드
	public int listCount() {
		count=0;
		
		try {
			conn = ds.getConnection();
			String query = "select count(*) from board";
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				count = rs.getInt(1);
			}
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return count;
	}//listCount
	
	
	
	//게시판 수정
	public int bModify(String bId,String bName,String bTitle,String bContent) {
		try {
			conn = ds.getConnection();
			query = "update board set bTitle=?,bContent=? where bId=?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, bTitle); //- 넘어온 값이 있을 경우
			pstmt.setString(2, bContent); //- 넘어온 값이 있을 경우
			pstmt.setString(3, bId); //- 넘어온 값이 있을 경우
			chk = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
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
	
	public void replyShape(String reply_bGroup,String reply_bStep) {
		try {
			conn = ds.getConnection();
			String query = "update board set bStep=bStep+1 "
					+ "where bGroup=? and bStep > ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, Integer.parseInt(reply_bGroup));
			pstmt.setInt(2, Integer.parseInt(reply_bStep));
			//pstmt.setString(1, content_bId);
			pstmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return;
	}//replyShape
	
	
	
	//답글 저장 메소드
	public int bReply(String bId,String bName,String bTitle,String bContent,String bGroup,
			String bStep, String bIndent ) {
		
		//현재 스탭 아래로 같은 bGroup의 bStep 1씩 증가 
		replyShape(bGroup,bStep);
		
		try {
			conn = ds.getConnection();
			query = "insert into board values"
					+ "(board_seq.nextval,?,?,?,sysdate,0,?,?,?)";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, bName); //- 넘어온 값이 있을 경우
			pstmt.setString(2, bTitle); //- 넘어온 값이 있을 경우
			pstmt.setString(3, bContent); //- 넘어온 값이 있을 경우
			pstmt.setInt(4, Integer.parseInt(bGroup)); //- 넘어온 값이 있을 경우
			pstmt.setInt(5, Integer.parseInt(bStep)+1); //- 넘어온 값이 있을 경우
			pstmt.setInt(6, Integer.parseInt(bIndent)+1); //- 넘어온 값이 있을 경우
			chk = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
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
	
	
	// write저장
	public int boardWrite(String bName,String bTitle,String bContent) {
		try {
			conn = ds.getConnection();
			query = "insert into board values"
					+ "(board_seq.nextval,?,?,?,sysdate,0,board_seq.currval,0,0)";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, bName); //- 넘어온 값이 있을 경우
			pstmt.setString(2, bTitle); //- 넘어온 값이 있을 경우
			pstmt.setString(3, bContent); //- 넘어온 값이 있을 경우
			chk = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return chk;
	}//boardWrite
	
	//조회수 증가 메소드
	public void upHit(String content_bId) {
		try {
			conn = ds.getConnection();
			String query = "update board set bHit=bHit+1 where bId=?";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, Integer.parseInt(content_bId));
			//pstmt.setString(1, content_bId);
			pstmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
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
	
	
	//삭제 메소드
	public void delete(String delete_bId) {
		try {
			conn = ds.getConnection();
			String query = "delete board where bId=?";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, Integer.parseInt(delete_bId));
			pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}//delete
	
	//답변페이지 메소드
	public BDto replyView(String reply_bId) {
	
        dto=null;
		
		try {
			conn = ds.getConnection();
			String query = "select * from board where bId=?";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, Integer.parseInt(reply_bId));
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
				dto = new BDto(bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent);
			}
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return dto;
		
	}//replyView
	
	//수정페이지 메소드
	public BDto modifyView(String modify_bId) {
		dto=null;
		
		try {
			conn = ds.getConnection();
			String query = "select * from board where bId=?";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, Integer.parseInt(modify_bId));
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
				dto = new BDto(bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent);
			}
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return dto;
		
	}//modifyView
	
	
	//view페이지 메소드 호출
	public BDto contentView(String content_bId) {
		
		dto=null;
		//조회수 증가 메소드호출
		//if(session_upHit==0){
			upHit(content_bId);
		//}
		try {
			conn = ds.getConnection();
			String query = "select * from board where bId=?";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, Integer.parseInt(content_bId));
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
				dto = new BDto(bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent);
			}
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return dto;
	}//contentView
	
	
	//boardlist - 게시판리스트 
	public ArrayList<BDto> boardList(int page, int limit) {
		
		try {
			conn = ds.getConnection();
			
			query="select * from "
					+ "(select rownum rnum,a.* from "
					+ "(select * from board order by bGroup desc,bStep asc) a) "
					+ "where rnum>=? and rnum<=?";
			//query = "select * from board order by bGroup desc,bStep asc";
			int startrow = (page-1)*10+1; // 시작 게시글번호 (1-1)*10+1 = 1, 11,21,31,41....
			int endrow = startrow+limit-1; //마지막 게시글번호
			
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, startrow);
			pstmt.setInt(2, endrow);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				bId = rs.getInt(1);
				bName = rs.getString("bName");
				bTitle = rs.getString("bTitle");
				bContent = rs.getString("bContent");
				bDate = rs.getTimestamp("bDate");
				bHit = rs.getInt("bHit");
				bGroup = rs.getInt("bGroup");
				bStep = rs.getInt("bStep");
				bIndent = rs.getInt("bIndent");
				list.add(new BDto(bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	
	   return list;
	}//boardList
	
	
}//class
