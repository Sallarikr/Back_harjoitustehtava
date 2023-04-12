package back.Lankavarasto.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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

	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("/restLangat")
	public @ResponseBody List<Lanka> naytaRestLangat(){
		return (List<Lanka>) lankaRepository.findAll();
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("/restOhjeet")
	public @ResponseBody List<Ohje> naytaRestOhjeet(){
		return (List<Ohje>) ohjeRepository.findAll();
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("/restVarit")
	public @ResponseBody List<Vari> naytaRestVarit(){
		return (List<Vari>) variRepository.findAll();
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("/restUserit")
	public @ResponseBody List<AppUser> naytaRestUserit(){
		return (List<AppUser>) appUserRepository.findAll();
	}
	
	
}
