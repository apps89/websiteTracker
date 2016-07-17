package com.cooksys.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "location")
public class Location {

	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "hits")
	private Long hits;
	
	@Column(name = "anon_hits")
	private Long anonHits;
	
	@Column(name = "num")
	private Long num;

	public Location() {
		super();
	}

	public Location(Long id, String name, Long hits, Long anonHits, Long num) {
		super();
		this.id = id;
		this.name = name;
		this.hits = hits;
		this.anonHits = anonHits;
		this.num = num;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getHits() {
		return hits;
	}

	public void setHits(Long hits) {
		this.hits = hits;
	}

	public Long getAnonHits() {
		return anonHits;
	}

	public void setAnonHits(Long anonHits) {
		this.anonHits = anonHits;
	}

	public Long getNum() {
		return num;
	}

	public void setNum(Long num) {
		this.num = num;
	}
}