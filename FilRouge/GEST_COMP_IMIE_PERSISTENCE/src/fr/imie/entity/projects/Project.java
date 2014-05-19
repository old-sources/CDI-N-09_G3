package fr.imie.entity.projects;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
	private Integer id;
	private Integer progress;
	private String name;
	private String wikiManager;
	private String wikiMembers;
	private List<User> members;
	private Status status;
	private User projectManager;

	public Project() {
	}


	@Id
	@Column(name="projet_id")
	public Integer getProjetId() {
		return this.id;
	}

	public void setProjetId(Integer projetId) {
		this.id = projetId;
	}

	@Column(name="avancement")
	public Integer getProgress() {
		return this.progress;
	}

	public void setProgress(Integer avancement) {
		if(avancement>0&&avancement<=5)	this.progress = avancement;
	}

	@Column(name="nom")
	public String getName() {
		return this.name;
	}

	public void setName(String nom) {
		this.name = nom;
	}

	@Lob
	@Column(name="wiki_cdp")
	public String getWikiManager() {
		return this.wikiManager;
	}

	public void setWikiManager(String wikiCdp) {
		this.wikiManager = wikiCdp;
	}

	@Lob
	@Column(name="wiki_groupe")
	public String getWikiMembers() {
		return this.wikiMembers;
	}

	public void setWikiMembers(String wikiGroupe) {
		this.wikiMembers = wikiGroupe;
	}


	//uni-directional many-to-many association to User
	@ManyToMany
	@JoinTable(
		name="participer"
		, joinColumns={
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
	@JoinColumn(name="id_chef_projet")
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
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


	public void addMember(User userToIntegrate) {
		List<User> users=new ArrayList<User>();
		if (userToIntegrate!=null){
			users.add(userToIntegrate);
			setMembers(users);
		}
		
	}

}