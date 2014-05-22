package fr.imie.entity.skills;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the competence database table.
 * 
 */
@Entity
@Table(name="competence",
schema="gestioncomp")
@NamedQuery(name="SkillsList",
query="Select s from Skill s")
public class Skill implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer skillId;

	private String name;
	
	private Boolean validation;
	private Skill motherSkill;
//	private List<Skill> daughterSkills;
	
	public Skill() {
	}


	@Id
	@Column(name="competence_id")
	public Integer getSkillId() {
		return this.skillId;
	}

	public void setSkillId(Integer competenceId) {
		this.skillId = competenceId;
	}
	
	@Column(name="nom")
	public String getName() {
		return this.name;
	}
	
	
	public void setName(String nom) {
		this.name = nom;
	}
	@Column(name="validation")
	public Boolean getValidation() {
		return this.validation;
	}

	public void setValidation(Boolean validation) {
		this.validation = validation;
	}


	//uni-directional many-to-one association to Skill
	@ManyToOne
	@JoinColumn(name="competence_mere_id")
	public Skill getMotherSkill() {
		return this.motherSkill;
	}

	public void setMotherSkill(Skill motherSkill) {
		this.motherSkill = motherSkill;
	}


//bi-directional many-to-one association to Skill
//@OneToMany(mappedBy="motherSkill")
//public List<Skill> getDaughterSkills() {
//		return this.daughterSkills;
//	}
//
//	public void setDaughterSkills(List<Skill> competences) {
//		this.daughterSkills = competences;
//	}
//
//	public Skill addSkill(Skill competence) {
//		getDaughterSkills().add(competence);
//		competence.setMotherSkill(this);
//
//		return competence;
//	}
//
//	public Skill removeSkill(Skill competence) {
//		getDaughterSkills().remove(competence);
//		competence.setMotherSkill(null);
//
//		return competence;
//	}
	
		@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((skillId == null) ? 0 : skillId.hashCode());
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
		if (skillId == null) {
			if (other.skillId != null)
				return false;
		} else if (!skillId.equals(other.skillId))
			return false;
		return true;
	}

	
}