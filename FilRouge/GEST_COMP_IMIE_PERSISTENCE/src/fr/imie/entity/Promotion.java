package fr.imie.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the promotion database table.
 * 
 */
@Entity
@Table(name="promotion")
public class Promotion implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer idpromotion;
	private String intitule;

	public Promotion() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	public Integer getIdpromotion() {
		return this.idpromotion;
	}

	public void setIdpromotion(Integer idpromotion) {
		this.idpromotion = idpromotion;
	}


	@Column(length=25)
	public String getIntitule() {
		return this.intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

}