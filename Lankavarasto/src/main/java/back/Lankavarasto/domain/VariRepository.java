package back.Lankavarasto.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface VariRepository extends JpaRepository<Vari, Long>{
	
	@Query("SELECT v FROM Vari v WHERE v.savy LIKE %?1%"
            + " OR v.maara LIKE %?1%"
            + " OR v.lanka.merkki LIKE %?1%"
            + " OR v.lanka.malli LIKE %?1%"
)

	public	List<Vari> hae(String haku);
	
}
