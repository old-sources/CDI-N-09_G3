package fr.imie.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the projet database table.
 * 
 */
@Entity
@Table(name="projet")
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
		this.progress = avancement;
	}

	@Column(name="nom")
	public String getName() {
		return this.name;
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

}