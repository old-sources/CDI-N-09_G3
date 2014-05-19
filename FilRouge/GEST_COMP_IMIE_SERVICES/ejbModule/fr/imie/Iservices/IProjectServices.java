package fr.imie.Iservices;

import java.util.List;

import fr.imie.entity.projects.Project;
import fr.imie.entity.projects.Status;
import fr.imie.entity.users.User;

public interface IProjectServices {

//	Créer un projet
	public abstract Project createProject(Project project);
	
//	Modifier la fiche projet :
//	Modifier le wiki groupe
//	ou Modifier le wiki chef de projet
//	ou Changer le statut d'un projet
//	ou Changer de chef de projet
//	Supprimer un membre du groupe projet
	
	//Ajouter un membre au groupe projets
	public abstract Project updateProject(Project project);
	
//supprimer un projet
	public abstract void deleteProject(Project project);
	
// chercher un projet
	public abstract Project findProject(Integer id);
	
//chercher les projets d'un utilisateur
	public abstract List<Project> findProjects(User user);




	// CRUD statut
	public abstract Status updateStatus(Status status);
	
	//supprimer un projet
		public abstract void deleteProject(Status status);
		
	// chercher un projet
		public abstract List<Status> findStatusById(int id);
		
	//chercher les projets d'un utilisateur
		public abstract Status createStatus(Status status);

		
	

}
