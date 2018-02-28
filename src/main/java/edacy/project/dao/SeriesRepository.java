package edacy.project.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edacy.project.entities.Series;

public interface SeriesRepository extends JpaRepository<Series, Long> {
	@Query("select o from Series o where o.etat=1")
	public Page<Series> listSeries(Pageable pageable);
	@Query("select o from Series o where o.etat=1")
	public List<Series> allseries();
}
