package fr.imie.Iservices;

import java.util.List;

import javax.ejb.Local;

import fr.imie.entity.Skill;
import fr.imie.entity.User;
import fr.imie.entity.Year;

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
	 * @param List<Skill> listSkill
	 * @return List<User>
	 */
	public abstract List<User> searchUserBySkill(List<Skill> listSkills);

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
	
	/**
	 * @param Year
	 * @return List<Year>
	 */
	public abstract List<Year> searchYear(Year year);
	
	/**
	 * @param YearToUpdate
	 * @return Year
	 */
	public abstract Year updateYearName(Year yearToUpdate);

	/**
	 * @param Year
	 */
	public abstract void deleteYearName(Year yearName);





	
	
}
