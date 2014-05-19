package fr.imie.entity.notification;
import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import fr.imie.entity.projects.Project;

@Entity(name="fr.imie.entity.Candidature")
@DiscriminatorValue("CANDIDATURE")
public class Candidature extends Notification implements Serializable{
		
		private static final long serialVersionUID = 1L;
		private Project project;
		
		
		@ManyToOne(
				cascade={ CascadeType.PERSIST, CascadeType.MERGE},
				optional=false)
		@JoinColumn(name="projet_id")
		public Project getProject() {
			return project;
		}
		public void setProject(Project project) {
			this.project = project;
		}
		
		
		
		
	}
