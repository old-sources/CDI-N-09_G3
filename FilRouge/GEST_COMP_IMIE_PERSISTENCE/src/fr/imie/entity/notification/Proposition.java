package fr.imie.entity.notification;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import fr.imie.entity.skills.Skill;


/**
 * The persistent class for the proposition database table.
 * 
 */
@Entity(name="fr.imie.entity.Proposition")
@DiscriminatorValue("PROPOSITION")
public class Proposition extends Notification implements Serializable {
	private static final long serialVersionUID = 1L;

	private Skill skill;


	public Proposition() {
	}
	
	@OneToOne(
			cascade={ CascadeType.PERSIST, CascadeType.MERGE},
			optional=false)
	@JoinColumn(name="competence_id")
	public Skill getSkill() {
		return this.skill;
	}

	public void setSkill(Skill competenceId) {
		this.skill = competenceId;
	}
	
	





	
}