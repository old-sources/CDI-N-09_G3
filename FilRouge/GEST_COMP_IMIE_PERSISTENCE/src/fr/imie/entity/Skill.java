package fr.imie.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the competence database table.
 * 
 */
@Entity
@Table(name="competence")
public class Skill implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer competenceId;
	private Date dateDecisionProp;
	private Date dateProp;
	private String nom;
	private Boolean retourDecisionProp;
	private Boolean validation;
	private Skill competence;
	private List<Skill> competences;
	private User suggestUser;

	public Skill() {
	}


	@Id
	@Column(name="competence_id")
	public Integer getCompetenceId() {
		return this.competenceId;
	}

	public void setCompetenceId(Integer competenceId) {
		this.competenceId = competenceId;
	}


	@Temporal(TemporalType.DATE)
	@Column(name="date_decision_prop")
	public Date getDateDecisionProp() {
		return this.dateDecisionProp;
	}

	public void setDateDecisionProp(Date dateDecisionProp) {
		this.dateDecisionProp = dateDecisionProp;
	}


	@Temporal(TemporalType.DATE)
	@Column(name="date_prop")
	public Date getDateProp() {
		return this.dateProp;
	}

	public void setDateProp(Date dateProp) {
		this.dateProp = dateProp;
	}


	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}


	@Column(name="retour_decision_prop")
	public Boolean getRetourDecisionProp() {
		return this.retourDecisionProp;
	}

	public void setRetourDecisionProp(Boolean retourDecisionProp) {
		this.retourDecisionProp = retourDecisionProp;
	}


	public Boolean getValidation() {
		return this.validation;
	}

	public void setValidation(Boolean validation) {
		this.validation = validation;
	}


	//bi-directional many-to-one association to Skill
	@ManyToOne
	@JoinColumn(name="competence_mere_id")
	public Skill getCompetence() {
		return this.competence;
	}

	public void setCompetence(Skill competence) {
		this.competence = competence;
	}


	//bi-directional many-to-one association to Skill
	@OneToMany(mappedBy="competence")
	public List<Skill> getCompetences() {
		return this.competences;
	}

	public void setCompetences(List<Skill> competences) {
		this.competences = competences;
	}

	public Skill addCompetence(Skill competence) {
		getCompetences().add(competence);
		competence.setCompetence(this);

		return competence;
	}

	public Skill removeCompetence(Skill competence) {
		getCompetences().remove(competence);
		competence.setCompetence(null);

		return competence;
	}


	//uni-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="utilisateur_prop_id")
	public User getSuggestUser() {
		return this.suggestUser;
	}

	public void setSuggestUser(User suggestUser) {
		this.suggestUser = suggestUser;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((competenceId == null) ? 0 : competenceId.hashCode());
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
		Skill other = (Skill) obj;
		if (competenceId == null) {
			if (other.competenceId != null)
				return false;
		} else if (!competenceId.equals(other.competenceId))
			return false;
		return true;
	}

	
}