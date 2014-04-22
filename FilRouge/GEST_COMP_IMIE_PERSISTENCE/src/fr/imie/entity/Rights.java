package fr.imie.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the droits database table.
 * 
 */
@Entity
@Table(name="droits")
public class Rights implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer droitsId;
	private String libelle;

	public Rights() {
	}


	@Id
	@Column(name="droits_id")
	public Integer getDroitsId() {
		return this.droitsId;
	}

	public void setDroitsId(Integer droitsId) {
		this.droitsId = droitsId;
	}


	public String getLibelle() {
		return this.libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

}