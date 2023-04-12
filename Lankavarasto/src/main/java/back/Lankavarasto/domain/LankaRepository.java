package back.Lankavarasto.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LankaRepository extends JpaRepository<Lanka, Long> {

	@Query("SELECT l FROM Lanka l WHERE l.merkki LIKE %?1%" + " OR l.malli LIKE %?1%" + " OR l.koostumus LIKE %?1%"
			+ " OR l.luokittelu LIKE %?1%" + " OR l.neuletiheys LIKE %?1%" + " OR l.suositus LIKE %?1%"
			+ " OR l.paino LIKE %?1%" + " OR l.pituus LIKE %?1%")

	public List<Lanka> hae(String haku);
}