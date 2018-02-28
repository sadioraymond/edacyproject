package edacy.project.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class AnneAcademique implements Serializable{
	@Id @GeneratedValue
	private Long idanneeaca;
	private String anneeaca;
	private int termine;
	private int etat;
	@OneToMany(mappedBy="anneeacas", fetch= FetchType.LAZY)
	private Collection<Inscription> inscriptions;
	public AnneAcademique() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getIdanneeaca() {
		return idanneeaca;
	}
	public void setIdanneeaca(Long idanneeaca) {
		this.idanneeaca = idanneeaca;
	}
	public String getAnneeaca() {
		return anneeaca;
	}
	public void setAnneeaca(String anneeaca) {
		this.anneeaca = anneeaca;
	}
	public Collection<Inscription> getInscriptions() {
		return inscriptions;
	}
	public void setInscriptions(Collection<Inscription> inscriptions) {
		this.inscriptions = inscriptions;
	}
	public int getTermine() {
		return termine;
	}
	public void setTermine(int termine) {
		this.termine = termine;
	}
	public AnneAcademique(String anneeaca, int termine,int etat) {
		super();
		this.anneeaca = anneeaca;
		this.termine = termine;
		this.etat=etat;
	}
	public int getEtat() {
		return etat;
	}
	public void setEtat(int etat) {
		this.etat = etat;
	}
	

	
	
}
