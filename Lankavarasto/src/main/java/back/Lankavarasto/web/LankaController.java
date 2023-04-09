package back.Lankavarasto.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import back.Lankavarasto.domain.LankaRepository;

@Controller
public class LankaController {

	@GetMapping("/index")
	public String naytaEtusivu() {
		return "Lanka- ja käsityöohjevarasto";
	}
	
	@Autowired
	private LankaRepository lankaRepository;
	
	@GetMapping("/langat")
	public String naytaLangat(Model model) {
		model.addAttribute("langat", lankaRepository.findAll());
		return "lankalista";
	}
	
	
	
	
}
