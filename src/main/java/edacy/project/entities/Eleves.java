package edacy.project.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Eleves implements Serializable{
	@Id @GeneratedValue
	private Long ideleves;
	private String nom;
	private String prenom;
	private String adresse;
	private String tel;
	private String nin;
	private String codeeleves;
	private String email;
	private int etat;
	private Date dateenr;
	@OneToMany(mappedBy="eleves", fetch= FetchType.LAZY)
	private Collection<Inscription> inscriptions;
	public Eleves() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Eleves(String nom, String prenom, String adresse, String tel, String nin, String codeeleves, String email,int etat,Date dateenr) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.tel = tel;
		this.nin = nin;
		this.codeeleves = codeeleves;
		this.email = email;
		this.etat = etat;
		this.dateenr=dateenr;
	}
	
	public Collection<Inscription> getAnnees() {
		return inscriptions;
	}
	public void setAnnees(Collection<Inscription> inscriptions) {
		this.inscriptions = inscriptions;
	}
	public Long getIdeleves() {
		return ideleves;
	}
	public void setIdeleves(Long ideleves) {
		this.ideleves = ideleves;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getNin() {
		return nin;
	}
	public void setNin(String nin) {
		this.nin = nin;
	}
	public String getCodeeleves() {
		return codeeleves;
	}
	public void setCodeeleves(String codeeleves) {
		this.codeeleves = codeeleves;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getEtat() {
		return etat;
	}
	public void setEtat(int etat) {
		this.etat = etat;
	}
	
}
