package back.Lankavarasto;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import back.Lankavarasto.domain.Ohje;
import back.Lankavarasto.domain.OhjeRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class OhjeRepositoryTests {

	@Autowired
	OhjeRepository ohjeRepository;

	@Test
	public void lisaaOhje() {
		Ohje ohje = new Ohje("suunnittelija", "nimi", "lahde", "lanka");
		ohjeRepository.save(ohje);
		assertNotEquals(ohje.getId(), null);
	}

	@Test
	public void poistaOhje() {
		Ohje ohje = new Ohje("suunnittelija", "nimi", "lahde", "lanka");
		ohjeRepository.save(ohje);
		Long id = ohje.getId();
		assertNotNull(id);
		ohjeRepository.delete(ohje);

		Ohje ohjeenPoisto = ohjeRepository.findById(id).orElse(null);
		assertNull(ohjeenPoisto);
	}
}
