package fr.imie.services;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import fr.imie.entity.Competence;
import fr.imie.entity.Promotion;
import fr.imie.entity.Utilisateur;

@Stateless(name = "ServicesUtilisateurs")
@LocalBean
@TransactionManagement(TransactionManagementType.CONTAINER)
public class ServicesUtilisateurs implements IServicesUtilisateurs {

	@PersistenceContext
	private EntityManager entityManager;
	
	/**
	 * Default constructor.
	 */
	public ServicesUtilisateurs() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public Utilisateur insertUser(Utilisateur utilisateur) {
		Utilisateur insertedUser = new Utilisateur();
		if(utilisateur.getNom()!=null){
			insertedUser.setNom(utilisateur.getNom());
		}
		if(utilisateur.getPrenom()!=null){
			insertedUser.setPrenom(utilisateur.getPrenom());
		}
		if(utilisateur.getMdp()!=null){
			insertedUser.setMdp(utilisateur.getMdp());
		}
		if(utilisateur.getPromotion()!=null){
			insertedUser.setPromotion(utilisateur.getPromotion());
		}
		entityManager.persist(insertedUser);
		return insertedUser;
	}

	@Override
	public Utilisateur searchUserByID(int ID) {
		Utilisateur user = new Utilisateur();
		user = entityManager.find(Utilisateur.class, ID);
		return user;
	}

	@Override
	public List<Utilisateur> listerUser() {
		Utilisateur user = new Utilisateur();
		@SuppressWarnings("unchecked")
		List<Utilisateur> listUsers = (List<Utilisateur>)entityManager.find(Utilisateur.class, user);
		return listUsers;
	}
	
	@Override
	public List<Utilisateur> searchUserBySkill(List<Competence> listCompetence) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Utilisateur updateUser(Utilisateur utilisateurToUpdate) {
		entityManager.merge(utilisateurToUpdate);
		return utilisateurToUpdate;
	}

	@Override
	public void deleteUser(Utilisateur utilisateur) {
		Utilisateur userToRemove = entityManager.find(Utilisateur.class, utilisateur.getIdutilisateur());
		entityManager.remove(userToRemove);
	}

	@Override
	public Utilisateur verifierAuthPersonne(Utilisateur utilisateur) {
		if ((utilisateur.getNom() == null || utilisateur.getNom().isEmpty())
				|| (utilisateur.getMdp() == null || utilisateur.getMdp()
						.isEmpty())) {
			//throw new ServiceException("la personne à authentifier doit renseigner son nom et son passw");
		}
		
		CriteriaBuilder qb = entityManager.getCriteriaBuilder();

		CriteriaQuery<Utilisateur> query = qb.createQuery(Utilisateur.class);
		Root<Utilisateur> personneRoot = query.from(Utilisateur.class);

		List<Predicate> criteria = new ArrayList<Predicate>();
		if (utilisateur.getNom() != null) {
			criteria.add(qb.equal(personneRoot.<String> get("nom"), utilisateur.getNom()));
		}
		if (utilisateur.getMdp() != null) {
			criteria.add(qb.equal(personneRoot.<String> get("passw"), utilisateur.getMdp()));
		}
		query.where(criteria.toArray(new Predicate[] {}));

		List<Utilisateur> result = entityManager.createQuery(query).getResultList();
				
		Utilisateur perso =null;
		if (result != null){
			perso = result.get(0);
		
		}
		return perso;
	}

	@Override
	public Promotion insertPromotion(Promotion promotion) {
		entityManager.persist(promotion);
		return promotion;
	}

	@Override
	public List<Promotion> searchPromotion(Promotion promotion) {
		CriteriaBuilder qb = entityManager.getCriteriaBuilder();

		CriteriaQuery<Promotion> query = qb.createQuery(Promotion.class);
		Root<Promotion> promotionRoot = query.from(Promotion.class);

		List<Predicate> criteria = new ArrayList<Predicate>();
		if (promotion.getIntitule() != null) {
			criteria.add(qb.like(promotionRoot.<String> get("libelle"), "*" + promotion.getIntitule() + "*"));
		}
		if (promotion.getIdpromotion() != null) {
			criteria.add(qb.equal(promotionRoot.<String> get("id"), promotion.getIdpromotion()));
		}
		query.where(criteria.toArray(new Predicate[] {}));

		List<Promotion> result = entityManager.createQuery(query).getResultList();
		return result;
	}

	@Override
	public Promotion updatePromotion(Promotion promotionToUpdate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletePromotion(Promotion promotion) {
		entityManager.remove(promotion);

	}

	

	
}
