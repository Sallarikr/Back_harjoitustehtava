package back.Lankavarasto.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

	public interface LankaRepository extends CrudRepository<Lanka, Long>{
		List<Lanka> findByMalli(String malli);
		
	}
