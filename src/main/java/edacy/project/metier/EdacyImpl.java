package edacy.project.metier;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edacy.project.dao.AnneeAcaRepository;
import edacy.project.dao.ClasseRepository;
import edacy.project.dao.ElevesRepository;
import edacy.project.dao.InscriptionRepository;
import edacy.project.dao.SeriesRepository;
import edacy.project.entities.AnneAcademique;
import edacy.project.entities.Classe;
import edacy.project.entities.Eleves;
import edacy.project.entities.Inscription;
import edacy.project.entities.Series;

//pour que spring puisse instancier cette classe au demarrage
	@Service
	//pour demander a spring de gerer les transactions au niveau de la couche metier
	@Transactional
public class EdacyImpl implements IEdacy {
	
	@Autowired
	private SeriesRepository serierepo;
	@Autowired
	private ClasseRepository classerepo;
	@Autowired
	private InscriptionRepository inscrirepo;
	@Autowired
	private ElevesRepository eleverepo;
	@Autowired
	private AnneeAcaRepository anneeacarepo;
	
	@Override
	public void save(Object O) {
		// TODO Auto-generated method stub
		
		//Verifier si l'objet est une instance de Serie
		if(O instanceof edacy.project.entities.Series) {
			Series se=new Series();
			se=(Series) O;
			serierepo.save(se);	
		}
		//Verifier si l'objet est une instance de Classe
				if(O instanceof Classe) {
					Classe cl=new Classe();
					cl=(Classe) O;
					classerepo.save(cl);	
				}
	 //Verifier si l'objet est une instance de Eleves
				if(O instanceof Eleves) {
					Eleves el=new Eleves();
					el=(Eleves) O;
					eleverepo.save(el);
				}
		//Verifier si l'objet est une instance de Inscription
				if(O instanceof Inscription) {
					Inscription ins=new Inscription();
					ins=(Inscription) O;
					inscrirepo.save(ins);	
				}
		//Verifier si l'objet est une instance de AnneAcademique
				if(O instanceof AnneAcademique) {
					AnneAcademique annaca=new AnneAcademique();
					annaca=(AnneAcademique) O;
					anneeacarepo.save(annaca);	
				}
	}

	@Override
	public Page<Series> listSeries(int page, int size) {
		// TODO Auto-generated method stub
		return serierepo.listSeries(new PageRequest(page, size));
	}

	@Override
	public Series findOneseri(Long idserie) {
		// TODO Auto-generated method stub
		return serierepo.findOne(idserie);
	}

	@Override
	public List<Series> allseries() {
		// TODO Auto-generated method stub
		return serierepo.allseries();
	}

	@Override
	public Long countclasse() {
		// TODO Auto-generated method stub
		return classerepo.count();
	}

	@Override
	public Page<Classe> listClasses(int page, int size) {
		// TODO Auto-generated method stub
		return classerepo.listClasses(new PageRequest(page, size));
	}

	@Override
	public Classe findoneclasse(Long id_classe) {
		// TODO Auto-generated method stub
		return classerepo.findOne(id_classe);
	}

	@Override
	public List<Classe> allclasses() {
		// TODO Auto-generated method stub
		return classerepo.allclasses();
	}

	@Override
	public List<AnneAcademique> allanneeaca() {
		// TODO Auto-generated method stub
		return anneeacarepo.allanneeaca();
	}

	@Override
	public Long counteleves() {
		// TODO Auto-generated method stub
		return eleverepo.count();
	}

	@Override
	public Classe findOneClasse(Long idclasse) {
		// TODO Auto-generated method stub
		return classerepo.findOne(idclasse);
	}

	@Override
	public AnneAcademique findOneAnneeAca(Long idanneeaca) {
		// TODO Auto-generated method stub
		return anneeacarepo.findOne(idanneeaca);
	}

	@Override
	public Eleves derniereleves() {
		// TODO Auto-generated method stub
		return eleverepo.derniereleves();
	}

	@Override
	public Page<Eleves> listEleves(int page, int size) {
		// TODO Auto-generated method stub
		return eleverepo.listEleves(new PageRequest(page, size));
	}

	@Override
	public Eleves findbynin(String nin) {
		// TODO Auto-generated method stub
		return eleverepo.findbynin(nin);
	}

	@Override
	public Eleves findOneeleve(Long ideleves) {
		// TODO Auto-generated method stub
		return eleverepo.findOne(ideleves);
	}

	@Override
	public Page<Inscription> listInscriptions(int page, int size) {
		// TODO Auto-generated method stub
		return inscrirepo.listInscriptions(new PageRequest(page, size));
	}

	@Override
	public Inscription findOneinscription(Long idinscription) {
		// TODO Auto-generated method stub
		return inscrirepo.findOne(idinscription);
	}

	@Override
	public Page<AnneAcademique> listAnneeaca(int page, int size) {
		// TODO Auto-generated method stub
		return anneeacarepo.listAnneeaca(new PageRequest(page, size));
	}

}
