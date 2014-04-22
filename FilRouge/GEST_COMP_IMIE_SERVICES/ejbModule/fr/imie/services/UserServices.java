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

import fr.imie.entity.Skill;
import fr.imie.entity.User;
import fr.imie.entity.Year;

@Stateless(name = "ServicesUtilisateurs")
@LocalBean
@TransactionManagement(TransactionManagementType.CONTAINER)
public class UserServices implements IUserServices {

	@PersistenceContext
	private EntityManager entityManager;
	
	/**
	 * Default constructor.
	 */
	public UserServices() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public User insertUser(User user) {
		User insertedUser = new User();
		if(user.getLastName()!=null){
			insertedUser.setLastName(user.getLastName());
		}
		if(user.getFirstName()!=null){
			insertedUser.setFirstName(user.getFirstName());
		}
		if(user.getPassword()!=null){
			insertedUser.setPassword(user.getPassword());
		}
		if(user.getYear()!=null){
			insertedUser.setYearName(user.getYear());
		}
		entityManager.persist(insertedUser);
		return insertedUser;
	}

	@Override
	public User searchUserByID(int ID) {
		User user = new User();
		user = entityManager.find(User.class, ID);
		return user;
	}

	@Override
	public List<User> listUser() {
		User user = new User();
		@SuppressWarnings("unchecked")
		List<User> listUsers = (List<User>)entityManager.find(User.class, user);
		return listUsers;
	}
	
	@Override
	public List<User> searchUserBySkill(List<Skill> listSkills) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User updateUser(User userToUpdate) {
		entityManager.merge(userToUpdate);
		return userToUpdate;
	}

	@Override
	public void deleteUser(User user) {
		User userToRemove = entityManager.find(User.class, user.getUserId());
		entityManager.remove(userToRemove);
	}

	@Override
	public User verifyAuthUser(User user) {
		if ((user.getLastName() == null || user.getLastName().isEmpty())
				|| (user.getPassword() == null || user.getPassword()
						.isEmpty())) {
			//throw new ServiceException("la personne à authentifier doit renseigner son nom et son passw");
		}
		
		CriteriaBuilder qb = entityManager.getCriteriaBuilder();

		CriteriaQuery<User> query = qb.createQuery(User.class);
		Root<User> personneRoot = query.from(User.class);

		List<Predicate> criteria = new ArrayList<Predicate>();
		if (user.getLastName() != null) {
			criteria.add(qb.equal(personneRoot.<String> get("nom"), user.getLastName()));
		}
		if (user.getPassword() != null) {
			criteria.add(qb.equal(personneRoot.<String> get("passw"), user.getPassword()));
		}
		query.where(criteria.toArray(new Predicate[] {}));

		List<User> result = entityManager.createQuery(query).getResultList();
				
		User perso =null;
		if (result != null){
			perso = result.get(0);
		
		}
		return perso;
	}

	@Override
	public Year insertYear(Year year) {
		entityManager.persist(year);
		return year;
	}

	@Override
	public List<Year> searchYear(Year year) {
		CriteriaBuilder qb = entityManager.getCriteriaBuilder();

		CriteriaQuery<Year> query = qb.createQuery(Year.class);
		Root<Year> promotionRoot = query.from(Year.class);

		List<Predicate> criteria = new ArrayList<Predicate>();
		if (year.getYearName() != null) {
			criteria.add(qb.like(promotionRoot.<String> get("libelle"), "*" + year.getYearName() + "*"));
		}
		if (year.getYearName() != null) {
			criteria.add(qb.equal(promotionRoot.<String> get("id"), year.getYearName()));
		}
		query.where(criteria.toArray(new Predicate[] {}));

		List<Year> result = entityManager.createQuery(query).getResultList();
		return result;
	}

	@Override
	public Year updateYearName(Year yearToUpdate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteYearName(Year year) {
		entityManager.remove(year);

	}

	

	
}
