package edacy.project.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edacy.project.entities.Inscription;

public interface InscriptionRepository extends JpaRepository<Inscription, Long>{
	@Query("select o from Inscription o where o.etat=1")
	public Page<Inscription> listInscriptions(Pageable pageable);
}
