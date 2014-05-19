package fr.imie.entity.notification;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import fr.imie.entity.projects.Project;
import fr.imie.entity.users.User;

@Entity(name="fr.imie.entity.Invitation")
@DiscriminatorValue("INVITATION")
public class Invitation extends Notification implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Project project;
	private User ConcernedManager;
	
	@ManyToOne
	@JoinColumn(name="projet_id")
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	
	
	
	
}
