package back.Lankavarasto.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;

@Entity
public class Lanka {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name = "lanka_id")
	private Long id;

	@Size(min = 2, max = 50, message = "Sallittu pituus on 2-50 merkkiä")
	private String merkki, malli;

	private String koostumus, luokittelu, neuletiheys, suositus;

	private int paino, pituus;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "lanka")
	@JsonIgnore
	private List<Vari> varit;

	public Lanka() {
		super();
	}

	public Lanka(String merkki, String malli, String koostumus, String luokittelu, String neuletiheys,
			String suositus, int paino, int pituus) {
		super();
		this.merkki = merkki;
		this.malli = malli;
		this.koostumus = koostumus;
		this.luokittelu = luokittelu;
		this.neuletiheys = neuletiheys;
		this.suositus = suositus;
		this.paino = paino;
		this.pituus = pituus;
	}


	public Lanka(String merkki, String malli, String koostumus, String luokittelu, String neuletiheys,
			String suositus, int paino, int pituus, List<Vari> varit) {
		super();
		this.merkki = merkki;
		this.malli = malli;
		this.koostumus = koostumus;
		this.luokittelu = luokittelu;
		this.neuletiheys = neuletiheys;
		this.suositus = suositus;
		this.paino = paino;
		this.pituus = pituus;
		this.varit = varit;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMerkki() {
		return merkki;
	}

	public void setMerkki(String merkki) {
		this.merkki = merkki;
	}

	public String getMalli() {
		return malli;
	}

	public void setMalli(String malli) {
		this.malli = malli;
	}

	public String getKoostumus() {
		return koostumus;
	}

	public void setKoostumus(String koostumus) {
		this.koostumus = koostumus;
	}

	public String getLuokittelu() {
		return luokittelu;
	}

	public void setLuokittelu(String luokittelu) {
		this.luokittelu = luokittelu;
	}

	public String getNeuletiheys() {
		return neuletiheys;
	}

	public void setNeuletiheys(String neuletiheys) {
		this.neuletiheys = neuletiheys;
	}

	public String getSuositus() {
		return suositus;
	}

	public void setSuositus(String suositus) {
		this.suositus = suositus;
	}

	public int getPaino() {
		return paino;
	}

	public void setPaino(int paino) {
		this.paino = paino;
	}

	public int getPituus() {
		return pituus;
	}

	public void setPituus(int pituus) {
		this.pituus = pituus;
	}

	public List<Vari> getVarit() {
		return varit;
	}

	public void setVarit(List<Vari> varit) {
		this.varit = varit;
	}

	@Override
	public String toString() {
		return "Lanka [id=" + id + ", merkki=" + merkki + ", malli=" + malli + ", koostumus=" + koostumus
				+ ", luokittelu=" + luokittelu + ", neuletiheys=" + neuletiheys + ", suositus=" + suositus + ", paino="
				+ paino + ", pituus=" + pituus + "]";
	}
}