package back.Lankavarasto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import back.Lankavarasto.domain.Lanka;
import back.Lankavarasto.domain.LankaRepository;
import back.Lankavarasto.domain.Ohje;
import back.Lankavarasto.domain.OhjeRepository;
import back.Lankavarasto.domain.Vari;
import back.Lankavarasto.domain.VariRepository;

@Service
public class LankaService {

	@Autowired
	VariRepository variRepository;

	public List<Vari> listAll(String haku) {
		if (haku != null) {
			return variRepository.hae(haku);
		}
		return variRepository.findAll();
	}

	@Autowired
	LankaRepository lankaRepository;

	public List<Lanka> listAll2(String haku) {
		if (haku != null) {
			return lankaRepository.hae(haku);
		}
		return lankaRepository.findAll();
	}

	@Autowired
	OhjeRepository ohjeRepository;

	public List<Ohje> listAll3(String haku) {
		if (haku != null) {
			return ohjeRepository.hae(haku);
		}
		return ohjeRepository.findAll();
	}
}
