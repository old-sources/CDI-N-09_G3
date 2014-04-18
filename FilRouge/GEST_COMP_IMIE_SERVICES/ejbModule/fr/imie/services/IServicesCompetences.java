package fr.imie.services;

import java.util.List;

import javax.ejb.Local;

import fr.imie.entity.Competence;


@Local
public interface IServicesCompetences {
	
	
	/**
	 * @param competence
	 * @return Competence
	 */
	public abstract Competence insertSkill(Competence competence);
	
	/**
	 * @param competence
	 * @return List<Competence>
	 */
	public abstract List<Competence> searchSkill(Competence competence);

	/**
	 * @param competenceToUpdate
	 * @return Competence
	 */
	public abstract Competence updateSkill(Competence competenceToUpdate);
	
	/**
	 * @param competence
	 */
	public abstract void deleteSkill(Competence competence);

}
