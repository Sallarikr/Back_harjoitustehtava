package back.Lankavarasto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import back.Lankavarasto.domain.LankaRepository;

@SpringBootApplication
public class LankavarastoApplication {
	
	@Autowired LankaRepository lankaRepository;

	public static void main(String[] args) {
		SpringApplication.run(LankavarastoApplication.class, args);
	}

}
