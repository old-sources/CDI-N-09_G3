package fr.imie.services;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import fr.imie.Iservices.IProjectServices;
import fr.imie.entity.projects.Project;
import fr.imie.entity.projects.Status;
import fr.imie.entity.users.User;

@Stateless(name = "ProjectServices")
@LocalBean
@TransactionManagement(TransactionManagementType.CONTAINER)
public class ProjectServices implements IProjectServices{

	@PersistenceContext(unitName="GEST_COMP_IMIEPU")
	private EntityManager entityManager;

	@Override
	public Project createProject(Project project) {
		Project p=null;

		if((project.getProgress()!=null)
				&&(project.getName()!=null)
				&&(project.getStatus() !=null)
				&&(project.getProjectManager() !=null)){
			p=new Project(project.getProgress(), project.getName(), project.getStatus(), project.getProjectManager());
			
			p.addMember(project.getProjectManager());
			entityManager.persist(p);
		}
		return p;
	}
	//Modifier la fiche projet :
	//		Modifier le wiki groupe
	//		ou Modifier le wiki chef de projet
	//		ou Changer le statut d'un projet
	//		ou Changer de chef de projet
	//	Integer id;
	//	private Integer progress;
	//	private String name;
	//	private String wikiManager;
	//	private String wikiMembers;
	//	private List<User> members;
	//	private Status status;
	//	private User projectManager;
	@Override
	public Project updateProject(Project project) {
		Project projectToUpdate=new Project();
		if(project!=null){
			projectToUpdate = entityManager.find(Project.class, project.getProjetId());
		}
		return projectToUpdate;
	}

	@Override
	public void deleteProject(Project project) {
		if(project!=null){
			Project projectToRemove = entityManager.find(Project.class, project.getProjetId());
			entityManager.remove(projectToRemove);
		}

	}
	
		

	@Override
	public Project findProject(Integer id) {
		
			Project project = new Project();

			TypedQuery<Project> query=entityManager.createNamedQuery("findProjectWithMembers", Project.class);
			query.setParameter("id", id);
			project=query.getSingleResult();
			return project;
		
	}

	@Override
	public List<Project> findAllProjectsWithOutMembers() {
		TypedQuery<Project> query=entityManager.createQuery("SELECT p FROM Project p ",Project.class);
		List<Project> result=query.getResultList();
		for(Project project:result){
			project.setMembers(null);
			project.getProjectManager().setEvaluatedSkills(null);
		}
		return result;
	}

	@Override
	public List<Project> findProjects(User user) {
		List<Project> projects=new ArrayList<Project>();

		if(user!=null){
			Integer id=user.getUserId();

			TypedQuery<Project> query=entityManager.createNamedQuery("SELECT p FROM Project p join fetch p.members WHERE p.projectId=:id", Project.class);
			query.setParameter("id", id);
			projects=query.getResultList();
		}
		return projects;
	}

	@Override
	public Status insertStatus(Status status) {
		Status s=new Status();
		if(status!=null&&status.getStatusName()!=null){
			s.setStatusName(status.getStatusName());
			entityManager.persist(s);
		}
		return s;
	}

	@Override
	public Status findStatusById(Integer id) {
		Status status=new Status();
		status=entityManager.find(Status.class, id);
		return status;
	}

	@Override
	public Status updateStatus(Status statusToUpdate) {
		Status status=new Status();
		if(statusToUpdate!=null&&statusToUpdate.getStatusId()!=null&&statusToUpdate.getStatusName()!=null){
			entityManager.merge(statusToUpdate);
			status=statusToUpdate;
		}
		return status;
	}
	@Override
	public void deleteStatus(Status status) {
		Status statusToRemove = entityManager.find(Status.class, status.getStatusId());
		entityManager.remove(statusToRemove);

	}
	


}
