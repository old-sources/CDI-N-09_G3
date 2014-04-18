package fr.imie.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.imie.entity.Competence;

@Stateless(name = "ServicesCompetences")
@LocalBean
@TransactionManagement(TransactionManagementType.CONTAINER)
public class ServicesCompetences implements IServicesCompetences {

	@PersistenceContext
	private EntityManager entityManager;
	
	/**
	 * Default constructor.
	 */
	public ServicesCompetences() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public Competence insertSkill(Competence competence) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Competence> searchSkill(Competence competence) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Competence updateSkill(Competence competenceToUpdate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteSkill(Competence competence) {
		// TODO Auto-generated method stub

	}

}
