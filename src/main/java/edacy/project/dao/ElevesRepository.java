package edacy.project.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import edacy.project.entities.Eleves;

public interface ElevesRepository extends JpaRepository<Eleves, Long>{
	@Query(nativeQuery = true,value="select * from eleves order by dateenr desc limit 1")
	public Eleves derniereleves();
	@Query(nativeQuery = true,value="select * from eleves where nin=:x and etat=1")
	public Eleves findbynin(@Param("x")String nin);
	@Query("select o from Eleves o where o.etat=1")
	public Page<Eleves> listEleves(Pageable pageable);
}
