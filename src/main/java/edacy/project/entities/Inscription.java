package edacy.project.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Inscription {
	@Id @GeneratedValue
	private Long idinscription;
	private Date dateinscription;
	@ManyToOne
	@JoinColumn(name="id_classe")
	private Classe classes;
	@ManyToOne
	@JoinColumn(name="id_eleves")
	private Eleves eleves;
	@ManyToOne
	@JoinColumn(name="id_annees")
	private AnneAcademique anneeacas;
	int etat;
	public Long getIdinscription() {
		return idinscription;
	}
	public void setIdinscription(Long idinscription) {
		this.idinscription = idinscription;
	}
	public Date getDateinscription() {
		return dateinscription;
	}
	public void setDateinscription(Date dateinscription) {
		this.dateinscription = dateinscription;
	}
	public Classe getClasses() {
		return classes;
	}
	public void setClasses(Classe classes) {
		this.classes = classes;
	}
	public Eleves getEleves() {
		return eleves;
	}
	public void setEleves(Eleves eleves) {
		this.eleves = eleves;
	}
	public AnneAcademique getAnneeacas() {
		return anneeacas;
	}
	public void setAnneeacas(AnneAcademique anneeacas) {
		this.anneeacas = anneeacas;
	}
	public Inscription() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Inscription(Date dateinscription, Classe classes, Eleves eleves, AnneAcademique anneeacas,int etat) {
		super();
		this.dateinscription = dateinscription;
		this.classes = classes;
		this.eleves = eleves;
		this.anneeacas = anneeacas;
		this.etat=etat;
	}
	public int getEtat() {
		return etat;
	}
	public void setEtat(int etat) {
		this.etat = etat;
	}
	
}
