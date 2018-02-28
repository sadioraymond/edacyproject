package edacy.project.web;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edacy.project.entities.AnneAcademique;
import edacy.project.entities.Classe;
import edacy.project.entities.Eleves;
import edacy.project.entities.Inscription;
import edacy.project.entities.Series;
import edacy.project.metier.IEdacy;

@Controller
public class EdacyController {

	@Autowired
	private IEdacy iedacy;

	@RequestMapping(value = "/acceuil")
	public String acceuil() {
		return "acceuil";
	}

	@RequestMapping("/ajoutseries")
	public String ajoutseries() {
		return "ajout_serie";
	}

	@RequestMapping("/saveSerie")
	public String saveSerie(Model model, String libelle) {
		Series s = new Series();
		s.setLibelle(libelle);
		s.setEtat(1);
		iedacy.save(s);
		return "redirect:ajoutseries";
	}

	@RequestMapping("/allseries")
	public String allseries(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "30") int size) {
		Page<Series> pageSeries = iedacy.listSeries(page, size);
		model.addAttribute("listseriess", pageSeries.getContent());
		int[] pages = new int[pageSeries.getTotalPages()];
		model.addAttribute("pages", pages);
		return "listseries";
	}

	@RequestMapping("/modifierserie")
	public String modifierserie(Model model, @RequestParam(name = "id_serie") Long id_serie) {
		Series se = new Series();
		se = iedacy.findOneseri(id_serie);
		model.addAttribute("libelle", se.getLibelle());
		model.addAttribute("id_serie", se.getIdseries());
		return "modifserie";
	}

	@RequestMapping("/updateSerie")
	public String updateSerie(Model model, String libelle, Long id_serie) {
		Series s = new Series();
		s = iedacy.findOneseri(id_serie);
		s.setLibelle(libelle);
		iedacy.save(s);
		return "redirect:allseries";
	}

	@RequestMapping("/supprimerserie")
	public String supprimerserie(Model model, @RequestParam(name = "id_serie") Long id_serie) {
		Series se = new Series();
		se = iedacy.findOneseri(id_serie);
		se.setEtat(0);
		;
		iedacy.save(se);
		return "redirect:allseries";
	}

	@RequestMapping("/ajoutclasse")
	public String ajoutclasse(Model model) {
		List<Series> listseries = iedacy.allseries();
		model.addAttribute("listseries", listseries);
		return "ajoutclasse";
	}

	@RequestMapping("/saveClasse")
	public String saveClasse(Model model, String nomclasse,
			@RequestParam(name = "optionsListIds") Long optionsListIds) {
		Classe cl = new Classe();
		cl.setNomclasse(nomclasse);
		cl.setEtat(1);
		Series se = new Series();
		se = iedacy.findOneseri(optionsListIds);
		cl.setSeriess(se);
		Long nbr = iedacy.countclasse();
		String codeclasse = "CL" + nbr;
		cl.setCodeclasse(codeclasse);
		iedacy.save(cl);
		return "redirect:ajoutclasse";
	}

	@RequestMapping("/allclasse")
	public String allclasse(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "30") int size) {
		Page<Classe> pageClasse = iedacy.listClasses(page, size);
		model.addAttribute("listClasses", pageClasse.getContent());
		int[] pages = new int[pageClasse.getTotalPages()];
		model.addAttribute("pages", pages);
		return "listclasse";
	}

	@RequestMapping("/modifierclasse")
	public String modifierclasse(Model model, @RequestParam(name = "id_classe") Long id_classe) {
		Classe cl = new Classe();
		cl = iedacy.findoneclasse(id_classe);
		model.addAttribute("id_classe", cl.getIdclasse());
		model.addAttribute("nomclasse", cl.getNomclasse());
		List<Series> listseries = iedacy.allseries();
		model.addAttribute("listseries", listseries);
		model.addAttribute("series", cl.getSeriess());
		return "modifclasse";
	}

	@RequestMapping("/updateClasse")
	public String updateClasse(Model model, String nomclasse,
			@RequestParam(name = "optionsListIds") Long optionsListIds, Long id_classe) {
		Classe cl = new Classe();
		cl = iedacy.findoneclasse(id_classe);
		cl.setNomclasse(nomclasse);
		Series s = new Series();
		s = iedacy.findOneseri(optionsListIds);
		cl.setSeriess(s);
		iedacy.save(cl);
		return "redirect:allclasse";
	}

	@RequestMapping("/supprimerclasse")
	public String supprimerclasse(Model model, @RequestParam(name = "id_classe") Long id_classe) {
		Classe cl = new Classe();
		cl = iedacy.findoneclasse(id_classe);
		cl.setEtat(0);
		;
		iedacy.save(cl);
		return "redirect:allclasse";
	}

	@RequestMapping("/inscription")
	public String inscription(Model model) {
		List<Classe> listclasses = iedacy.allclasses();
		model.addAttribute("listclasses", listclasses);
		List<AnneAcademique> listannees = iedacy.allanneeaca();
		model.addAttribute("listannees", listannees);
		return "inscription";
	}

	@RequestMapping("saveInscrption")
	public String saveInscrption(Model model, String nom, String prenom, String nin,
			@RequestParam(name = "optionsListIds") Long optionsListIds, String adresse, String tel, String email,
			@RequestParam(name = "optionsListId") Long optionsListId) {
			Long nbre = iedacy.counteleves();
			String codee = "EL" + nbre;
			Eleves e = new Eleves(nom, prenom, adresse, tel, nin, codee, email, 1, new Date());
			iedacy.save(e);
			Eleves el = iedacy.derniereleves();
			AnneAcademique an = iedacy.findOneAnneeAca(optionsListIds);
			Classe cl = iedacy.findOneClasse(optionsListId);
			Inscription ins = new Inscription(new Date(), cl, el, an,1);
			iedacy.save(ins);
		return "redirect:inscription";
	}

	@RequestMapping("/alleleves")
	public String alleleves(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "30") int size) {
		Page<Eleves> pageEleves = iedacy.listEleves(page, size);
		model.addAttribute("listEleves", pageEleves.getContent());
		int[] pages = new int[pageEleves.getTotalPages()];
		model.addAttribute("pages", pages);
		return "listEleve";
	}
	@RequestMapping("/modifiereleve")
	public String modifiereleve(Model model, @RequestParam(name = "id_eleves") Long id_eleves) {
		Eleves el= new Eleves();
		el=iedacy.findOneeleve(id_eleves);
		model.addAttribute("adresse", el.getAdresse());
		model.addAttribute("nom", el.getNom());
		model.addAttribute("prenom", el.getPrenom());
		model.addAttribute("nin", el.getNin());
		model.addAttribute("tel", el.getTel());
		model.addAttribute("email", el.getEmail());
		model.addAttribute("id_eleves", el.getIdeleves());
		return "modifeleve";
	}
	@RequestMapping("/updateeleve")
	public String updateeleve(Model model,Long id_eleves,String nom,
			String prenom, String tel, String adresse, String nin, String email) {
			Eleves el= new Eleves();
			el=iedacy.findOneeleve(id_eleves);
			el.setNom(nom);
			el.setPrenom(prenom);
			el.setAdresse(adresse);
			el.setNin(nin);
			el.setTel(tel);
			el.setEmail(email);
			iedacy.save(el);
		return "redirect:alleleves";
	}
	@RequestMapping("/supprimereleve")
	public String supprimereleve(Model model, @RequestParam(name = "id_eleves") Long id_eleves) {
		Eleves el= new Eleves();
		el=iedacy.findOneeleve(id_eleves);
		el.setEtat(0);
		iedacy.save(el);
		return "redirect:alleleves";
	}
	@RequestMapping("/allinscriptions")
	public String allinscriptions(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "30") int size) {
		Page<Inscription> pageInscription = iedacy.listInscriptions(page, size);
		model.addAttribute("listInscriptions", pageInscription.getContent());
		int[] pages = new int[pageInscription.getTotalPages()];
		model.addAttribute("pages", pages);
		return "listInscription";
	}
	@RequestMapping("/modifierinscription")
	public String modifierinscription(Model model, @RequestParam(name = "idinscription") Long idinscription) {
		Inscription ins=new Inscription();
		ins=iedacy.findOneinscription(idinscription);
		model.addAttribute("idinscription", ins.getIdinscription());
		List<Classe> listclasses = iedacy.allclasses();
		model.addAttribute("listclasses", listclasses);
		model.addAttribute("nom", ins.getEleves().getNom());
		model.addAttribute("prenom", ins.getEleves().getPrenom());
		model.addAttribute("nin", ins.getEleves().getNin());
		return "modifinscription";
	}
	@RequestMapping("/updateInscrption")
	public String updateInscrption(Model model, String nomclasse,
			@RequestParam(name = "optionsListIds") Long optionsListIds, Long idinscription) {
		Inscription ins=new Inscription();
		ins=iedacy.findOneinscription(idinscription);
		Classe cl=new Classe();
		cl=iedacy.findoneclasse(optionsListIds);
		ins.setClasses(cl);
		iedacy.save(ins);
		return "redirect:allinscriptions";
	}
	@RequestMapping("/supprimeinscription")
	public String supprimeinscription(Model model, @RequestParam(name = "idinscription") Long idinscription) {
		Inscription ins=new Inscription();
		ins=iedacy.findOneinscription(idinscription);
		ins.setEtat(0);
		iedacy.save(ins);
		return "redirect:allinscriptions";
	}
	@RequestMapping("/ajoutanneeaca")
	public String ajoutanneeaca() {
		return "ajoutanneeaca";
	}
	@RequestMapping("/saveAnneeAca")
	public String saveAnneeAca(Model model,String annee) {
		AnneAcademique an=new AnneAcademique();
		an.setAnneeaca(annee);
		an.setTermine(0);
		an.setEtat(1);
		iedacy.save(an);
		return "ajoutanneeaca";
	}
	@RequestMapping("/allanneaca")
	public String allanneaca(Model model, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "30") int size) {
		Page<AnneAcademique> pageAnneeAca = iedacy.listAnneeaca(page, size);
		model.addAttribute("listAnneeaca", pageAnneeAca.getContent());
		int[] pages = new int[pageAnneeAca.getTotalPages()];
		model.addAttribute("pages", pages);
		return "listAnneeaca";
	}
	@RequestMapping(value="/findoneanneeac")
	public String findoneanneeac(Model model,@RequestParam(name="idanneeaca")Long idanneeaca) {
		AnneAcademique an=new AnneAcademique();
		an=iedacy.findOneAnneeAca(idanneeaca);
		if(an.getTermine()==0) {
			an.setTermine(1);
			iedacy.save(an);
		}else {
			an.setTermine(0);
			iedacy.save(an);
		}
		return "redirect:allanneaca";
	}
	@RequestMapping(value="/supprimeranneeaca")
	public String supprimeranneeaca(Model model,@RequestParam(name="idanneeaca")Long idanneeaca) {
		AnneAcademique an=new AnneAcademique();
		an=iedacy.findOneAnneeAca(idanneeaca);
			an.setEtat(0);
			iedacy.save(an);
		return "redirect:allanneaca";
	}
	@RequestMapping(value="/modifieranneeaca")
	public String modifieranneeaca(Model model,@RequestParam(name="idanneeaca")Long idanneeaca) {
		AnneAcademique an=new AnneAcademique();
		an=iedacy.findOneAnneeAca(idanneeaca);
		model.addAttribute("anneeaca", an.getAnneeaca());
		model.addAttribute("idanneeaca", an.getIdanneeaca());
		return "modifanneeaca";
	}
	@RequestMapping("/updateAnneeAca")
	public String updateAnneeAca(Model model,String anneeaca,Long idanneeaca) {
		AnneAcademique an=new AnneAcademique();
		an=iedacy.findOneAnneeAca(idanneeaca);
		an.setAnneeaca(anneeaca);
		iedacy.save(an);
		return "redirect:allanneaca";
	}
}
