package back.Lankavarasto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import back.Lankavarasto.domain.AppUser;
import back.Lankavarasto.domain.AppUserRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class AppUserRepositoryTests {

	@Autowired
	AppUserRepository appUserRepository;

	@Test
	public void etsiUser() {
		AppUser appUser = appUserRepository.findByUsername("admin");
		assertThat(appUser.getUsername().equals("admin"));
	}
}
