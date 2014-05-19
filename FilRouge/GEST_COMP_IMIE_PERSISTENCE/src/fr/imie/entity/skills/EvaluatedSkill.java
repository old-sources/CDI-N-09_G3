package fr.imie.entity.skills;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import fr.imie.entity.users.User;


/**
 * The persistent class for the posseder database table.
 * 
 */
@Entity
@Table(name="posseder",
schema="gestioncomp")
@NamedQuery(name="EvSkillsListUser",
query="Select ek from EvaluatedSkill ek where ek.user.userId=(:id)")
public class EvaluatedSkill implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer evaluatedSkillId;
	private Integer level;
	private Skill skill;
	private User user;

	public EvaluatedSkill() {
	}


	@Id
	@Column(name="posseder_id")
	public Integer getEvaluatedSkillId() {
		return this.evaluatedSkillId;
	}

	public void setEvaluatedSkillId(Integer evaluatedSkillId) {
		this.evaluatedSkillId = evaluatedSkillId;
	}

	@Basic
	@Column(name="niveau")
	public int getLevel() {
		return this.level;
	}
	
	public void setBossLevel(Integer niveau) {
		
		if(niveau>this.level&&niveau<=5)this.level = niveau;
	}
	
	public void setLevel(Integer niveau) {
		
		if(niveau>0&&niveau<=5)this.level = niveau;
	}


	//uni-directional many-to-one association to Skill
	@ManyToOne
	@JoinColumn(name="competence_id")
	public Skill getSkill() {
		return this.skill;
	}

	public void setSkill(Skill skill) {
		this.skill = skill;
	}


	//uni-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="utilisateur_id")
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((evaluatedSkillId == null) ? 0 : evaluatedSkillId.hashCode());
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
		EvaluatedSkill other = (EvaluatedSkill) obj;
		if (evaluatedSkillId == null) {
			if (other.evaluatedSkillId != null)
				return false;
		} else if (!evaluatedSkillId.equals(other.evaluatedSkillId))
			return false;
		return true;
	}

}