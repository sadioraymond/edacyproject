package edacy.project.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Classe implements Serializable{
	@Id @GeneratedValue
	private Long idclasse;
	private String nomclasse;
	private String codeclasse;
	private int etat;
	@ManyToOne
	@JoinColumn(name="id_series")
	private Series seriess;
	@OneToMany(mappedBy="classes", fetch= FetchType.LAZY)
	private Collection<Inscription> inscriptions;
	public Classe() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Classe(String nomclasse, String codeclasse, int etat, Series seriess) {
		super();
		this.nomclasse = nomclasse;
		this.codeclasse = codeclasse;
		this.etat = etat;
		this.seriess = seriess;
	}
	
	public int getEtat() {
		return etat;
	}
	public void setEtat(int etat) {
		this.etat = etat;
	}
	public Collection<Inscription> getAnnees() {
		return inscriptions;
	}
	public void setAnnees(Collection<Inscription> inscriptions) {
		this.inscriptions = inscriptions;
	}
	public Long getIdclasse() {
		return idclasse;
	}
	public void setIdclasse(Long idclasse) {
		this.idclasse = idclasse;
	}
	public String getNomclasse() {
		return nomclasse;
	}
	public void setNomclasse(String nomclasse) {
		this.nomclasse = nomclasse;
	}
	public String getCodeclasse() {
		return codeclasse;
	}
	public void setCodeclasse(String codeclasse) {
		this.codeclasse = codeclasse;
	}
	public Series getSeriess() {
		return seriess;
	}
	public void setSeriess(Series seriess) {
		this.seriess = seriess;
	}
	
	
}
