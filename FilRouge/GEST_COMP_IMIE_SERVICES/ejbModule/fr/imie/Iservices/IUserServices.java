package fr.imie.Iservices;

import java.io.File;
import java.util.List;

import javax.ejb.Local;

import fr.imie.entity.projects.Status;
import fr.imie.entity.users.Rights;
import fr.imie.entity.users.SearchBySkillResult;
import fr.imie.entity.users.User;
import fr.imie.entity.users.Year;

@Local
public interface IUserServices {

	/**
	 * @param User
	 * @return User
	 */
	public abstract User insertUser(User user);

	/**
	 * @param ID
	 * @return User
	 */
	public abstract User searchUserByID(int ID);

	/**
	 * @return List<User>
	 */
	public abstract List<User> listUser();




	/**
	 * @param userToUpdate
	 * @return User
	 */
	public abstract User updateUser(User userToUpdate);

	/**
	 * @param User
	 */
	public abstract void deleteUser(User user);

	/**
	 * @param User
	 * @return User
	 */
	public abstract User verifyAuthUser(User user);



	/**
	 * @param Year
	 * @return Year
	 */
	public abstract Year insertYear(Year year);

	public abstract Year searchYear(Integer id);

	/**
	 * @param YearToUpdate
	 * @return Year
	 */
	public abstract Year updateYear(Year yearToUpdate);

	/**
	 * @param Year
	 */
	void deleteYearName(Year year);

	public abstract SearchBySkillResult SearchUserBySkills(SearchBySkillResult res);


	public abstract void ImportUsers(File file);



	public abstract Rights insertRights(Rights rights);

	/**
	 * @param Year
	 * @return List<Year>
	 */
	public abstract List<Rights> listRights();

	/**
	 * @param YearToUpdate
	 * @return Year
	 */
	public abstract Rights updateRights(Rights rightsToUpdate);

	/**
	 * @param Year
	 */
	public abstract void deleteRights(Rights rights);

	



	public abstract Rights searchRights(Integer id);

	






}
