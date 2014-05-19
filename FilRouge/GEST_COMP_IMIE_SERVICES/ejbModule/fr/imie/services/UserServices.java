package fr.imie.services;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import fr.imie.Iservices.IUserServices;
import fr.imie.entity.users.EvaluatedUser;
import fr.imie.entity.users.Rights;
import fr.imie.entity.users.SearchBySkillResult;
import fr.imie.entity.users.User;
import fr.imie.entity.users.Year;

@Stateless(mappedName = "UserServices")
@LocalBean
@TransactionManagement(TransactionManagementType.CONTAINER)
public class UserServices implements IUserServices {

	@PersistenceContext(unitName="GEST_COMP_IMIEPU")
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public UserServices() {
		
	}

	@Override
	public User insertUser(User user) {
		User insertedUser = new User();
		if((user.getLastName()!=null)
				&&(user.getFirstName()!=null)
				&&(user.getPassword()!=null)
				&&(user.getAvaibility()!=null)
				&&(user.getRights()!=null)
				&&(user.getProtectedData()!=null)
				&&(user.getLogin()!=null)){
			insertedUser.setLastName(user.getLastName());
			insertedUser.setLogin(user.getLogin());
			insertedUser.setFirstName(user.getFirstName());
			insertedUser.setPassword(user.getPassword());
			insertedUser.setAvaibility(user.getAvaibility());
			insertedUser.setProtectedData(user.getProtectedData());
			insertedUser.setRights(user.getRights());
			if (user.getYear()!=null){
				insertedUser.setYear(user.getYear());
			}
			if (user.getDescription()!=null){
				insertedUser.setDescription(user.getDescription());
			}
			if (user.getMail()!=null){
				insertedUser.setMail(user.getMail());
			}
			entityManager.persist(insertedUser);
		}

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
			
		TypedQuery<User> query=entityManager.createNamedQuery("findAllUsers",User.class);
		
		List<User> result=query.getResultList();
		
		return result;
		
		
	}



	@Override
	public User updateUser(User userToUpdate) {
		User updatedUser=new User();
		if (userToUpdate!=null){
			if((userToUpdate.getLastName()!=null)
					&&(userToUpdate.getUserId()!=null)
					&&(userToUpdate.getFirstName()!=null)
					&&(userToUpdate.getPassword()!=null)
					&&(userToUpdate.getAvaibility()!=null)
					&&(userToUpdate.getRights()!=null)
					&&(userToUpdate.getProtectedData()!=null)
					&&(userToUpdate.getLogin()!=null)){
				entityManager.merge(userToUpdate);
				updatedUser=userToUpdate;
			}
		}
		return updatedUser;
	}

	@Override
	public void deleteUser(User user) {
		if(user!=null){
			User userToRemove = entityManager.find(User.class, user.getUserId());
			entityManager.remove(userToRemove);
		}

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
		Year y=new Year();
		if(year!=null&&year.getYearName()!=null){
			y.setYearName(year.getYearName());
			entityManager.persist(y);
		}
		return y;
	}

	@Override
	public Year searchYear(Integer id) {
		Year year=new Year();
		year=entityManager.find(Year.class, id);
		return year;
	}
//	public List<Year> searchYear(Year year) {
//		CriteriaBuilder qb = entityManager.getCriteriaBuilder();
//
//		CriteriaQuery<Year> query = qb.createQuery(Year.class);
//		Root<Year> promotionRoot = query.from(Year.class);
//
//		List<Predicate> criteria = new ArrayList<Predicate>();
//		if (year.getYearName() != null) {
//			criteria.add(qb.like(promotionRoot.<String> get("libelle"), "*" + year.getYearName() + "*"));
//		}
//		if (year.getYearId() != null) {
//			criteria.add(qb.equal(promotionRoot.<String> get("id"), year.getYearId()));
//		}
//		query.where(criteria.toArray(new Predicate[] {}));
//
//		List<Year> result = entityManager.createQuery(query).getResultList();
//		return result;
//	}

	@Override
	public Year updateYear(Year yearToUpdate) {
		Year year=new Year();
		if(yearToUpdate!=null&&yearToUpdate.getYearId()!=null&&yearToUpdate.getYearName()!=null){
		entityManager.merge(yearToUpdate);
		year=yearToUpdate;
		}
		return year;
	}

	@Override
	public void deleteYearName(Year year) {
		Year yearToRemove = entityManager.find(Year.class, year.getYearId());
		entityManager.remove(yearToRemove);

	}

	//renvoie un objet SearchBySkillResult compos� d'un user d'une liste de 
//	//EvaluatedUser et une liste de Skills
//	@Override
//	public SearchBySkillResult SearchUserBySkills(SearchBySkillResult res){
//		List<User> users = listUser();
//		List<EvaluatedUser> foundUsers=new ArrayList<EvaluatedUser>();
//		for(User user:users){
//			if((user.getAvaibility()==true)&&(user.scoreWithSkills(res.getSearchedSkills())>0)){
//				EvaluatedUser evuser =new EvaluatedUser();
//				evuser.setUser(user);
//				evuser.setLevel(user.scoreWithSkills(res.getSearchedSkills()));
//				foundUsers.add(evuser);
//			}
//		}
//		res.setFoundUsers(foundUsers);
//		return res;
//	}

	@Override
	public void ImportUsers(File file) {
		// TODO Auto-generated method stub

	}

	

	

	@Override
	public Rights insertRights(Rights rights) {
		Rights r=new Rights();
		if(rights!=null&&rights.getRightsLabel()!=null){
			r.setRightsLabel(rights.getRightsLabel());
			entityManager.persist(r);
		}
		return r;
	}

	@Override
	public Rights searchRights(Integer id) {
		Rights rights=new Rights();
		rights= entityManager.find(Rights.class,id);
		return rights;
	}

	@Override
	public Rights updateRights(Rights rightsToUpdate) {
		Rights rights=new Rights();
		if(rightsToUpdate!=null&&rightsToUpdate.getRightsId()!=null&&rightsToUpdate.getRightsLabel()!=null){
		entityManager.merge(rightsToUpdate);
		rights=rightsToUpdate;
		}
		return rights;
	}

	@Override
	public void deleteRights(Rights rights) {
		Rights rightsToRemove = entityManager.find(Rights.class, rights.getRightsId());
		entityManager.remove(rightsToRemove);

	}

	@Override
	public List<Rights> listRights() {
		TypedQuery<Rights> Query=entityManager.createQuery("findAllRights",Rights.class);
		List<Rights> result=Query.getResultList();
		return result;
	}



}
