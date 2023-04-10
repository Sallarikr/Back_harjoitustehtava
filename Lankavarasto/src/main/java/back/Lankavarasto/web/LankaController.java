package back.Lankavarasto.web;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import back.Lankavarasto.domain.LankaRepository;

@Controller
public class LankaController {

	@Autowired
	private LankaRepository lankaRepository;
	
	@RequestMapping(value={"/", "index"})
	public String naytaEtusivu() {
		return "index";
	}
	
	@GetMapping("/lankalista")
	public String naytaLangat(Model model) {
		model.addAttribute("langat", lankaRepository.findAll());
		return "lankalista";
	}
	
}
