package back.Lankavarasto.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import back.Lankavarasto.domain.LankaRepository;
import back.Lankavarasto.domain.OhjeRepository;
import back.Lankavarasto.domain.VariRepository;

@Controller
public class YleisController {

	@Autowired
	LankaRepository lankaRepository;
	@Autowired
	OhjeRepository ohjeRepository;
	@Autowired
	VariRepository variRepository;
	
	
	@GetMapping(value={"/", "index"})
	public String naytaEtusivu() {
		return "index";
	}
	
	@GetMapping("/lankalista")
	public String naytaLangat(Model model) {
		model.addAttribute("langat", lankaRepository.findAll());
		return "lankalista";
	}
	

	@GetMapping("/ohjelista")
	public String naytaOhjeet(Model model) {
		model.addAttribute("ohjeet", ohjeRepository.findAll());
		return "ohjelista";
	}
	

	@GetMapping("/varilista")
	public String naytaVarit(Model model) {
		model.addAttribute("varit", variRepository.findAll());
		return "varilista";
	}	
}
