package fr.imie.entity.users;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * The persistent class for the promotion database table.
 * 
 */
@Entity
@Table(name="promotion",
schema="gestioncomp")
public class Year implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer yearId;
	private String yearName;

	public Year() {
	}


	@Id
	@Column(name="promotion_id")
	public Integer getYearId() {
		return this.yearId;
	}

	public void setYearId(Integer promotionId) {
		this.yearId = promotionId;
	}

	@Basic
	@Column(name="intitule")
	public String getYearName() {
		return this.yearName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((yearId == null) ? 0 : yearId.hashCode());
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
		Year other = (Year) obj;
		if (yearId == null) {
			if (other.yearId != null)
				return false;
		} else if (!yearId.equals(other.yearId))
			return false;
		return true;
	}


	public void setYearName(String intitule) {
		this.yearName = intitule;
	}

}