package back.Lankavarasto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import back.Lankavarasto.domain.Lanka;
import back.Lankavarasto.domain.Vari;
import back.Lankavarasto.domain.VariRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class VariRepositoryTests {

	@Autowired
	VariRepository variRepository;

	public void etsiVari() {
		List<Vari> varit = variRepository.findBySavy("Auringonkukka");
		assertThat(varit).hasSize(1);
		assertThat(varit.get(0).getSavy()).isEqualTo("Auringonkukka");
	}


	@Test
	public void lisaaVari() {
		Vari vari = new Vari("savy", 100, new Lanka("merkki", "malli", "koostumus", "luokittelu", "neuletiheys", "suositus", 100, 200));
		variRepository.save(vari);
		assertThat(vari.getId()).isNotNull();
	}

	
	@Test
	public void poistaVari() {
		List<Vari> varit = variRepository.findBySavy("Auringonkukka");
		Vari vari = varit.get(0);
		variRepository.delete(vari);
		List<Vari> varinPoisto = variRepository.findBySavy("Auringonkukka");
		assertThat(varinPoisto).hasSize(0);
	}
}
