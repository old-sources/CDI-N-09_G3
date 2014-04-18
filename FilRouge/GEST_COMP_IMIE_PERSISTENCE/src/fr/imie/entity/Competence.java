package fr.imie.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the competence database table.
 * 
 */
@Entity
@Table(name="competence")
public class Competence implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idcompetence;
	private Date dateDecisionProp;
	private Date dateProp;
	private Integer idutilisateurProp;
	private String nom;
	private Boolean retourDecisionProp;
	private Boolean validation;
	private Competence competenceMere;
	private List<Competence> competences;

	public Competence() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	public Integer getIdcompetence() {
		return this.idcompetence;
	}

	public void setIdcompetence(Integer idcompetence) {
		this.idcompetence = idcompetence;
	}


	@Temporal(TemporalType.DATE)
	@Column(name="date_decision_prop")
	public Date getDateDecisionProp() {
		return this.dateDecisionProp;
	}

	public void setDateDecisionProp(Date dateDecisionProp) {
		this.dateDecisionProp = dateDecisionProp;
	}


	@Temporal(TemporalType.DATE)
	@Column(name="date_prop")
	public Date getDateProp() {
		return this.dateProp;
	}

	public void setDateProp(Date dateProp) {
		this.dateProp = dateProp;
	}


	@Column(name="idutilisateur_prop")
	public Integer getIdutilisateurProp() {
		return this.idutilisateurProp;
	}

	public void setIdutilisateurProp(Integer idutilisateurProp) {
		this.idutilisateurProp = idutilisateurProp;
	}


	@Column(length=25)
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}


	@Column(name="retour_decision_prop")
	public Boolean getRetourDecisionProp() {
		return this.retourDecisionProp;
	}

	public void setRetourDecisionProp(Boolean retourDecisionProp) {
		this.retourDecisionProp = retourDecisionProp;
	}


	public Boolean getValidation() {
		return this.validation;
	}

	public void setValidation(Boolean validation) {
		this.validation = validation;
	}


	//bi-directional many-to-one association to Competence
	@ManyToOne
	@JoinColumn(name="idcompetence_mere")
	public Competence getCompetenceMere() {
		return this.competenceMere;
	}

	public void setCompetenceMere(Competence competenceMere) {
		this.competenceMere = competenceMere;
	}


	//bi-directional many-to-one association to Competence
	@OneToMany(mappedBy="competenceMere")
	public List<Competence> getCompetences() {
		return this.competences;
	}

	public void setCompetences(List<Competence> competences) {
		this.competences = competences;
	}

	public Competence addCompetence(Competence competence) {
		getCompetences().add(competence);
		competence.setCompetenceMere(this);

		return competence;
	}

	public Competence removeCompetence(Competence competence) {
		getCompetences().remove(competence);
		competence.setCompetenceMere(null);

		return competence;
	}

}