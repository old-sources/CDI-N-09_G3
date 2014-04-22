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


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((droitsId == null) ? 0 : droitsId.hashCode());
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
		Rights other = (Rights) obj;
		if (droitsId == null) {
			if (other.droitsId != null)
				return false;
		} else if (!droitsId.equals(other.droitsId))
			return false;
		return true;
	}


	

}