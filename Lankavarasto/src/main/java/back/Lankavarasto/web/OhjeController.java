package back.Lankavarasto.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import back.Lankavarasto.domain.OhjeRepository;

@Controller
public class OhjeController {

	@Autowired
	private OhjeRepository ohjeRepository;
	
	@GetMapping("/ohjelista")
	public String naytaOhjeet(Model model) {
		model.addAttribute("ohjeet", ohjeRepository.findAll());
		return "ohjelista";
	}	
}

