package back.Lankavarasto.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LankaController {

	@RequestMapping("/index")
	@ResponseBody
	public String naytaEtusivu() {
		return "Lanka- ja käsityöohjevarasto";
	}
}
