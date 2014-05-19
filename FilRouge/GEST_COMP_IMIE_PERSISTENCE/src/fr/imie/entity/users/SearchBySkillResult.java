package fr.imie.entity.users;

import java.util.List;

import fr.imie.entity.skills.Skill;

public class SearchBySkillResult {
	private List<Skill> searchedSkills;
	private List<EvaluatedUser> foundUsers;
	private User AskingUser;

	public List<Skill> getSearchedSkills() {
		return searchedSkills;
	}
	public void setSearchedSkills(List<Skill> searchedSkills) {
		this.searchedSkills = searchedSkills;
	}
	public List<EvaluatedUser> getFoundUsers() {
		return foundUsers;
	}
	public void setFoundUsers(List<EvaluatedUser> foundUsers) {
		this.foundUsers = foundUsers;
	}
	public User getAskingUser() {
		return AskingUser;
	}
	public void setAskingUser(User askingUser) {
		AskingUser = askingUser;
	}
	
}
