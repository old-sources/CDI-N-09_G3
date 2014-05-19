package fr.imie.entity.notification;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import fr.imie.entity.users.User;


@Entity(name="fr.imie.entity.Notification")
@Table(name="notification",
schema="gestioncomp")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
		name = "DTYPE",
		discriminatorType = DiscriminatorType.STRING
		)

public abstract class Notification {
	
	private Date notifDate;
	private Date decisionDate;
	private Integer notificationId;
	private Boolean decision;
	private User concernedUser;

	@Id
	@Column(name="notif_id")
	@GeneratedValue(
			strategy=GenerationType.AUTO)
	public Integer getNotificationId() {
		return this.notificationId;
	}
	public void setNotificationId(Integer notificationId) {
		this.notificationId = notificationId;
	}
	@Temporal(TemporalType.DATE)
	@Column(name="date_notif", nullable=false)
	public Date getNotifDate() {
		return notifDate;
	}
	public void setNotifDate(Date notifDate) {
		this.notifDate = notifDate;
	}
	@Temporal(TemporalType.DATE)
	@Column(name="date_decision", nullable=true)
	public Date getDecisionDate() {
		return decisionDate;
	}
	
	public void setDecisionDate(Date decisionDate) {
		this.decisionDate = decisionDate;
	}
	
	@Column(name="decision", nullable=true)
	public Boolean getDecision() {
		return decision;
	}
	public void setDecision(Boolean decision) {
		this.decision = decision;
	}
	
	@ManyToOne(
			cascade={ CascadeType.PERSIST, CascadeType.MERGE},
			optional=false)
	@JoinColumn(name="utilisateur_id")
	public User getConcernedUser() {
		return concernedUser;
	}
	public void setConcernedUser(User concernedUser) {
		this.concernedUser = concernedUser;
	}
	
	

}
