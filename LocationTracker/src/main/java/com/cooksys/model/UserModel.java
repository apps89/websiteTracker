package com.cooksys.model;

public class UserModel {

	private Long total;
	private Long numRegUsers;
	private Long numLoggedUsers;
	private Long numAnonymous;
	private Double conversionRate;

	public UserModel() {
		this.total = (long) 0;
		this.numRegUsers = (long) 0;
		this.numLoggedUsers = (long) 0;
		this.numAnonymous = (long) 0;
		this.conversionRate = (double) 0;
	}

	public Long getNumRegUsers() {
		return numRegUsers;
	}

	public void setNumRegUsers(Long numRegUsers) {
		this.numRegUsers = numRegUsers;
	}

	public Long getNumLoggedUsers() {
		return numLoggedUsers;
	}

	public void setNumLoggedUsers(Long numLoggedUsers) {
		this.numLoggedUsers = numLoggedUsers;
	}

	public Long getNumAnonymous() {
		return numAnonymous;
	}

	public void setNumAnonymous(Long numAnonymous) {
		this.numAnonymous = numAnonymous;
	}

	public Double getConversionRate() {
		return conversionRate;
	}

	public void setConversionRate(Double conversionRate) {
		this.conversionRate = conversionRate;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}
}
