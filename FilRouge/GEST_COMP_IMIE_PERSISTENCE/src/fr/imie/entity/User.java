package fr.imie.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
	private List<EvaluatedSkill> evaluatedSkills;
	
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
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

	//bi-directional many-to-one association to evaluatedSkills
		@OneToMany(mappedBy="user", cascade={CascadeType.ALL})
		public List<EvaluatedSkill> getEvaluatedSkills(){
			return this.evaluatedSkills;
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

	public Integer scoreWithSkills( List<Skill> skills){
		Integer score=0;
		
		return score;
	}
	
	


	

}