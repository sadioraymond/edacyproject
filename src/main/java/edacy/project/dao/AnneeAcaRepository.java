package edacy.project.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edacy.project.entities.AnneAcademique;

public interface AnneeAcaRepository extends JpaRepository<AnneAcademique, Long>{
	@Query("select o from AnneAcademique o where o.termine=0 and o.etat=1")
	public List<AnneAcademique> allanneeaca();
	@Query("select o from AnneAcademique o where o.etat=1")
	public Page<AnneAcademique> listAnneeaca(Pageable pageable);
}
