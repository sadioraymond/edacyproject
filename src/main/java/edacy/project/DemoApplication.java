package edacy.project;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus.Series;

import edacy.project.dao.AnneeAcaRepository;
import edacy.project.dao.ClasseRepository;
import edacy.project.dao.ElevesRepository;
import edacy.project.dao.InscriptionRepository;
import edacy.project.dao.RolesRepository;
import edacy.project.dao.SeriesRepository;
import edacy.project.dao.Users_RolesRepository;
import edacy.project.dao.UtilisateurRepository;
import edacy.project.entities.AnneAcademique;
import edacy.project.entities.Classe;
import edacy.project.entities.Eleves;
import edacy.project.entities.Inscription;
import edacy.project.entities.Roles;
import edacy.project.entities.Users_Roles;
import edacy.project.entities.Utilisateur;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	private UtilisateurRepository userrepo;
	@Autowired
	private Users_RolesRepository userrolerepo;
	@Autowired
	private RolesRepository rolerepo;
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		// TODO Auto-generated method stub
		Utilisateur user=userrepo.save(new Utilisateur("demba@sarr.com","1234",true));
		Roles rol=rolerepo.save(new Roles("ADMIN"));
		Users_Roles usrol=userrolerepo.save(new Users_Roles("demba@sarr.com","ADMIN"));
		
	}
}
