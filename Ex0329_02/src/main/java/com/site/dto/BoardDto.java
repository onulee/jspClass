package com.site.dto;

public class BoardDto {
	
	public BoardDto() {}
	public BoardDto(String id, String name, String fileName) {
		this.id = id;
		this.name = name;
		this.fileName = fileName;
	}

    private String id;
	private String name;
	private String fileName;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	
	

}
