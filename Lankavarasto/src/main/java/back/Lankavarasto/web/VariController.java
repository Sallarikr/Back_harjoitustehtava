package back.Lankavarasto.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import back.Lankavarasto.domain.VariRepository;

@Controller
public class VariController {

	@Autowired
	private VariRepository variRepository;
	
	@GetMapping("/varilista")
	public String naytaVarit(Model model) {
		model.addAttribute("varit", variRepository.findAll());
		return "varilista";
	}
}
