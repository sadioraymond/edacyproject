package edacy.project.metier;

import java.util.List;

import org.springframework.data.domain.Page;

import edacy.project.entities.AnneAcademique;
import edacy.project.entities.Classe;
import edacy.project.entities.Eleves;
import edacy.project.entities.Inscription;
import edacy.project.entities.Series;

public interface IEdacy {
	public void save(Object O);
	public Page<Series> listSeries(int page,int size);
	public Series findOneseri(Long idserie);
	public List<Series> allseries();
	public Long countclasse();
	public Page<Classe> listClasses(int page,int size);
	public Classe findoneclasse(Long id_classe);
	public List<Classe> allclasses();
	public List<AnneAcademique> allanneeaca();
	public Long counteleves();
	public Classe findOneClasse(Long idclasse);
	public AnneAcademique findOneAnneeAca(Long idanneeaca);
	public Eleves derniereleves();
	public Page<Eleves> listEleves(int page,int size);
	public Eleves findbynin(String nin);
	public Eleves findOneeleve(Long ideleves);
	public Page<Inscription> listInscriptions(int page,int size);
	public Inscription findOneinscription(Long idinscription);
	public Page<AnneAcademique> listAnneeaca(int page,int size);
}
