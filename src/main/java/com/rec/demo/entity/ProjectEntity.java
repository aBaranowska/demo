package com.rec.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "project")
public class ProjectEntity {

	@Id
	@GeneratedValue
	@Getter
	@Setter
	private Long id;

}
