package edacy.project.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Series implements Serializable{
	@Id @GeneratedValue
	private Long idseries;
	private String libelle;
	private int etat;
	@OneToMany(mappedBy="seriess", fetch= FetchType.LAZY)
	private Collection<Classe> classes;
	public Series() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Series(String libelle, int etat) {
		super();
		this.libelle = libelle;
		this.etat = etat;
	}
	public Long getIdseries() {
		return idseries;
	}
	public void setIdseries(Long idseries) {
		this.idseries = idseries;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public int getEtat() {
		return etat;
	}
	public void setEtat(int etat) {
		this.etat = etat;
	}
	public Collection<Classe> getClasses() {
		return classes;
	}
	public void setClasses(Collection<Classe> classes) {
		this.classes = classes;
	}
	
}
