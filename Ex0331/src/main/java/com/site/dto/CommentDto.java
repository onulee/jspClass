package com.site.dto;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentDto {

	int commentNo;
	int bid;    //BoardDto
	String id;  //MemberDto
	String commentPw;
	String commentContent;
	Timestamp commentDate;
	
}
