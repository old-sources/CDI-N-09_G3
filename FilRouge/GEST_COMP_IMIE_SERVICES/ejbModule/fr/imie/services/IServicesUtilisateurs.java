package fr.imie.services;

import java.util.List;

import javax.ejb.Local;

import fr.imie.entity.Competence;
import fr.imie.entity.Promotion;
import fr.imie.entity.Utilisateur;

@Local
public interface IServicesUtilisateurs {
	
	/**
	 * @param personne
	 * @return Utilisateur
	 */
	public abstract Utilisateur insertUser(Utilisateur utilisateur);
	
	/**
	 * @param personne
	 * @return List<Utilisateur>
	 */
	public abstract Utilisateur searchUserByID(int ID);
	
	/**
	 * @return List<Utilisateur>
	 */
	public abstract List<Utilisateur> listerUser();
	
	/**
	 * @param List<Promotion> listPromo
	 * @return List<Utilisateur>
	 */
	public abstract List<Utilisateur> searchUserBySkill(List<Competence> listCompetence);

	/**
	 * @param personneToUpdate
	 * @return Utilisateur
	 */
	public abstract Utilisateur updateUser(Utilisateur utilisateurToUpdate);
	
	/**
	 * @param personne
	 */
	public abstract void deleteUser(Utilisateur utilisateur);

	/**
	 * @param personne
	 * @return Utilisateur
	 */
	public abstract Utilisateur verifierAuthPersonne(Utilisateur utilisateur);
	
	

	/**
	 * @param Promotion
	 * @return Promotion
	 */
	public abstract Promotion insertPromotion(Promotion promotion);
	
	/**
	 * @param Promotion
	 * @return List<Promotion>
	 */
	public abstract List<Promotion> searchPromotion(Promotion promotion);
	
	/**
	 * @param PromotionToUpdate
	 * @return Promotion
	 */
	public abstract Promotion updatePromotion(Promotion promotionToUpdate);

	/**
	 * @param Promotion
	 */
	public abstract void deletePromotion(Promotion promotion);





	
	
}
