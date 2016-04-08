package com.rec.demo.entity.embedded;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "timeTrack")
public class TimeTrackEntity {

	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne
	@JoinColumn(name = "fk_user_id", nullable = false)
	private UserEntity user;

	@ManyToOne
	@JoinColumn(name = "fk_project_id", nullable = false)
	private ProjectEntity project;

	@Column
	@Temporal(TemporalType.DATE)
	private Date date;

	@Column
	private Double spentTime;

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(final UserEntity user) {
		this.user = user;
	}

	public ProjectEntity getProject() {
		return project;
	}

	public void setProject(final ProjectEntity project) {
		this.project = project;
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
