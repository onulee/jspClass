package com.site.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.site.service.BoardService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class BController {

	@Autowired
	BoardService boardService;
	
	 private static final Logger LOGGER = LogManager.getLogger(BController.class);
	
	@RequestMapping("/ajax")
	public String ajax() {
		return "ajax";
	}
	@RequestMapping("/file_view")
	public String file_view() {
		return "file_view";
	}
	
	@RequestMapping("/file_insert")
	@ResponseBody
	public String file_insert(@RequestParam("files") List<MultipartFile> files) throws Exception {
		//파일 저장 위치
		String fileUrl = "C:/GitSave/jspClass/Test/src/main/resources/static/upload/";
		//파일출력
		String fileN ="";
		
		// 파일 업로드(여러개) 처리 부분
	    for(MultipartFile file : files) {
	    	//원본파일이름
			String orgfileName = file.getOriginalFilename();
			long time = System.currentTimeMillis();
			String uploadFileName = String.format("%d_%s", time,orgfileName);
			fileN += uploadFileName;
			System.out.println("uploadFileName파일이름 : "+uploadFileName);
			File f = new File(fileUrl+uploadFileName);
	        file.transferTo(f);
	    }
		return fileN;
	}
	
	
	
	//log4j2 실행
	@RequestMapping("/index")
	public String index() {
		
		 LOGGER.debug("Hello Debug level log");
         LOGGER.info("로그를 찍어 봅니다.");
         LOGGER.error("Hello Error level log");
		return "index";
	}
	@RequestMapping("/event")
	public String event() {
		return "event";
	}
	
	@RequestMapping("/event_view")
	public String event_view() {
		return "event_view";
	}
	
	//댓글달기 
	@RequestMapping("/event_reply")
	@ResponseBody
	public Map<String, Object> event_reply(@RequestParam("replynum") String replynum,
			@RequestParam("replyType") String replyType) {
		Map<String, Object> map = new HashMap<String, Object>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String date = sdf.format(System.currentTimeMillis());
		System.out.println("replynum :"+replynum);
		map.put("replynum", replynum);
		map.put("replyType", replyType);
		map.put("comNo", 1);
		map.put("date", date);
		map.put("name", "홍길동");
		
		return map;
	}
	
	@RequestMapping("/testAjax")
	@ResponseBody
	public String testAjax(String date,String location) throws Exception {
		
		DataDto d = new DataDto();
		return d.data_tour(date,location);
		
//		Map map = new HashMap<String, Object>();
//		System.out.println("controller : "+id+","+pw);
//		map = boardService.testCheck(id,pw);
//		map.put("id", id);
//		map.put("pw", pw);
		
	}
	
}
