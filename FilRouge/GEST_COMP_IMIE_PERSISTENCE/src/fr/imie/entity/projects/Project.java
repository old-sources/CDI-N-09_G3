package fr.imie.entity.projects;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import fr.imie.entity.users.User;


/**
 * The persistent class for the projet database table.
 * 
 */
@Entity
@Table(name="projet",
schema="gestioncomp")
public class Project implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer projectId;
	private Integer progress;
	private String name;
	private String wikiManager;
	private String wikiMembers;
	
	private List<User> members;
	private Status status;
	private User projectManager;
	private Date CreationDate;
	

	@Temporal(TemporalType.DATE)
	@Column(name="date_creation")
	public Date getCreationDate() {
		return CreationDate;
	}


	public void setCreationDate(Date creationDate) {
		CreationDate = creationDate;
	}


	public Project() {
	}


	@Id
	@Column(name="projet_id")
	@GeneratedValue(
			strategy=GenerationType.AUTO)
	public Integer getProjetId() {
		return this.projectId;
	}

	public void setProjetId(Integer projetId) {
		this.projectId = projetId;
	}

	@Basic
	@Column(name="avancement")
	public Integer getProgress() {
		return this.progress;
	}

	public void setProgress(Integer avancement) {
//		if(avancement>0&&avancement<=100){
			this.progress = avancement;
//		}
	}

	@Column(name="nom")
	public String getName() {
		return this.name;
	}

	public Project(Integer progress, String name, Status status,
			User projectManager) {
		super();
		this.progress = progress;
		this.name = name;
		this.status = status;
		this.projectManager = projectManager;
	}


	public void setName(String nom) {
		this.name = nom;
	}

	
	@Column(name="wiki_cdp")
	public String getWikiManager() {
		return this.wikiManager;
	}

	public void setWikiManager(String wikiCdp) {
		this.wikiManager = wikiCdp;
	}


	@Column(name="wiki_groupe")
	public String getWikiMembers() {
		return this.wikiMembers;
	}

	public void setWikiMembers(String wikiGroupe) {
		this.wikiMembers = wikiGroupe;
	}


	//uni-directional many-to-many association to User
@ManyToMany
@JoinTable(name="gestioncomp.participer"
		,
		joinColumns={
			@JoinColumn(name="projet_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="utilisateur_id")
			}
		)
	public List<User> getMembers() {
		return this.members;
	}

	public void setMembers(List<User> members) {
		this.members = members;
	}


	//uni-directional many-to-one association to Status
	@ManyToOne
	@JoinColumn(name="statut_id")
	public Status getStatus() {
		return this.status;
	}

	public void setStatus(Status statut) {
		this.status = statut;
	}


	//uni-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="chef_projet_id")
	public User getProjectManager() {
		return this.projectManager;
	}

	public void setProjectManager(User projectManager) {
		this.projectManager = projectManager;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((projectId == null) ? 0 : projectId.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Project other = (Project) obj;
		if (projectId == null) {
			if (other.projectId != null)
				return false;
		} else if (!projectId.equals(other.projectId))
			return false;
		return true;
	}

	public void addMember(User userToIntegrate) {
		
		if (userToIntegrate!=null){
			members.add(userToIntegrate);
		}
	}
	public Boolean  removeMember(User userToIntegrate) {
			return members.remove(userToIntegrate);	
	}

}