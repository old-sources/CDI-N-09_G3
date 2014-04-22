package fr.imie.Iservices;

import java.util.List;

import javax.ejb.Local;

import fr.imie.entity.Skill;


@Local
public interface ISkillServices {
	
	
	/**
	 * @param skill
	 * @return Skill
	 */
	public abstract Skill insertSkill(Skill skill);
	
	/**
	 * @param skill
	 * @return List<Skill>
	 */
	public abstract List<Skill> searchSkill(Skill skill);

	/**
	 * @param skillToUpdate
	 * @return Skill
	 */
	public abstract Skill updateSkill(Skill skillToUpdate);
	
	/**
	 * @param skill
	 */
	public abstract void deleteSkill(Skill skill);

}
