package back.Lankavarasto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import back.Lankavarasto.domain.LankaRepository;
import back.Lankavarasto.domain.OhjeRepository;
import back.Lankavarasto.domain.VariRepository;

@SpringBootApplication
public class LankavarastoApplication {

	@Autowired
	LankaRepository lankaRepository;
	@Autowired
	OhjeRepository ohjeRepository;
	@Autowired
	VariRepository variRepository;

	public static void main(String[] args) {
		SpringApplication.run(LankavarastoApplication.class, args);
	}
}