package fr.imie.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import fr.imie.Iservices.ISkillServices;
import fr.imie.entity.skills.EvaluatedSkill;
import fr.imie.entity.skills.Skill;
import fr.imie.entity.users.User;

@Stateless(name = "SkillsServices")
@LocalBean
@TransactionManagement(TransactionManagementType.CONTAINER)
public class SkillServices implements ISkillServices {

	@PersistenceContext(unitName="GEST_COMP_IMIEPU")
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public SkillServices() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Skill insertSkill(Skill skill) {
		Skill skillToInsert = new Skill();
		if(skill.getValidation()!=null&&skill.getName()!=null){
			skillToInsert.setValidation(skill.getValidation());
			skillToInsert.setName(skill.getName());

			if(skill.getMotherSkill()!=null){
				skillToInsert.setMotherSkill(skill.getMotherSkill());
			}
			entityManager.persist(skillToInsert);
		}
		return skillToInsert;
	}


	@Override
	public Skill searchSkill(int ID) {
		Skill skill = new Skill();
		skill = entityManager.find(Skill.class, ID);
		return skill;
	
	}
	@Override
	public List<Skill> listSkills() {
		TypedQuery<Skill> query = entityManager.createNamedQuery("SkillsList",Skill.class);
		
		List<Skill> result = query.getResultList();
		
		return result;
	}

	@Override
	public Skill updateSkill(Skill skillToUpdate) {
		if (skillToUpdate!=null){
			entityManager.merge(skillToUpdate);
		}
		return skillToUpdate;
	}
	

	@Override
	public void deleteSkill(Skill skill) {
		if((skill!=null)
//				&&(skill.getDaughterSkills().isEmpty())
				){
		Skill skillToRemove = entityManager.find(Skill.class, skill.getSkillId());
		entityManager.remove(skillToRemove);
		}
	}
	@Override
	public EvaluatedSkill searchEvSkill(int ID) {
		EvaluatedSkill skill = new EvaluatedSkill();
		skill = entityManager.find(EvaluatedSkill.class, ID);
		return skill;
	
	}
//	public List<EvaluatedSkill> EvSkillslist(User user) {
//		TypedQuery<EvaluatedSkill> query = entityManager.createNamedQuery("EvSkillsListUser",EvaluatedSkill.class);
//		query.setParameter("id", user.getUserId());
//		List<EvaluatedSkill> result = query.getResultList();
//		
//		return result;
//	}

	@Override
	public EvaluatedSkill updateEvSkill(EvaluatedSkill EvSkillToUpdate) {
		if (EvSkillToUpdate!=null){
			entityManager.merge(EvSkillToUpdate);
		}
		return EvSkillToUpdate;
	}
	

	@Override
	public void deleteEvSkill(EvaluatedSkill skill) {
		if(skill!=null){
		EvaluatedSkill skillToRemove = entityManager.find(EvaluatedSkill.class, skill.getEvaluatedSkillId());
		entityManager.remove(skillToRemove);
		}
	}

	@Override
	public EvaluatedSkill insertEvSkill(EvaluatedSkill evSkill) {
		EvaluatedSkill evSkillToInsert = new EvaluatedSkill();
		if(evSkill.getSkill()!=null
				&&evSkill.getSkill().getValidation()!=null
				&&evSkill.getSkill().getName()!=null
				&&evSkill.getLevel()>0
				&&evSkill.getLevel()<=5
//				&&evSkill.getUser()!=null
				){
			evSkillToInsert.setSkill(evSkill.getSkill());
			evSkillToInsert.setLevel(evSkill.getLevel());
//			evSkillToInsert.setUser(evSkill.getUser());
		
				entityManager.persist(evSkillToInsert);
			}
			
		return evSkillToInsert;
	}
	
}
