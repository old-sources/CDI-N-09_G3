package fr.imie.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import fr.imie.Iservices.INotificationServices;
import fr.imie.entity.notification.Candidature;
import fr.imie.entity.notification.Invitation;
import fr.imie.entity.notification.Notification;
import fr.imie.entity.notification.Proposition;
import fr.imie.entity.skills.Skill;
import fr.imie.entity.users.User;

@Stateless(name = "NotificationServices")
@LocalBean
@TransactionManagement(TransactionManagementType.CONTAINER)
public class NotificationServices implements INotificationServices {
	@PersistenceContext(unitName="GEST_COMP_IMIE")
	private EntityManager entityManager;


	@Override
	public Notification submit(Notification notif) {
		Notification n=null;
		if(notif!=null){
			if(notif.getNotifDate()==null){
				notif.setNotifDate(new Date());
			}
			if(notif instanceof Proposition){
				Skill skill=new Skill();
				skill=((Proposition)notif).getSkill();
				skill.setValidation(false);
				entityManager.persist(skill);
			}
			entityManager.persist(notif);
			n=notif;
		}

		return n;
	}
	public Notification update(Notification notif) {
		entityManager.merge(notif);
		return notif;
	}
	@Override
	public Notification accept(Notification notif) {

		if(notif!=null){
			if(notif.getDecision()==null&&notif.getDecisionDate()==null){
				notif.setDecision(true);
				notif.setDecisionDate(new Date());
			}
			if(notif instanceof Proposition){
				((Proposition)notif).getSkill().setValidation(true);				
			}
			if(notif instanceof Invitation){
				((Invitation)notif).getProject().addMember(notif.getConcernedUser());
			}
			if(notif instanceof Candidature){
				((Candidature)notif).getProject().addMember(notif.getConcernedUser());
			}
			return update(notif);

		}
		return null;
	}

	@Override
	public Notification refuse(Notification notif) {
		if(notif!=null){
			if(notif.getDecision()==null&&notif.getDecision()==false){
				notif.setDecision(false);
				notif.setDecisionDate(new Date());
			if(notif instanceof Proposition){
					entityManager.remove(((Proposition)notif).getSkill());				
				}
			}
			return update(notif);

		}

		return null;
	}

	@Override
	public void delete(Notification notif) {
		
			Notification notifToRemove = entityManager.find(Notification.class, notif.getNotificationId());
			entityManager.remove(notifToRemove);
	}


	@Override
	public List<Notification> findNotif(User user) {
		List<Notification> UserNotif=new ArrayList<Notification>();
		if (user!=null){
			User concernedUser=entityManager.find(User.class, user.getUserId());
			TypedQuery<Notification> queryNotif;
			String notifsSelect = "SELECT n FROM Notification n";
			notifsSelect += " where n.concernedUser = :fId";
			queryNotif = entityManager.createQuery(notifsSelect,Notification.class);
			queryNotif.setParameter("fId", concernedUser.getUserId());
			if(queryNotif.getResultList()!=null){
				UserNotif.addAll(queryNotif.getResultList());


				TypedQuery<Candidature> queryCandid;
				String candidSelect = "SELECT c FROM Candidature c";
				candidSelect += " where c.project.manager.UserId = :fId";
				queryCandid = entityManager.createQuery(candidSelect,Candidature.class);
				queryCandid.setParameter("fId", user.getUserId());
				if(queryCandid.getResultList()!=null){
					UserNotif.addAll(queryCandid.getResultList());

				}
				TypedQuery<Invitation> queryInvit;
				String invitSelect = "SELECT i FROM Invitation i";
				invitSelect += " where i.project.manager.UserId = :fId";
				queryInvit = entityManager.createQuery(invitSelect,Invitation.class);
				queryInvit.setParameter("fId", user.getUserId());
				if(queryInvit.getResultList()!=null){
					UserNotif.addAll(queryInvit.getResultList());
				}

				if(user.getRights().getRightsLabel().equals("admin")||user.getRights().getRightsLabel().equals("superadmin")){
					TypedQuery<Proposition> queryProp;
					String proposeSelect="SELECT p FROM Proposition p";
					queryProp = entityManager.createQuery(proposeSelect,Proposition.class);

					if(queryProp.getResultList()!=null){
						UserNotif.addAll(queryProp.getResultList());
					}
				}

			}

		}
		return UserNotif;
	}
}

