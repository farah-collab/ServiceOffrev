package com.iset.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Offre {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long code;
	private String intitule;
	private String specialite;
	private String societe;
	private int nbpostes;
	private String pays;

	public Offre() {
		super();
	}

	// Constructeur sans le code (genere automatiquement)
	public Offre(String intitule, String specialite, String societe, int nbpostes, String pays) {
		super();
		this.intitule = intitule;
		this.specialite = specialite;
		this.societe = societe;
		this.nbpostes = nbpostes;
		this.pays = pays;
	}

	// Constructeur avec tous les parametres
	public Offre(long code, String intitule, String specialite, String societe, int nbpostes, String pays) {
		super();
		this.code = code;
		this.intitule = intitule;
		this.specialite = specialite;
		this.societe = societe;
		this.nbpostes = nbpostes;
		this.pays = pays;
	}

	public long getCode() { return code; }
	public void setCode(long code) { this.code = code; }

	public String getIntitule() { return intitule; }
	public void setIntitule(String intitule) { this.intitule = intitule; }

	public String getSpecialite() { return specialite; }
	public void setSpecialite(String specialite) { this.specialite = specialite; }

	public String getSociete() { return societe; }
	public void setSociete(String societe) { this.societe = societe; }

	public int getNbpostes() { return nbpostes; }
	public void setNbpostes(int nbpostes) { this.nbpostes = nbpostes; }

	public String getPays() { return pays; }
	public void setPays(String pays) { this.pays = pays; }
}
