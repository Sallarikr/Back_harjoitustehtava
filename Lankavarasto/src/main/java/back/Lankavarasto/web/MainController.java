package back.Lankavarasto.web;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import back.Lankavarasto.domain.AppUserRepository;
import back.Lankavarasto.domain.Lanka;
import back.Lankavarasto.domain.LankaRepository;
import back.Lankavarasto.domain.Ohje;
import back.Lankavarasto.domain.OhjeRepository;
import back.Lankavarasto.domain.Vari;
import back.Lankavarasto.domain.VariRepository;
import back.Lankavarasto.service.LankaService;

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
	@Autowired
	LankaService lankaService;
	
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
	public String naytaLangat(Model model, @Param("haku") String haku) {
		model.addAttribute("langat", lankaRepository.findAll());
		model.addAttribute("varit", variRepository.findAll());
		List<Lanka> langat = lankaService.listAll2(haku);
		model.addAttribute("langat", langat);
		model.addAttribute("haku", haku);
		return "lankalista";
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")	
	@GetMapping("/lisaaLanka")
	public String lisaaLanka(Model model) {
		model.addAttribute("lisaaUusiLanka", new Lanka());
		return "lisaaLanka";
	}
	
	@PostMapping("/tallennaLanka")
	public String tallennaLanka(@Valid @ModelAttribute("lisaaUusiLanka") Lanka lanka, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "lisaaLanka";
		}
		lankaRepository.save(lanka);
		return "redirect:/lankalista";
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("/muokkaaLankaa/{id}")
	public String muokkaaLankaa(@PathVariable("id") Long id, Model model) {
		model.addAttribute("muokkaaLankaa", lankaRepository.findById(id));
		return "muokkaaLankaa";
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("/poistaLanka/{id}")
	public String poistaLanka(@PathVariable("id") Long id, Model model) {
		lankaRepository.deleteById(id);
		return "redirect:/lankalista";
	}

	@GetMapping("/varilista")
	public String naytaVarit(Model model, @Param("haku") String haku) {
		List<Vari> varit = lankaService.listAll(haku);
		model.addAttribute("varit", varit);
		model.addAttribute("haku", haku);
		return "varilista";		
	}	
		
	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("/lisaaVari")
	public String lisaaVari(Model model) {
		model.addAttribute("lisaaUusiVari", new Vari());
		model.addAttribute("langat", lankaRepository.findAll());
		return "lisaaVari";
	}
	
	@PostMapping("/tallennaVari")
	public String tallennaVari(@Valid @ModelAttribute("lisaaUusiVari") Vari vari, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "lisaaVari";
		}
		variRepository.save(vari);
		return "redirect:/varilista";
	}

	
	
	
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("/muokkaaVaria/{id}")
	public String muokkaaVaria(@PathVariable("id") Long id, Model model) {
		model.addAttribute("muokkaaVaria", variRepository.findById(id));
		model.addAttribute("langat", lankaRepository.findAll());
		return "muokkaaVaria";
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("/poistaVari/{id}")
	public String poistaVari(@PathVariable("id") Long id, Model model) {
		variRepository.deleteById(id);
		return "redirect:/varilista";
	}

	
	
	@GetMapping("/ohjelista")
	public String naytaOhjeet(Model model, @Param("haku") String haku) {
		model.addAttribute("ohjeet", ohjeRepository.findAll());
		List<Ohje> ohjeet = lankaService.listAll3(haku);
		model.addAttribute("ohjeet", ohjeet);
		model.addAttribute("haku", haku);
		return "ohjelista";
	}

	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("/lisaaOhje")
	public String lisaaOhje(Model model) {
		model.addAttribute("lisaaUusiOhje", new Ohje());
		return "lisaaOhje";
	}
	
	@PostMapping("/tallennaOhje")
	public String tallennaOhje(@Valid @ModelAttribute("lisaaUusiOhje") Ohje ohje, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "lisaaOhje";
		}
		ohjeRepository.save(ohje);
		return "redirect:/ohjelista";
	}

	
	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("/muokkaaOhjetta/{id}")
	public String muokkaaOhjetta(@PathVariable("id") Long id, Model model) {
		model.addAttribute("muokkaaOhjetta", ohjeRepository.findById(id));
		return "muokkaaOhjetta";
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("/poistaOhje/{id}")
	public String poistaOhje(@PathVariable("id") Long id, Model model) {
		ohjeRepository.deleteById(id);
		return "redirect:/ohjelista";
	}
	
	@ExceptionHandler(RuntimeException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public String handleRuntimeException(Model model, RuntimeException ex) {
		model.addAttribute("virhe", ex.getMessage());
		return "error";
	}


}
