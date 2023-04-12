package back.Lankavarasto.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface VariRepository extends CrudRepository<Vari, Long>{
	

	public	List<Vari> findBySavy(String savy);
	
}
