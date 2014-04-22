package fr.imie.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the statut database table.
 * 
 */
@Entity
@Table(name="statut")
public class Status implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer statusId;
	private String statusName;

	public Status() {
	}


	@Id
	@Column(name="statut_id")
	public Integer getStatusId() {
		return this.statusId;
	}

	public void setStatusId(Integer statutId) {
		this.statusId = statutId;
	}

	@Basic
	@Column(name="libelle")
	public String getStatusName() {
		return this.statusName;
	}

	public void setStatusName(String libelle) {
		this.statusName = libelle;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((statusId == null) ? 0 : statusId.hashCode());
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
		Status other = (Status) obj;
		if (statusId == null) {
			if (other.statusId != null)
				return false;
		} else if (!statusId.equals(other.statusId))
			return false;
		return true;
	}

}