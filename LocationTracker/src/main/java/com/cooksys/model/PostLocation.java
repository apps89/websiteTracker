package com.cooksys.model;

public class PostLocation {

	private String name;
	private Long num;

	public PostLocation() {
		super();
	}

	public PostLocation(String name, Long num) {
		super();
		this.name = name;
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getNum() {
		return num;
	}

	public void setNum(Long num) {
		this.num = num;
	}
}
