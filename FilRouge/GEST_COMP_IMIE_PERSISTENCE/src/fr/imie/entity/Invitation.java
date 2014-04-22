package fr.imie.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the etre_invite database table.
 * 
 */
@Entity
@Table(name="etre_invite")
public class Invitation implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer invitationId;
	private Date invitationDecisionDate;
	private Date invitationDate;
	
	private Project project;
	private User invitedUser;

	public Invitation() {
	}


	@Id
	@Column(name="est_invite_id")
	public Integer getInvitedId() {
		return this.invitationId;
	}

	public void setInvitationId(Integer estInviteId) {
		this.invitationId = estInviteId;
	}


	@Temporal(TemporalType.DATE)
	@Column(name="date_decision_invit")
	public Date getInvitationDecisionDate() {
		return this.invitationDecisionDate;
	}

	public void setInvitationDecisionDate(Date dateDecisionInvit) {
		this.invitationDecisionDate = dateDecisionInvit;
	}


	@Temporal(TemporalType.DATE)
	@Column(name="date_invit")
	public Date getInvitationDate() {
		return this.invitationDate;
	}

	public void setInvitationDate(Date dateInvit) {
		this.invitationDate = dateInvit;
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
	public User getInvitedUser() {
		return this.invitedUser;
	}

	public void setInvitedUser(User invitedUser) {
		this.invitedUser = invitedUser;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((invitationId == null) ? 0 : invitationId.hashCode());
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
		Invitation other = (Invitation) obj;
		if (invitationId == null) {
			if (other.invitationId != null)
				return false;
		} else if (!invitationId.equals(other.invitationId))
			return false;
		return true;
	}

}