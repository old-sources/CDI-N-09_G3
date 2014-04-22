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

}