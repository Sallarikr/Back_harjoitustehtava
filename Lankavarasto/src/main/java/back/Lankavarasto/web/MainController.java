package back.Lankavarasto.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import back.Lankavarasto.domain.AppUserRepository;
import back.Lankavarasto.domain.Lanka;
import back.Lankavarasto.domain.LankaRepository;
import back.Lankavarasto.domain.Ohje;
import back.Lankavarasto.domain.OhjeRepository;
import back.Lankavarasto.domain.Vari;
import back.Lankavarasto.domain.VariRepository;

@Controller
public class MainController {

	@Autowired
	LankaRepository lankaRepository;
	@Autowired
	OhjeRepository ohjeRepository;
	@Autowired
	VariRepository variRepository;
	@Autowired
	AppUserRepository appUserRepository;
	
	@GetMapping("/login")
	public String login() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
			return "login";
		}
		return "redirect:/";
	}
	
	
	@GetMapping(value={"/"})
	public String naytaEtusivu() {
		return "index";
	}
	
	@GetMapping("/lankalista")
	public String naytaLangat(Model model) {
		model.addAttribute("langat", lankaRepository.findAll());
		return "lankalista";
	}
	
	@GetMapping("/lisaaLanka")
	public String lisaaLanka(Model model) {
		model.addAttribute("lisaaUusiLanka", new Lanka());
		return "lisaaLanka";
	}
	
	@PostMapping("/tallennaLanka")
	public String tallennaLanka(Lanka lanka) {
		lankaRepository.save(lanka);
		return "redirect:/lankalista";
	}
	
	@GetMapping("/muokkaaLankaa/{id}")
	public String muokkaaLankaa(@PathVariable("id") Long id, Model model) {
		model.addAttribute("muokkaaLankaa", lankaRepository.findById(id));
		return "muokkaaLankaa";
	}
	
	@GetMapping("/poistaLanka/{id}")
	public String poistaLanka(@PathVariable("id") Long id, Model model) {
		lankaRepository.deleteById(id);
		return "redirect:/lankalista";
	}

	@GetMapping("/varilista")
	public String naytaVarit(Model model) {
		model.addAttribute("varit", variRepository.findAll());
		return "varilista";
	}	

	@GetMapping("/langanVarit/{id}")
	public String naytaVarit(@PathVariable("id") Long id, Model model) {
		model.addAttribute("vari", variRepository.findById(id));
		return "langanVarit";
	}	
	
	@GetMapping("/lisaaVari")
	public String lisaaVari(Model model) {
		model.addAttribute("lisaaUusiVari", new Vari());
		model.addAttribute("langat", lankaRepository.findAll());
		return "lisaaVari";
	}
	
	@PostMapping("/tallennaVari")
	public String tallennaVari(Vari vari) {
		variRepository.save(vari);
		return "redirect:/varilista";
	}

	@GetMapping("/muokkaaVaria/{id}")
	public String muokkaaVaria(@PathVariable("id") Long id, Model model) {
		model.addAttribute("muokkaaVaria", variRepository.findById(id));
		model.addAttribute("langat", lankaRepository.findAll());
		return "muokkaaVaria";
	}
	
	@GetMapping("/poistaVari/{id}")
	public String poistaVari(@PathVariable("id") Long id, Model model) {
		variRepository.deleteById(id);
		return "redirect:/varilista";
	}

	
	
	@GetMapping("/ohjelista")
	public String naytaOhjeet(Model model) {
		model.addAttribute("ohjeet", ohjeRepository.findAll());
		return "ohjelista";
	}

	@GetMapping("/lisaaOhje")
	public String lisaaOhje(Model model) {
		model.addAttribute("lisaaUusiOhje", new Ohje());
		return "lisaaOhje";
	}
	
	@PostMapping("/tallennaOhje")
	public String tallennaOhje(Ohje ohje) {
		ohjeRepository.save(ohje);
		return "redirect:/ohjelista";
	}
	
	@GetMapping("/muokkaaOhjetta/{id}")
	public String muokkaaOhjetta(@PathVariable("id") Long id, Model model) {
		model.addAttribute("muokkaaOhjetta", ohjeRepository.findById(id));
		return "muokkaaOhjetta";
	}
	
	@GetMapping("/poistaOhje/{id}")
	public String poistaOhje(@PathVariable("id") Long id, Model model) {
		ohjeRepository.deleteById(id);
		return "redirect:/ohjelista";
	}
}
