package fr.imie.entity.users;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * The persistent class for the droits database table.
 * 
 */
@Entity
@Table(name="droits",
schema="gestioncomp")
public class Rights implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer rightsId;
	private RightsLabel label;

	public Rights() {
	}


	@Id
	@Column(name="droits_id")
	public Integer getDroitsId() {
		return this.rightsId;
	}

	public void setRightsId(Integer droitsId) {
		this.rightsId = droitsId;
	}

	@Enumerated(EnumType.STRING)
	public RightsLabel getLabel() {
		return this.label;
	}

	public void setLibelle(RightsLabel label) {
		this.label = label;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((rightsId == null) ? 0 : rightsId.hashCode());
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
		if (rightsId == null) {
			if (other.rightsId != null)
				return false;
		} else if (!rightsId.equals(other.rightsId))
			return false;
		return true;
	}


	

}