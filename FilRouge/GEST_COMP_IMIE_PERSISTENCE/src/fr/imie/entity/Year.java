package fr.imie.entity;

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
@Table(name="promotion")
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

	public void setYearName(String intitule) {
		this.yearName = intitule;
	}

}