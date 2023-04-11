package back.Lankavarasto.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VariRepository extends JpaRepository<Vari, Long>{
	

	public	List<Vari> findBySavy(String savy);
	
}
