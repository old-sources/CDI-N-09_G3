package fr.imie.Iservices;

import java.util.List;

import fr.imie.entity.notification.Notification;
import fr.imie.entity.users.User;

public interface INotificationServices {
//	créer une notification
	public Notification submit(Notification notif);
//	Accepter l'action demandée par la notification
	public Notification accept(Notification notif);
//	Refuser une notification
	public Notification refuse(Notification notif);

//supprimer une notification
	public void delete(Notification notif);

	// retrieve all the notifications of a user
	public List<Notification> findNotif(User user);
	
}
