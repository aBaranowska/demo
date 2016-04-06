package com.rec.demo.dto;

import java.util.Date;

public class TimeTrackDTO {

	private String customer;

	private String project;

	private String task;

	private String user;

	private Date date;

	private Double spentTime;

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(final String customer) {
		this.customer = customer;
	}

	public String getProject() {
		return project;
	}

	public void setProject(final String project) {
		this.project = project;
	}

	public String getTask() {
		return task;
	}

	public void setTask(final String task) {
		this.task = task;
	}

	public String getUser() {
		return user;
	}

	public void setUser(final String user) {
		this.user = user;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(final Date date) {
		this.date = date;
	}

	public Double getSpentTime() {
		return spentTime;
	}

	public void setSpentTime(final Double spentTime) {
		this.spentTime = spentTime;
	}

}
