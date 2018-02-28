package edacy.project.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edacy.project.entities.Classe;
import edacy.project.entities.Series;

public interface ClasseRepository extends JpaRepository<Classe, Long> {
	@Query("select o from Classe o where o.etat=1")
	public Page<Classe> listClasses(Pageable pageable);
	@Query("select o from Classe o where o.etat=1")
	public List<Classe> allclasses();
}
