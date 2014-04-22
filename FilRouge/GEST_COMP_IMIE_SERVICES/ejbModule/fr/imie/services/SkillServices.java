package fr.imie.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.imie.Iservices.ISkillServices;
import fr.imie.entity.Skill;

@Stateless(name = "ServicesSkills")
@LocalBean
@TransactionManagement(TransactionManagementType.CONTAINER)
public class SkillServices implements ISkillServices {

	@PersistenceContext
	private EntityManager entityManager;
	
	/**
	 * Default constructor.
	 */
	public SkillServices() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public Skill insertSkill(Skill skill) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Skill> searchSkill(Skill skill) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Skill updateSkill(Skill skillToUpdate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteSkill(Skill skill) {
		// TODO Auto-generated method stub

	}

}
