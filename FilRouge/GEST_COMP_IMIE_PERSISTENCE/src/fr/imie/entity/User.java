package fr.imie.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the utilisateur database table.
 * 
 */
@Entity
@Table(name="utilisateur")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer userId;
	private String description;
	private Boolean avaibility;
	private String login;
	private String mail;
	private String password;
	private String lastName;
	private String firstName;
	private Boolean protectedData;
	private Rights rights;
	private Year year;
	
	@Id
	@Column(name="utilisateur_id")
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Column(name="description")
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	@Basic
	@Column(name="dispo")
	public Boolean getAvaibility() {
		return avaibility;
	}


	public void setAvaibility(Boolean avaibility) {
		this.avaibility = avaibility;
	}

	@Column(name="login")
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	
	@Column(name="mail")
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	@Basic
	@Column(name="mdp")
	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}

	@Basic
	@Column(name="nom")
	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Basic
	@Column(name="prenom")
	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name="protection_donnee")
	public Boolean getProtectedData() {
		return protectedData;
	}


	public void setProtectedData(Boolean protectedData) {
		this.protectedData = protectedData;
	}


	
	//uni-directional many-to-one association to Rights
		@ManyToOne
		@JoinColumn(name="droits_id")
		public Rights getRights() {
			return this.rights;
		}

		public void setRights(Rights rights) {
			this.rights = rights;
		}


		//uni-directional many-to-one association to YearName
		@ManyToOne
		@JoinColumn(name="promotion_id")
		public Year getYear() {
			return this.year;
		}

		public void setYearName(Year yearName) {
			this.year= yearName;
		}
	

	public User() {
	}


	
	


	

}