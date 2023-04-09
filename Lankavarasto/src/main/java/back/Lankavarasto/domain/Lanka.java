package back.Lankavarasto.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;

@Entity
public class Lanka {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name="lanka_id")
	private Long id;
	
	private String merkki, malli, koostumus, luokittelu, neuletiheys, suositus;

	private int paino, pituus, pesuohje;

	public Lanka() {
		super();
	}

	public Lanka(Long id, String merkki, String malli, String koostumus, String luokittelu, String neuletiheys,
			String suositus, int paino, int pituus, int pesuohje) {
		super();
		this.id = id;
		this.merkki = merkki;
		this.malli = malli;
		this.koostumus = koostumus;
		this.luokittelu = luokittelu;
		this.neuletiheys = neuletiheys;
		this.suositus = suositus;
		this.paino = paino;
		this.pituus = pituus;
		this.pesuohje = pesuohje;
	}

	public Lanka(String merkki, String malli, String koostumus, String luokittelu, String neuletiheys,
			String suositus, int paino, int pituus, int pesuohje) {
		super();
		this.merkki = merkki;
		this.malli = malli;
		this.koostumus = koostumus;
		this.luokittelu = luokittelu;
		this.neuletiheys = neuletiheys;
		this.suositus = suositus;
		this.paino = paino;
		this.pituus = pituus;
		this.pesuohje = pesuohje;
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

	public int getPesuohje() {
		return pesuohje;
	}

	public void setPesuohje(int pesuohje) {
		this.pesuohje = pesuohje;
	}

	@Override
	public String toString() {
		return "Lanka [id=" + id + ", merkki=" + merkki + ", malli=" + malli + ", koostumus=" + koostumus
				+ ", luokittelu=" + luokittelu + ", neuletiheys=" + neuletiheys + ", suositus=" + suositus + ", paino="
				+ paino + ", pituus=" + pituus + ", pesuohje=" + pesuohje + "]";
	}
}