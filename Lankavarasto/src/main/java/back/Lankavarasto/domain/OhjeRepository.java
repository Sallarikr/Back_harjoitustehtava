package back.Lankavarasto.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OhjeRepository extends JpaRepository<Ohje, Long> {

	@Query("SELECT o FROM Ohje o WHERE o.suunnittelija LIKE %?1%" + " OR o.nimi LIKE %?1%" + " OR o.lahde LIKE %?1%"
			+ " OR o.luokittelu LIKE %?1%")

	public List<Ohje> hae(String haku);
}