package fr.imie.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the candidater database table.
 * 
 */
@Entity
@Table(name="candidater")
public class candidate implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer candidateId;
	private Date candidateDate;
	private Date candidDecisionDate;
	
	private Project project;
	private User candidateUser;

	public candidate() {
	}


	@Id
	@Column(name="candidater_id")
	public Integer getCandidateId() {
		return this.candidateId;
	}

	public void setCandidateId(Integer candidaterId) {
		this.candidateId = candidaterId;
	}


	@Temporal(TemporalType.DATE)
	@Column(name="date_candid")
	public Date getCandidateDate() {
		return this.candidateDate;
	}

	public void setCandidateDate(Date candidateDate) {
		this.candidateDate = candidateDate;
	}


	@Temporal(TemporalType.DATE)
	@Column(name="date_decision_candid")
	public Date getCandidDecisionDate() {
		return this.candidDecisionDate;
	}

	public void setCandidDecisionDate(Date dateDecisionCandid) {
		this.candidDecisionDate = dateDecisionCandid;
	}




	//uni-directional many-to-one association to Project
	@ManyToOne
	@JoinColumn(name="projet_id")
	public Project getProject() {
		return this.project;
	}

	public void setProject(Project project) {
		this.project = project;
	}


	//uni-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="utilisateur_id")
	public User getCandidateUser() {
		return this.candidateUser;
	}

	public void setCandidateUser(User candidateUser) {
		this.candidateUser = candidateUser;
	}

}