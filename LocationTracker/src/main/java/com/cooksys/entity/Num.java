package com.cooksys.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "num")
public class Num {

	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "Num")
	private Long num;

	public Num() {
		super();
	}

	public Num(Long id, Long num) {
		super();
		this.id = id;
		this.num = num;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getNum() {
		return num;
	}

	public void setNum(Long num) {
		this.num = num;
	}
}