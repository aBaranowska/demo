package com.rec.demo.entity.embedded;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class UserEntity {

	@Id
	@GeneratedValue
	private Long id;

	@Column
	private String firstName;

	@Column
	private String lastName;

	@Column
	private String login;

	@Column
	private String email;

	// TODO extEmployeeNumber
	// TODO extBusinessGroup
	// TODO extPersonType
	// TODO extOrganizationName

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(final String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(final String lastName) {
		this.lastName = lastName;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(final String login) {
		this.login = login;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(final String email) {
		this.email = email;
	}

}
