package edacy.project.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Roles implements Serializable {
	@Id @GeneratedValue
	private Long id_role;
	private String role;
	public Roles() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Roles(String role) {
		super();
		this.role = role;
	}
	public Long getId_role() {
		return id_role;
	}
	public void setId_role(Long id_role) {
		this.id_role = id_role;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
}
