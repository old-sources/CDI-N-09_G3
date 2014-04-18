package fr.imie.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the utilisateur database table.
 * 
 */
@Entity
@Table(name="utilisateur")
public class Utilisateur implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idutilisateur;
	private String description;
	private Boolean dispo;
	private Integer iddroits;
	private String login;
	private String mail;
	private String mdp;
	private String nom;
	private String prenom;
	private Boolean protectionDonnee;
	private List<Competence> competences;
	private Promotion promotion;

	public Utilisateur() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	public Integer getIdutilisateur() {
		return this.idutilisateur;
	}

	public void setIdutilisateur(Integer idutilisateur) {
		this.idutilisateur = idutilisateur;
	}


	@Column(length=2000)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	public Boolean getDispo() {
		return this.dispo;
	}

	public void setDispo(Boolean dispo) {
		this.dispo = dispo;
	}


	public Integer getIddroits() {
		return this.iddroits;
	}

	public void setIddroits(Integer iddroits) {
		this.iddroits = iddroits;
	}


	@Column(length=25)
	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}


	@Column(length=25)
	public String getMail() {
		return this.mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}


	@Column(length=25)
	public String getMdp() {
		return this.mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}


	@Column(length=25)
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}


	@Column(length=25)
	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	@Column(name="protection_donnee")
	public Boolean getProtectionDonnee() {
		return this.protectionDonnee;
	}

	public void setProtectionDonnee(Boolean protectionDonnee) {
		this.protectionDonnee = protectionDonnee;
	}


	//uni-directional many-to-many association to Competence
	@ManyToMany
	@JoinTable(
		name="posseder"
		, joinColumns={
			@JoinColumn(name="idutilisateur", nullable=false)
			}
		, inverseJoinColumns={
			@JoinColumn(name="idcompetence", nullable=false)
			}
		)
	public List<Competence> getCompetences() {
		return this.competences;
	}

	public void setCompetences(List<Competence> competences) {
		this.competences = competences;
	}


	//uni-directional many-to-one association to Promotion
	@ManyToOne
	@JoinColumn(name="idpromotion")
	public Promotion getPromotion() {
		return this.promotion;
	}

	public void setPromotion(Promotion promotion) {
		this.promotion = promotion;
	}

}