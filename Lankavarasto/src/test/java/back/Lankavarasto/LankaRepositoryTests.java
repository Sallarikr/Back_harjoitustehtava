package back.Lankavarasto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import back.Lankavarasto.domain.Lanka;
import back.Lankavarasto.domain.LankaRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class LankaRepositoryTests {

	@Autowired
	LankaRepository lankaRepository;
	
	@Test
	public void lisaaLanka() {
		Lanka lanka = new Lanka("merkki", "malli", "koostumus", "luokittelu", "neuletiheys", "suositus", 100, 200);
		lankaRepository.save(lanka);
		assertThat(lanka.getId()).isNotNull();
	}


	public void etsiLanka() {
		List<Lanka> langat = lankaRepository.findByMalli("7 veljestä");
		assertThat(langat).hasSize(1);
		assertThat(langat.get(0).getMalli()).isEqualTo("7 veljestä");
	}

	@Test
	public void poistaLanka() {
		List<Lanka> langat = lankaRepository.findByMalli("7 veljestä");
		Lanka lanka = langat.get(0);
		lankaRepository.delete(lanka);
		List<Lanka> langanPoisto = lankaRepository.findByMalli("7 veljestä");
		assertThat(langanPoisto).hasSize(0);
	}
}