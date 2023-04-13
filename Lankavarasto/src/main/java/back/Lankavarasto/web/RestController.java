package back.Lankavarasto.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import back.Lankavarasto.domain.AppUser;
import back.Lankavarasto.domain.AppUserRepository;
import back.Lankavarasto.domain.Lanka;
import back.Lankavarasto.domain.LankaRepository;
import back.Lankavarasto.domain.Ohje;
import back.Lankavarasto.domain.OhjeRepository;
import back.Lankavarasto.domain.Vari;
import back.Lankavarasto.domain.VariRepository;

@Controller
public class RestController {

	@Autowired
	LankaRepository lankaRepository;
	@Autowired
	OhjeRepository ohjeRepository;
	@Autowired
	VariRepository variRepository;
	@Autowired
	AppUserRepository appUserRepository;

	@GetMapping("/langat")
	public @ResponseBody List<Lanka> naytaRestLangat() {
		return (List<Lanka>) lankaRepository.findAll();
	}
	
	@RequestMapping(value="/lanka/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Lanka> haeRestLanka(@PathVariable("id") Long id) {	
    	return lankaRepository.findById(id);
    }       

	@GetMapping("/ohjeet")
	public @ResponseBody List<Ohje> naytaRestOhjeet() {
		return (List<Ohje>) ohjeRepository.findAll();
	}
	
	@RequestMapping(value="/ohje/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Ohje> haeRestOhje(@PathVariable("id") Long id) {	
    	return ohjeRepository.findById(id);
    }       
	
	@GetMapping("/varit")
	public @ResponseBody List<Vari> naytaRestVarit() {
		return (List<Vari>) variRepository.findAll();
	}

	@RequestMapping(value="/vari/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Vari> haeRestVari(@PathVariable("id") Long id) {	
    	return variRepository.findById(id);
    }

	@GetMapping("/userit")
	public @ResponseBody List<AppUser> naytaRestUserit() {
		return (List<AppUser>) appUserRepository.findAll();
	}

	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value="/user/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<AppUser> haeRestUser(@PathVariable("id") Long id) {	
    	return appUserRepository.findById(id);
    }
}
